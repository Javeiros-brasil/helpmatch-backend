package br.com.helpmatch.helpmatchbackend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping
    public void criarconta(@RequestBody String jsonRequest ){
        System.out.println(jsonRequest);
    }

}
