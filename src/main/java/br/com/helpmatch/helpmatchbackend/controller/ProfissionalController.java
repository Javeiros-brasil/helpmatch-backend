package br.com.helpmatch.helpmatchbackend.controller;

import br.com.helpmatch.helpmatchbackend.controller.request.ProfissionalRequest;
import br.com.helpmatch.helpmatchbackend.controller.response.ProfissionalResponse;
import br.com.helpmatch.helpmatchbackend.converter.ProfissionalConverter;
import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.service.ProfissionalService;

import java.util.List;
import java.util.Optional;

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

    	return service.create( converter.converterRequestToDto(profissional) ).map(profissionalDto -> {

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(profissionalDto.getId())
                    .toUri()).body(converter.converterDtoToResponse(profissionalDto));

        }).orElse(ResponseEntity.badRequest().build());

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProfissionalRequest profissional) {
        return service.update(id, converter.converterRequestToDto(profissional))
                .map(dto -> ResponseEntity.ok(converter.converterDtoToResponse(dto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(path = "/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
