package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.repository.ProfissionalRepository;
import br.com.helpmatch.helpmatchbackend.service.ProfissionalService;
import org.apache.coyote.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/profissional")
public class ProfissionalController {

    @Autowired
    public ProfissionalService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok().body(null);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(null);
    }

    @PostMapping
    public ResponseEntity<?> create(){
        return ResponseEntity.created(null).body(null);
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
