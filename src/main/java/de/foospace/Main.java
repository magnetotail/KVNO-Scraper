package de.foospace;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static Pattern addressAndPhonePattern = Pattern.compile(".*Adresse & Kontakt (.*) Tel\\.: (\\(\\d*\\) \\d*).*");
    static Pattern addressPattern = Pattern.compile(".*Adresse & Kontakt (.* \\d{5} \\w*) .*");
    static Pattern zipAndCityPattern = Pattern.compile(".*(\\d{5}) (.*)");

    public static void main(String[] args) throws IOException {
        String url = JOptionPane.showInputDialog("Bitte die URL eingeben.\nDas sammeln der Daten wird etwas dauern.\nSie werden anschließend aufgefordert eine Datei zum speichern anzugeben.");



        List<Therapist> therapists = getTherapistInfos(url);

        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle("Wo soll die Datei gespeichert werden?");
        chooser.setSelectedFile(new File(".csv"));
        chooser.setFileFilter(new FileNameExtensionFilter("CSV Datei", "csv"));
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.showSaveDialog(null);


        File output = chooser.getSelectedFile();
        if (!output.getName().endsWith(".csv")) {
            String filename = output.getName();
            if (filename.contains(".")) {
                filename = filename.substring(0, filename.indexOf("."));
            }
            filename = filename + ".csv";

            output = new File(output.getParent(), filename);
            JOptionPane.showMessageDialog(null, "Ihr Dateiname wurde zum einfachen Import in excel in \"" + filename + "\" umbenannt.", "Dateiname wurde geändert", JOptionPane.INFORMATION_MESSAGE);
        }

        String header = "Name;Adresse;PLZ;Stadt;Tel. Nr;Email;Erreichbarkeit\n\r";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write(header);
            for (Therapist t : therapists) {
                writer.write(t.toString() + "\n\r");
            }
        }
    }

    private static List<Therapist> getTherapistInfos(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        List<Therapist> therapists = new ArrayList<>();

        //edgecase for less than 5 results and single page
        if (doc.select(".next").isEmpty()) {
            Elements results = doc.select("a.details");
            for (Element result : results) {
                therapists.add(getTherapistInfo(result.attr("abs:href")));
            }
            return therapists;
        }

        while (!doc.select(".next").isEmpty()) {
            Elements results = doc.select("a.details");
            for (Element result : results) {
                therapists.add(getTherapistInfo(result.attr("abs:href")));
            }
            Element nextPage = doc.selectFirst(".next");
            if (nextPage != null) {
                String nextPageURL = nextPage.attr("abs:href");
                System.out.println(nextPageURL);
                doc = Jsoup.connect(nextPageURL).get();
            }
        }
        //for last page
        Elements results = doc.select("a.details");
        for (Element result : results) {
            therapists.add(getTherapistInfo(result.attr("abs:href")));
        }
        return therapists;
    }

    private static Therapist getTherapistInfo(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();

            Elements contactElements = doc.select(":contains(Adresse & Kontakt)");

            Element contact = contactElements.stream().max(Comparator.comparingInt(el -> el.children().size())).get();
            Element details = contact.parents().select(".details").get(0);
            Element nameEl = details.siblingElements().select("[href]").get(0);

            String name = nameEl.child(0).text();

            Matcher addressAndPhone = addressAndPhonePattern.matcher(contact.text());

            String address, phone = "", zip, city;
//        System.out.println(contact.text());
            if (addressAndPhone.matches()) {
                address = addressAndPhone.group(1);

                Matcher zipAndCity = zipAndCityPattern.matcher(address);
                zipAndCity.matches();
                zip = zipAndCity.group(1);
                city = zipAndCity.group(2);
                address = address.replace(" " + zip + " " + city, "");
                phone = addressAndPhone.group(2);

            } else {
                Matcher addressMatcher = addressPattern.matcher(contact.text());
                addressMatcher.matches();
                address = addressMatcher.group(1);

                Matcher zipAndCity = zipAndCityPattern.matcher(address);
                zipAndCity.matches();
                zip = zipAndCity.group(1);
                city = zipAndCity.group(2);
                address = address.replace(" " + zip + " " + city, "");
            }
            String email = "";


            if (contact.children().select("[href]").size() > 0) {
                Element emailEl = contact.children().select("[href]").get(0);
                email = emailEl.attr("href").replace("mailto:", "");
            }

            ContactTimes contactTimes = new ContactTimes("", "", "", "", "");

            if (details.children().select(".sprechzeiten ~ :contains(Telefonische Erreichbarkeit)").size() > 0) {
                Element contactTimesEls = details.children().select(".sprechzeiten ~ :contains(Telefonische Erreichbarkeit)").get(0).nextElementSibling();
                Elements times = contactTimesEls.select("ul");
                contactTimes = new ContactTimes(getContactTime(times.get(0)), getContactTime(times.get(1)), getContactTime(times.get(2)), getContactTime(times.get(3)), getContactTime(times.get(4)));
            }

            Therapist therapist = new Therapist(name, address, zip, city, phone, email, contactTimes);
            return therapist;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
//        System.out.println(therapist);
    }


    public static String getContactTime(Element tableElement) {
        return tableElement.childNodeSize() > 1 ? tableElement.child(0).child(0).text() : "";
    }


    public record Therapist(String name, String address, String zip, String city, String phone, String email,
                            ContactTimes contactTimes) {
        @Override
        public String toString() {
            return name + ";" + address + ";" + zip + ";" + city + ";" + phone + ";" + email + ";" + contactTimes.toString();
        }
    }

    public record ContactTimes(String monday, String tuesday, String wednesday, String thursday, String friday) {
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (!monday.isEmpty())
                builder.append("mo: ").append(monday).append(" ");
            if (!tuesday.isEmpty())
                builder.append("di: ").append(tuesday).append(" ");
            if (!wednesday.isEmpty())
                builder.append("mi: ").append(wednesday).append(" ");
            if (!thursday.isEmpty())
                builder.append("do: ").append(thursday).append(" ");
            if (!friday.isEmpty())
                builder.append("fr: ").append(friday).append(" ");
            return builder.toString();
        }
    }
}
