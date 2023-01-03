package weatherbot

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WeatherSummaryController(
    private val weatherSummaryService: WeatherSummaryService
) {
    @GetMapping("/summary")
    fun getSummary(
        @RequestParam lat: Double,
        @RequestParam lon: Double,
    ): WeatherSummaryResponse {
        return weatherSummaryService.getSummaryResponse(lat = lat, lon = lon)
    }
}
