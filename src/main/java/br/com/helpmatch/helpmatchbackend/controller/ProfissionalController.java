package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.repository.ProfissionalRepository;
import br.com.helpmatch.helpmatchbackend.service.ProfissionalService;

import java.util.List;

import org.apache.coyote.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    public ProfissionalService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
    	List<?> listProfissional = service.getAll();
        return ResponseEntity.ok().body(listProfissional);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProfissionalDto profissional){
    	ProfissionalDto profissionalResponse = service.create(profissional);
        return ResponseEntity.created(null).body(profissionalResponse);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        return ResponseEntity.ok().body(null);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {

    }

}
