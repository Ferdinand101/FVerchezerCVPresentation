package com.ferdinand.next.model;

public class SearchBar {
    private String text;

    public String getText() {
        return text;
    }

    public SearchBar setText(String text) {
        this.text = text;
        return this;
    }
}
