package ru.skillbox.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Food {

    private final String title;

    private final Double weightIncrement;

}
