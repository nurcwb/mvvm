package com.example.estudoandroid.vo;

public class ProfessionVo {
    private int id;
    private String name;
    public boolean isChecked;

    public ProfessionVo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
