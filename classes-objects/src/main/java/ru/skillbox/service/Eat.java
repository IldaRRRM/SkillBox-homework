package ru.skillbox.service;

import ru.skillbox.entity.Food;

public interface Eat {

    /**
     * Метод для потребления еды
     *
     * @param food еда
     */
    void eat(Food food);

}
