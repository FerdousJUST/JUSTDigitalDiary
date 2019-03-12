package com.blogspot.skferdous.justdigitaldiary;

public class ModelAdapter {
    private int image01,image02,image03,image04;
    private String name01,deg01,email01,phone01,textme01;

    public ModelAdapter(int image01, int image02, int image03, int image04, String name01, String deg01, String email01, String phone01, String textme01) {
        this.image01 = image01;
        this.image02 = image02;
        this.image03 = image03;
        this.image04 = image04;
        this.name01 = name01;
        this.deg01 = deg01;
        this.email01 = email01;
        this.phone01 = phone01;
        this.textme01 = textme01;
    }

    public int getImage01() {
        return image01;
    }

    public void setImage01(int image01) {
        this.image01 = image01;
    }

    public int getImage02() {
        return image02;
    }

    public void setImage02(int image02) {
        this.image02 = image02;
    }

    public int getImage03() {
        return image03;
    }

    public void setImage03(int image03) {
        this.image03 = image03;
    }

    public int getImage04() {
        return image04;
    }

    public void setImage04(int image04) {
        this.image04 = image04;
    }

    public String getName01() {
        return name01;
    }

    public void setName01(String name01) {
        this.name01 = name01;
    }

    public String getDeg01() {
        return deg01;
    }

    public void setDeg01(String deg01) {
        this.deg01 = deg01;
    }

    public String getEmail01() {
        return email01;
    }

    public void setEmail01(String email01) {
        this.email01 = email01;
    }

    public String getPhone01() {
        return phone01;
    }

    public void setPhone01(String phone01) {
        this.phone01 = phone01;
    }

    public String getTextme01() {
        return textme01;
    }

    public void setTextme01(String textme01) {
        this.textme01 = textme01;
    }
}

