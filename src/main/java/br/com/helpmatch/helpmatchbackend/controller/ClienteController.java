package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping
    public void criarconta(@RequestBody ClienteDto cliente ){

        System.out.println(cliente);




    }

}
