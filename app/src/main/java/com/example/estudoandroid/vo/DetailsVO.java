package com.example.estudoandroid.vo;

public class DetailsVO {
    private String title;
    private String generalRegister;
    private String description;
    private String numberOfSubscribers;
    private String criationDate;

    public DetailsVO(String title, String generalRegister, String description, String numberOfSubscribers, String criationDate) {
        this.title = title;
        this.generalRegister = generalRegister;
        this.description = description;
        this.numberOfSubscribers = numberOfSubscribers;
        this.criationDate = criationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getGeneralRegister() {
        return generalRegister;
    }

    public String getDescription() {
        return description;
    }

    public String getNumberOfSubscribers() {
        return numberOfSubscribers;
    }

    public String getCriationDate() {
        return criationDate;
    }
}
