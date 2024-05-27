package com.ghacham.basketball.clients;

import com.ghacham.basketball.entities.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("USERS-SERVICE")
public interface UtilisateurClient {

    @GetMapping("users/{id}")
    Player getPlayerById(@PathVariable("id") Long id);

    @GetMapping("/users/{id}/role")
    boolean getUserRole(@PathVariable("id") Long id);

}

