package ru.skillbox.enums;

import lombok.Getter;

@Getter
public enum Color {
    WHITE("Белый"),
    BLACK("ЧЕРНЫЙ");

    private String name;

    Color(String name) {
        this.name = name;
    }
}
