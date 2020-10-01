package ru.skillbox.entity;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class EightLesson {

    @Test
    @DisplayName("Получить модели всех самолетов")
    void printAllAirplaneModels() {
        final Airport instance = Airport.getInstance();
        instance.getAllAircrafts().stream()
            .map(Aircraft::getModel)
            .collect(Collectors.toSet())
            .forEach(modelName -> log.info("Модель самолета {}", modelName));
    }

    @Test
    @DisplayName("Получить количество припаркованных самолётов")
    void printAllModelsInTerminal() {
        final Integer amountOfAirplans = Airport.getInstance().getTerminals().stream()
            .map(Terminal::getParkedAircrafts)
            .map(List::size)
            .reduce(0, Integer::sum);
        log.info("Количество припаркованных самолетов в аэропорту {}", amountOfAirplans);

    }

}
