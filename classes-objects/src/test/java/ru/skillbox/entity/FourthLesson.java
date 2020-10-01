package ru.skillbox.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class FourthLesson {

    @Test
    @DisplayName("Проверка максимального веса кота")
    void whenWeCallFinalMaxWeight() {
        final Cat cat = new Cat("cat", 1.0);
        assertThat(cat.getMaxWeight())
            .as("Проверка максимального веса")
            .isEqualTo(4.0);
    }

    @Test
    @DisplayName("Проверка максимальности глаз")
    void whenWeCallEyesField() {
        assertThat(Cat.EYES_COUNT)
            .as("Проверка максимальности глаз")
            .isEqualTo(2);
    }

}
