package com.basejava.model;

public enum ContactType {
    PHONE("Phone number: "),
    SKYPE("Skype: "),
    MAIL("Mail: "),
    LINKEDIN("LinkedIn: "),
    GITHUB("GitHub: "),
    STACKOVERFLOW("StackOverflow: "),
    HOMEPAGE("HomePage: ");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
