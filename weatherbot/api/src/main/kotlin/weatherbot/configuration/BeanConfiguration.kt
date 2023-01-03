package weatherbot.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import weatherbot.WeatherSummaryService
import weatherbot.greeting.GreetingTextGenerator
import weatherbot.greeting.GreetingTypeCompositeChecker
import weatherbot.heads_up.HeadsUpTextGenerator
import weatherbot.heads_up.HeadsUpTypeCompositeChecker
import weatherbot.repository.weather_api.WeatherApiReader
import weatherbot.temperature.TemperatureTextGenerator

@Configuration
class BeanConfiguration {
    @Configuration
    class WebConfiguration : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("/**").allowedMethods("*")
        }
    }

    @Bean
    fun weatherSummaryService(
        @Value("\${weatherApi.baseUrl}") baseUrl: String,
        @Value("\${weatherApi.apiKey}") apiKey: String,
    ): WeatherSummaryService = WeatherSummaryService(
        greetingTextGenerator = GreetingTextGenerator(
            GreetingTypeCompositeChecker()
        ),
        temperatureTextGenerator = TemperatureTextGenerator(),
        headsUpTextGenerator = HeadsUpTextGenerator(
            HeadsUpTypeCompositeChecker()
        ),
        weatherReader = WeatherApiReader(
            baseUrl = baseUrl,
            apiKey = apiKey,
        )
    )
}
