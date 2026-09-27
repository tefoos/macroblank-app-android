package com.macroblank.app;

public class Album {

    private final String title;
    private final String description;
    private final int coverRes;

    public Album(String title, String description, int coverRes) {
        this.title = title;
        this.description = description;
        this.coverRes = coverRes;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCoverRes() {
        return coverRes;
    }
}