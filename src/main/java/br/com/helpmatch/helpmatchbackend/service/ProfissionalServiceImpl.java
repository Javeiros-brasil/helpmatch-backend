package br.com.helpmatch.helpmatchbackend.service;

import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfissionalServiceImpl implements ProfissionalService{

    @Autowired
    public ProfissionalRepository repository;

    @Override
    public ProfissionalDto getById(Long id) {
        return null;
    }

    @Override
    public List<ProfissionalDto> getAll() {
        return null;
    }

    @Override
    public ProfissionalDto create(ProfissionalDto profissional) {
        return null;
    }

    @Override
    public ProfissionalDto update(Long id, ProfissionalDto profissional) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
