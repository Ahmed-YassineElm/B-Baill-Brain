package Services;

import Entities.Statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

@Service
public class PredictionService {

    @Autowired
    private RestTemplate restTemplate;

    public Statistics getPrediction(String videoFilePath) {
        String url = "http://localhost:8000/predict";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(new File(videoFilePath)));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<Statistics > response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Statistics .class);

        return response.getBody();
    }
}
