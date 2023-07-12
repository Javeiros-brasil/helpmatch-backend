package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.service.ProfissionalService;

import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    private ProfissionalService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){

        return service.getById(id)
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDto>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProfissionalDto profissional){

    	return service.create( profissional ).map(profissionalDto -> {

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(profissionalDto.getId())
                    .toUri()).body( profissionalDto );

        }).orElse(ResponseEntity.badRequest().build());

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProfissionalDto profissional) {
        return service.update(id, profissional)
                .map(dto -> ResponseEntity.ok( dto ))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
