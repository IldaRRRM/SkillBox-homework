package ru.skillbox.entity;

import java.util.Random;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import ru.skillbox.enums.Color;
import ru.skillbox.enums.Status;
import ru.skillbox.service.Eat;
import ru.skillbox.service.MakeSound;
import ru.skillbox.service.Pee;

@Slf4j
@Getter
@Setter
@EqualsAndHashCode
public class Cat implements Eat, Pee, MakeSound, Cloneable {

	public static final Integer EYES_COUNT = 2;

	private static Integer COUNT = 0;

	private final String name;

	private final double minWeight;

	private final double maxWeight;

	private double weight;

	private int staminaIndex = 10;

	private double eatenFoodWeight;

	private Status status = Status.ALIVE;

	//геттер и сеттер с помощью ломбока
	private Color color = Color.BLACK;

	public Cat(String name, Double weight) {
		this.name = name;
		this.weight = weight;
		this.maxWeight = weight * 4;
		this.minWeight = weight / 2;
		COUNT++;
	}

	/**
	 * Получить текущее значение популяции котэ
	 */
	public static Integer getCOUNT() {
		return COUNT;
	}

	@Override
	public void eat(Food food) {
		if (isAlive()) {
			log.info("Кот с именем {} ест еду {}", this.name, food.getTitle());
			this.weight += food.getWeightIncrement();
			this.eatenFoodWeight += food.getWeightIncrement();
			this.staminaIndex += 1;
			log.info("Кот с именем {} cъел еду. Его вес {}", this.name, this.weight);
			weightControl();
		} else {
			log.info("Кошка по имени {} мертва и больше не может есть :(", this.name);
		}
	}

	@Override
	public void makeSound() {
		if (isAlive()) {
			log.info("Кот с именем: {} издает звук: \"meow\"", this.name);
			staminaIndex -= 1;
			staminaControl();
		} else {
			log.info("Кошка по имени {} мертва и больше не может мяукать :(", this.name);
		}
	}

	@Override
	public void pee() {
		if (isAlive()) {
			this.weight -= getRandomPeeWeight();
			log.info("Кот по имени {} сходил в туалет, теперь его вес равен {}", this.name, this.weight);
			weightControl();
		} else {
			log.info("Кошка по имени {} мертва и больше не может ходить в туалет :(", this.name);
		}

	}

	/**
	 * Проверка, жив ли кот
	 *
	 * @return true, если жив
	 */
	public boolean isAlive() {
		return this.status.equals(Status.ALIVE);
	}

	private void staminaControl() {
		if (staminaIndex == 0) {
			log.warn("Котэ {} на исходе сил", this.name);
		} else if (staminaIndex < 0) {
			this.status = Status.DEAD;
			COUNT--;
			log.warn("На кота {} оказана слишком больша нагрузка, он умер :( ", this.name);
		}
	}

	private void weightControl() {
		if (this.weight == minWeight) {
			log.warn("Достигнут минимальный вес кота с именем {} лучше покормите его", this.name);
		} else if (this.weight < minWeight) {
			this.status = Status.DEAD;
			COUNT--;
		} else if (this.weight > maxWeight) {
			log.warn("Превышен максимальный вес кота с именем {}. Он умер от ожирения :(", this.name);
			this.status = Status.DEAD;
			COUNT--;
		}
	}

	private Double getRandomPeeWeight() {
		return new Random().nextBoolean() ? 0.001 : 0.002 * weight;
	}

}
