package weatherbot.repository.weather_api

import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.UriBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import weatherbot.Weather
import weatherbot.WeatherReader

class WeatherApiReader(
    private val baseUrl: String,
    private val apiKey: String,
) : WeatherReader {
    private val webClient: WebClient = WebClient.builder()
        .baseUrl(baseUrl)
        .build()

    override fun getWeather(lat: Double, lon: Double): Weather {
        val weatherMonoResponses =
            (-24..-6 step 6).map { getHistorical(lat, lon, hourOffset = it) } +
                getCurrent(lat, lon) +
                (6..48 step 6).map { getForecast(lat, lon, hourOffset = it) }

        val weatherResponses = Flux.merge(weatherMonoResponses).collectList().block()!!.sortedBy { it.hourOffset }

        return Weather(
            historicals = weatherResponses.filter { it.hourOffset <= 0 }.map { it.toHistoricalEntity() },
            forecasts = weatherResponses.filter { it.hourOffset > 0 }.map { it.toForecastEntity() },
        )
    }

    private fun getCurrent(lat: Double, lon: Double): Mono<WeatherResponse> = webClient.get()
        .uri { builder: UriBuilder ->
            builder.path("/current")
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("api_key", apiKey)
                .build()
        }
        .retrieve()
        .bodyToMono(Historical::class.java)
        .map { it.toWeatherResponse(0) }

    private fun getHistorical(lat: Double, lon: Double, hourOffset: Int): Mono<WeatherResponse> = webClient.get()
        .uri { builder: UriBuilder ->
            builder.path("/historical/hourly")
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("hour_offset", hourOffset)
                .queryParam("api_key", apiKey)
                .build()
        }
        .retrieve()
        .bodyToMono(Historical::class.java)
        .map { it.toWeatherResponse(hourOffset) }

    private fun getForecast(lat: Double, lon: Double, hourOffset: Int): Mono<WeatherResponse> = webClient.get()
        .uri { builder: UriBuilder ->
            builder.path("/forecast/hourly")
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("hour_offset", hourOffset)
                .queryParam("api_key", apiKey)
                .build()
        }
        .retrieve()
        .bodyToMono(Forecast::class.java)
        .map { it.toWeatherResponse(hourOffset) }
}
