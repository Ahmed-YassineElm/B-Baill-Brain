package Controllers;
import Services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/statistics")
    public ResponseEntity<String> storeStatistics(@RequestBody Map<String, Object> statisticsData) {
        try {
            statisticsService.storeStatistics(statisticsData);
            return ResponseEntity.ok("Statistics stored successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to store statistics");
        }
    }
}