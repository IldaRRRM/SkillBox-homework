package ru.skillbox.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.skillbox.enums.Color;

import static org.assertj.core.api.Assertions.assertThat;

public class SevenLesson {

    @Test
    @DisplayName("Проверка метода Clone")
    void whenWeCallCloneMethodAndGetTheSameObject() throws CloneNotSupportedException {
        Cat origianl = new Cat("Origianl", 2.0, Color.WHITE);
        final Cat clone = (Cat) origianl.clone();
        assertThat(origianl).isEqualTo(clone);
    }

}
