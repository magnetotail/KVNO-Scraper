package de.foospace.two.domain;

public class Homepage {
    private String webSite;

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return webSite;
    }
}
