package com.epam.dhontar.aqamp.utils.enums;

public enum Constants {
    //    SITE_URL("https://fakerestapi.azurewebsites.net/index.html"),
    TESTRAIL_USER("dmitryhontar@gmail.com"),
    TESTRAIL_PWD("9dz2N0faNpDowbPlulZu"),
    TESTRAIL_URL("https://dmitryh.testrail.io/");
    private final String constantValue;

    Constants(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getValue() {
        return constantValue;
    }
}
