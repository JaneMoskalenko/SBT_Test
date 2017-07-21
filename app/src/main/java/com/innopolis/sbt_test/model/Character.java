package com.innopolis.sbt_test.model;


import java.util.ArrayList;

public class Character {

    private String url;
    private String name;
    private String gender;
    private String culture;
    private String born;
    private String died;
    private boolean isAlive;
    private ArrayList<String> titles;
    private ArrayList<String> aliases;
    private String father;
    private String mother;
    private String spouse;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
