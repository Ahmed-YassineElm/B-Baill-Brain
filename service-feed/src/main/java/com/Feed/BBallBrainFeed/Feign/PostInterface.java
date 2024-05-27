package com.Feed.BBallBrainFeed.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient("USERS-SERVICE")
public interface PostInterface {

    @GetMapping("users/current")
    public ResponseEntity<List<Map<String,
            Object>>> getCurrentUsers();


}
