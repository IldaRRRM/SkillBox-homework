package ru.skillbox.entity;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class FirstLesson {

	@Test
	@DisplayName("Создать 5-7 кошек и вызвать у них различные методы")
	void whenWeCreateSomeInstanceOfCatsAndCallDifferentMethods() {
		for (int i = 0; i < 7; i++) {
			final Cat cat = new Cat("Барсик" + i, 2.0);
			cat.eat(new Food("Кискас", 0.4));
			cat.makeSound();
			log.info("Вес созданной кошки: {}", cat.getWeight());
		}
	}


	@Test
	@DisplayName("покормите 2 кошки и после этого распечатать их вес (убедитесь что вес изменился)")
	void whenWeFeedCatsAnd() {
		final Cat barsik = new Cat("Барсик", 3.0);
		final Cat taiwin = new Cat("Тайвин", 5.0);

		barsik.eat(new Food("Китикет", 0.5));
		taiwin.eat(new Food("Китикет", 1.0));

		assertThat(barsik.getWeight()).as("Проверка, что вес барсика увеличился").isEqualTo(3.5);
		assertThat(taiwin.getWeight()).as("Проверка, что вес тайвина увеличился").isEqualTo(6);

	}

	@Test
	@DisplayName("Перекормите кошку")
	void whenWeOverfeedOurCatAndThenHeDies() {
		final Cat tragicCat = new Cat("Обжорчик", 2.0);
		final Food kiticat = new Food("kiticat", 1.0);
		while (tragicCat.isAlive()) {
			tragicCat.eat(kiticat);
		}
		assertThat(tragicCat.isAlive()).as("Проверка, что кот умер").isFalse();
	}

	@Test
	@DisplayName("\"замяукайте\" кошку до смерти")
	void whenCatMeowTooMuch() {
		final Cat tragicCat = new Cat("Мяучник", 2.0);
		tragicCat.setStaminaIndex(4);
		while (tragicCat.isAlive()) {
			tragicCat.makeSound();
		}
		assertThat(tragicCat.isAlive()).as("Проверка, что кот умер").isFalse();
	}

}