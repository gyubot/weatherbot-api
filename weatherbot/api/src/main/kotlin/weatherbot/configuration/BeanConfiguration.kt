package weatherbot.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import weatherbot.WeatherDummyReader
import weatherbot.WeatherSummaryService
import weatherbot.greeting.GreetingTextGenerator
import weatherbot.greeting.GreetingTypeCompositeChecker
import weatherbot.heads_up.HeadsUpTextGenerator
import weatherbot.heads_up.HeadsUpTypeCompositeChecker
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
    fun weatherSummaryService(): WeatherSummaryService = WeatherSummaryService(
        greetingTextGenerator = GreetingTextGenerator(
            GreetingTypeCompositeChecker()
        ),
        temperatureTextGenerator = TemperatureTextGenerator(),
        headsUpTextGenerator = HeadsUpTextGenerator(
            HeadsUpTypeCompositeChecker()
        ),
        weatherReader = WeatherDummyReader()
    )
}
