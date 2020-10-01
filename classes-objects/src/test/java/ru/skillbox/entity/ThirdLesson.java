package ru.skillbox.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ThirdLesson {

    @Test
    @DisplayName("Проверка статического счётчика популяции котов")
    void whenWeCreateCatCountWillBeOneThenCatDeadAndCountWillBeZero() {
        final Cat cat = new Cat("cat", 1.0);
        assertThat(Cat.getCOUNT()).as("Кошка создана").isEqualTo(1);
        cat.eat(new Food("Кошачий корм", 150.0));
        assertThat(Cat.getCOUNT()).as("Кошка рип").isEqualTo(0);
    }

    @Test
    @DisplayName("Проверка, что мертвая кошка не может есть и ходить в туалет")
    void whenCatAliveWeightWillBeIncrementAndWhenCatDeadWeightWillBeTheSame() {
        final Cat cat = new Cat("cat", 1.0);
        final Food catFood = new Food("catFood", 150.0);
        cat.eat(catFood);

        cat.eat(catFood);
        assertThat(cat.getWeight())
            .as("Проверка веса у мёртвой кошки, он должен оставаться тем же, что и после смерти")
            .isEqualTo(151.0);

        cat.pee();
        assertThat(cat.getWeight())
            .as("Проверка, что мёртвая кошка не может ходить в туалет")
            .isEqualTo(151.0);
    }

}
