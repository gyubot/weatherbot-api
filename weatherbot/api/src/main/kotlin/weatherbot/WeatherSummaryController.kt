package weatherbot

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeoutException
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@RestController
@Validated
class WeatherSummaryController(
    private val weatherSummaryService: WeatherSummaryService
) {
    @GetMapping("/summary")
    fun getSummary(
        @RequestParam @Min(-90) @Max(89) lat: Float,
        @RequestParam @Min(-180) @Max(179) lon: Float,
    ): ResponseEntity<WeatherSummaryResponse> {
        try {
            return ResponseEntity.ok(weatherSummaryService.getSummaryResponse(lat = lat, lon = lon))
        } catch (e: TimeoutException) {
            return ResponseEntity.status(408).build()
        }
    }
}
