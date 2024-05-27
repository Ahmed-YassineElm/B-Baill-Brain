package Controllers;

import Entities.Statistics;
import Services.PredictionService;
import Services.StatisticsService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/predict")
    public String predict(@RequestBody String videoFilePath) throws IOException {
        Statistics statistics = predictionService.getPrediction(videoFilePath);
        statisticsService.saveStatistics(statistics);
        return statistics.toString();
    }
}
