package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.controller.request.ProfissionalRequest;
import br.com.helpmatch.helpmatchbackend.controller.response.ProfissionalResponse;
import br.com.helpmatch.helpmatchbackend.converter.ProfissionalConverter;
import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.service.ProfissionalService;

import java.util.List;

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
    public ProfissionalService service;
    @Autowired
    public ProfissionalConverter converter;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){

        return service.getById(id)
                .map(dto -> ResponseEntity.ok(converter.converterDtoToResponse(dto)))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> getAll(){
        return ResponseEntity.ok().body(converter.converterListDtoToListResponse(service.getAll()));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProfissionalRequest profissional){

    	ProfissionalDto profissionalResponse = service.create( converter.converterRequestToDto(profissional) );
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(profissionalResponse.getId())
                .toUri()).body(profissionalResponse);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProfissionalRequest profissional) {
        return service.update(id, converter.converterRequestToDto(profissional))
                .map(dto -> ResponseEntity.ok(converter.converterDtoToResponse(dto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {

        service.delete(id);
    }

}
