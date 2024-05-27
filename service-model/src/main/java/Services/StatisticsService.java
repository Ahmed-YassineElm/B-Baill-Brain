package Services;


import Entities.Statistics;
import Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public void storeStatistics(Map<String, Object> statisticsData) {
        // Create a Statistics entity object
        Statistics statistics = new Statistics();
        // Extract statistics from the Map and set them in the entity
        statistics.setBounces((int) statisticsData.get("bounces"));
        statistics.setDistanceCrossed((int) statisticsData.get("distanceCrossed"));
        statistics.setTimeElapsed((int) statisticsData.get("timeElapsed"));
        // Save the entity to the database using the repository
        statisticsRepository.save(statistics);
    }
    public void saveStatistics(Statistics statistic) {
        // Implement saving logic here using the StatisticsRepository
        statisticsRepository.save(statistic);
    }
}