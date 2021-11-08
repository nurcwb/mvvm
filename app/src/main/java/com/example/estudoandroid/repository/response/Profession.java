package com.example.estudoandroid.repository.response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Profession {
    private int id;
    private String title;
    private String generalRegister;
    private String description;
    private long numberOfSubscribers;
    private String criationDate;

    public Profession(int id, String title, String generalRegister, String description, int numberOfSubscribers) {
        this.id = id;
        this.title = title;
        this.generalRegister = generalRegister;
        this.description = description;
        this.numberOfSubscribers = new Random(numberOfSubscribers).nextLong();

        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
        this.criationDate = formataData.format(new Date());
    }

    public int getId() {
        return id;
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
        return Long.toString(numberOfSubscribers);
    }

    public String getCriationDate() {
        return criationDate;
    }
}
