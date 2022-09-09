package ru.weatherreactive.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.weatherreactive.model.Weather;
import ru.weatherreactive.repository.WeatherMemoryRepository;

@Service
public class WeatherService {

    private final WeatherMemoryRepository repository;

    public WeatherService(WeatherMemoryRepository repository) {
        this.repository = repository;
    }

    public Mono<Weather> findById(int id) {
        return repository.findById(id);
    }

    public Flux<Weather> findAll() {
        return repository.findAll();
    }

    public Mono<Weather> findHottestCity() {
        return repository.findHottestCity();
    }

    public Flux<Weather> findCityByTemperatureGreatThen(int temperature) {
        return repository.findCityByTemperatureGreatThen(temperature);
    }
}
