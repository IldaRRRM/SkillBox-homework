package ru.skillbox.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FifthLesson {

    @Test
    @DisplayName("Проверка конструктора :)")
    void constructTest() {
        final Cat barsikCat = new Cat("BarsikCat", 1100.00);
        assertThat(barsikCat.getWeight()).isEqualTo(1100.00);
    }

}
