package de.foospace.two;

import com.google.gson.Gson;
import de.foospace.two.domain.Email;
import de.foospace.two.domain.Person;
import de.foospace.two.domain.PlacesSearch;
import de.foospace.two.domain.SearchResult;
import de.foospace.two.domain.singlePerson.SinglePerson;
import okhttp3.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws IOException {



        Gson g = new Gson();
//        String json = g.toJson(search);
//        System.out.println(json);

//        String json = "{\"personId\":380100031099,\"vortitel\":null,\"vorname\":null,\"zwischentitel\":null,\"nachname\":\"Plitzko\",\"isPrivatarzt\":false,\"geschlecht\":1,\"genehmigungZuPerson\":[{\"geNummerText\":\"Verhaltenstherapie\",\"psychoTherapie\":true,\"koE\":\"E\",\"filtertext\":\"Verhaltenstherapie für Erwachsene\"}],\"akademischerTitel\":[{\"titelOrg\":\"Dipl.-Psych.\"}],\"taetigkeiten\":[{\"taetigkeitTyp\":4,\"taetigkeitId\":38000100309223,\"taetigkeitAnLeistungsorten\":[{\"plz\":\"45147\",\"ort\":\"Essen\",\"strasse\":\"Ladenspelderstraße\",\"hausnummer\":\"42\",\"barrierefreiheit\":[{\"bezeichnung\":\"Kommunikation über SMS, Fax oder E-Mail\"}],\"telefon\":[{\"telefonvorwahl\":\"0201\",\"telefonnummer\":\"87180270\",\"isManuellerDatensatz\":false}],\"homePage\":[],\"email\":[{\"emailAddress\":\"plitzko@therapie-wege.de\",\"isManuellerDatensatz\":false}],\"fax\":[{\"faxvorwahl\":\"0201\",\"faxnummer\":\"87180271\",\"isManuellerDatensatz\":false}],\"sprechzeiten\":[{\"sprechzeitArt\":2,\"vereinbarung1\":\"Telefon: (0201) 87180270\",\"vereinbarung2\":null,\"vereinbarung3\":null,\"termine\":[{\"tag\":0,\"hours\":[{\"termineVon\":\"12:00\",\"termineBis\":\"13:40\"}]}]},{\"sprechzeitArt\":3,\"vereinbarung1\":null,\"vereinbarung2\":null,\"vereinbarung3\":null,\"termine\":[{\"tag\":3,\"hours\":[{\"termineVon\":\"12:00\",\"termineBis\":\"13:00\"}]}]},{\"sprechzeitArt\":1,\"vereinbarung1\":null,\"vereinbarung2\":null,\"vereinbarung3\":null,\"termine\":[{\"tag\":0,\"hours\":[{\"termineVon\":\"09:00\",\"termineBis\":\"15:00\"}]},{\"tag\":1,\"hours\":[{\"termineVon\":\"08:00\",\"termineBis\":\"12:00\"}]},{\"tag\":2,\"hours\":[{\"termineVon\":\"08:00\",\"termineBis\":\"12:00\"}]},{\"tag\":3,\"hours\":[{\"termineVon\":\"08:00\",\"termineBis\":\"13:00\"}]},{\"tag\":4,\"hours\":[{\"termineVon\":\"10:00\",\"termineBis\":\"15:00\"}]}]}],\"leistungsSpektrumen\":[],\"place\":{\"longitute\":6.9927728,\"latitude\":51.43896789999999},\"leistungsortId\":38000100309219}],\"hausfacharztKennzeichen\":null,\"ermaechtigungsUmfang\":[],\"taetigkeitsBereiche\":[{\"bezeichnung\":\"Psychologische Psychotherapeutin, Verhaltenstherapie\",\"art\":2,\"filtertext\":\"Psychologischer Psychotherapeut, Verhaltenstherapie/Psychologische Psychotherapeutin, Verhaltenstherapie\"}],\"leistungsSpektrumen\":[],\"genehmigungZuTaetigkeit\":[]}],\"fremdsprachen\":[]}";

//        SinglePerson result = g.fromJson(json, SinglePerson.class);

//        System.out.println(result.toCSV());

//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://arztsuche.kvno.de/api/api/person/380100691301")
//                .get()
//                .addHeader("cookie", "TS01dceb35=015f6b75ab2033cb95aa77336eb4b30c801f9eb840d8e6f7e608c1f63de6d5c34e40c2e5fabbe269c1639762c1b87d3bdcb253363b; __cmpconsentx52593=BPxdI4DPxdI4DAfJRBDEABAAAAAAAA; __cmpconsentx52491=BPxdIJ5PxdIJ5AfHrBDEABAAAAAAAA; __cmpcccx52593=aBPxdI4DgAgAzACAAuCjQAAA; __cmpcccx52491=aBPxdIJ5gAAAgAXAAA; TS01dceb35=015f6b75abfaf7c164d935416177dc127e688f72ef9546c962acaa731d4d9717c9fd8ad5a17603b74af62d830197c6d2edb789f109")
//                .addHeader("User-Agent", "Insomnia/2023.5.7")
//                .build();
//
//        Response response = client.newCall(request).execute();
////        System.out.println(response.body().string());
//
//        SinglePerson result = g.fromJson(response.body().string(), SinglePerson.class);
//
//        System.out.println(result.toCSV());

        getPersonIds();
    }

    private static void getPersonIds() throws IOException {
        Gson g = new Gson();
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        PlacesSearch peekSearch = new PlacesSearch("45127", 1, 1);
        RequestBody peekBody = RequestBody.create(mediaType, "{\"searchText\":\"\",\"near\":8,\"address\":\"45145\",\"page\":1,\"pageSize\":10,\"UserLocation\":{\"Lat\":51.4457967,\"Lng\":6.9761637},\"filterModel\":{\"fremdsprachenFilter\":[],\"geschlechtFilter\":[],\"fachgebieteFilter\":[],\"schwerpunkteFilter\":[],\"zusatzbezeichnungFilter\":[],\"behandlungsprogrammFilter\":[],\"psychotherapieVerfahrenFilter\":[\"Verhaltenstherapie für Erwachsene\"],\"barrierefreiheitFilter\":[],\"erreichbarkeitTagFilter\":[],\"erreichbarkeitZeitFilter\":[]}}");
        Request peekRequest = new Request.Builder()
                .url("https://arztsuche.kvno.de/api/api/places?=")
                .post(peekBody)
                .addHeader("cookie", "TS01dceb35=015f6b75ab2033cb95aa77336eb4b30c801f9eb840d8e6f7e608c1f63de6d5c34e40c2e5fabbe269c1639762c1b87d3bdcb253363b; __cmpconsentx52593=BPxdI4DPxdI4DAfJRBDEABAAAAAAAA; __cmpconsentx52491=BPxdIJ5PxdIJ5AfHrBDEABAAAAAAAA; __cmpcccx52593=aBPxdI4DgAgAzACAAuCjQAAA; __cmpcccx52491=aBPxdIJ5gAAAgAXAAA; TS01dceb35=015f6b75abfaf7c164d935416177dc127e688f72ef9546c962acaa731d4d9717c9fd8ad5a17603b74af62d830197c6d2edb789f109")
                .addHeader("Content-Type", "application/json")
                .addHeader("User-Agent", "Insomnia/2023.5.7")
                .build();
        Response peekResponse = client.newCall(peekRequest).execute();
        SearchResult peekResult = g.fromJson(peekResponse.body().string(), SearchResult.class);

        int totalCount = peekResult.getTotalCount();

        System.out.println(totalCount);
        int pageSize = 10;
        int requestCount = (totalCount / pageSize)  + 1;
        List<Person> persons = new ArrayList<>();
        for (int i = 1; i <= requestCount; i++){
            PlacesSearch search = new PlacesSearch("45127", i, pageSize);
            RequestBody body = RequestBody.create(mediaType, "{\"searchText\":\"\",\"near\":8,\"address\":\"45145\",\"page\":" + i + ",\"pageSize\":10,\"UserLocation\":{\"Lat\":51.4457967,\"Lng\":6.9761637},\"filterModel\":{\"fremdsprachenFilter\":[],\"geschlechtFilter\":[],\"fachgebieteFilter\":[],\"schwerpunkteFilter\":[],\"zusatzbezeichnungFilter\":[],\"behandlungsprogrammFilter\":[],\"psychotherapieVerfahrenFilter\":[\"Verhaltenstherapie für Erwachsene\"],\"barrierefreiheitFilter\":[],\"erreichbarkeitTagFilter\":[],\"erreichbarkeitZeitFilter\":[]}}");
            Request request = new Request.Builder()
                    .url("https://arztsuche.kvno.de/api/api/places?=")
                    .post(body)
                    .addHeader("cookie", "TS01dceb35=015f6b75ab2033cb95aa77336eb4b30c801f9eb840d8e6f7e608c1f63de6d5c34e40c2e5fabbe269c1639762c1b87d3bdcb253363b; __cmpconsentx52593=BPxdI4DPxdI4DAfJRBDEABAAAAAAAA; __cmpconsentx52491=BPxdIJ5PxdIJ5AfHrBDEABAAAAAAAA; __cmpcccx52593=aBPxdI4DgAgAzACAAuCjQAAA; __cmpcccx52491=aBPxdIJ5gAAAgAXAAA; TS01dceb35=015f6b75abfaf7c164d935416177dc127e688f72ef9546c962acaa731d4d9717c9fd8ad5a17603b74af62d830197c6d2edb789f109")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Agent", "Insomnia/2023.5.7")
                    .build();
            Response response = client.newCall(request).execute();
            persons.addAll(Arrays.asList(g.fromJson(response.body().string(), SearchResult.class).getPersons()));
        }

        List<SinglePerson> singlePersons = new ArrayList<>();
        for (Person person : persons) {
            Request personRequest = new Request.Builder()
                    .url("https://arztsuche.kvno.de/api/api/person/" + person.getId())
                    .get()
                    .addHeader("cookie", "TS01dceb35=015f6b75abdbb396a411cfa25b70bb7e10ed0a29c0c49617bac5d7e37c6965412126141af1d8096206b0b482e975dcdcd149af98be; __cmpconsentx52593=BPxdI4DPxdI4DAfJRBDEABAAAAAAAA; __cmpconsentx52491=BPxdIJ5PxdIJ5AfHrBDEABAAAAAAAA; __cmpcccx52593=aBPxdI4DgAgAzACAAuCjQAAA; __cmpcccx52491=aBPxdIJ5gAAAgAXAAA; TS01dceb35=015f6b75abfaf7c164d935416177dc127e688f72ef9546c962acaa731d4d9717c9fd8ad5a17603b74af62d830197c6d2edb789f109")
                    .addHeader("User-Agent", "Insomnia/2023.5.7")
                    .build();

            Response response = client.newCall(personRequest).execute();
            String body = response.body().string();
            System.out.println(body);
            singlePersons.add(g.fromJson(body, SinglePerson.class));
        }

        StringBuilder sb = new StringBuilder();
        for (SinglePerson singlePerson : singlePersons) {
            Optional<Person> person = persons.stream().filter(p -> p.getId() == singlePerson.getPersonId()).findAny();
            singlePerson.setVorname(person.get().getVorname());
//            System.out.println(singlePerson.toCSV());
        }




        singlePersons = singlePersons.stream().filter(sp -> sp.getTaetigkeiten()[0].getTaetigkeitAnLeistungsorten()[0].getEmail().length > 0).toList();

        Map<Email, SinglePerson> personsUniqueEmail = new HashMap<>();

        for(SinglePerson person : singlePersons) {

            personsUniqueEmail.put(person.getTaetigkeiten()[0].getTaetigkeitAnLeistungsorten()[0].getEmail()[0], person);
        }

        singlePersons = personsUniqueEmail.values().stream().toList();

        String header = "Anrede;Titel;Vorname;Nachname;nur privat;Ort;Straße;Telefon;Email;Homepage;Praxissprechzeit;Telefonsprechzeit\n";
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\magne\\Desktop\\Therapieergebnisse.csv"));
        writer.write(header);
        for (SinglePerson singlePerson : singlePersons) {
            writer.write(singlePerson.toCSV());
        }
        System.out.println(singlePersons.size());
        System.out.println(singlePersons.stream().map(p -> p.getTaetigkeiten()[0].getTaetigkeitAnLeistungsorten()[0].getEmail()[0].toString()).collect(Collectors.joining(",")));
        writer.close();
    }

}
