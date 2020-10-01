package ru.skillbox.entity;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SecondLesson {

	@Test
	@DisplayName("Покормите кошку кормом весом 150")
	void whenWeFeedCatFoodWithWeight150() {
		final Cat cat = new Cat("cat", 400.0);
		cat.eat(new Food("Кошачий корм", 150.0));
		cat.pee();
		cat.pee();
		cat.pee();
		log.info("Вес съеденного корма {}", cat.getEatenFoodWeight());

		assertThat(cat.getEatenFoodWeight()).isEqualTo(150);
	}

	@Test
	@DisplayName("Проверка метода pee() что наш вес немного уменьшаетсся после туалета")
	void whenCatPeeAndWeightIsLoss() {
		final Cat cat = new Cat("cat", 400.0);
		cat.pee();
		cat.pee();
		cat.pee();
		assertThat(cat.getWeight()).isLessThan(400);
	}

}
