package ru.weatherreactive.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.weatherreactive.model.Weather;

import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class WeatherMemoryRepository {

    private final Map<Integer, Weather> weathers = new ConcurrentHashMap<>();

    public WeatherMemoryRepository() {
        weathers.put(1, new Weather(1, "Msc", 20));
        weathers.put(2, new Weather(2, "SPb", 14));
        weathers.put(3, new Weather(3, "Bryansk", 10));
        weathers.put(4, new Weather(4, "Smolensk", 15));
        weathers.put(5, new Weather(5, "Kiev", 30));
        weathers.put(6, new Weather(6, "Minsk", 21));
    }

    public Mono<Weather> findById(int id) {
        return Mono.justOrEmpty(weathers.get(id));
    }

    public Flux<Weather> findAll() {
        return Flux.fromIterable(weathers.values());
    }

    public Mono<Weather> findHottestCity() {
        return Mono.justOrEmpty(weathers.values()
                .stream()
                .max(Comparator.comparingInt(Weather::getTemperature))
        );
    }

    public Flux<Weather> findCityByTemperatureGreatThen(int temperature) {
        return Flux.fromIterable(weathers.values()
                .stream()
                .filter(c -> c.getTemperature() > temperature)
                .toList()
        );
    }
}
