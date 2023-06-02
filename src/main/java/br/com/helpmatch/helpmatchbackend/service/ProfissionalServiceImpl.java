package br.com.helpmatch.helpmatchbackend.service;

import br.com.helpmatch.helpmatchbackend.converter.ProfissionalConverter;
import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.entity.ProfissionalEntity;
import br.com.helpmatch.helpmatchbackend.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalServiceImpl implements ProfissionalService{

    @Autowired
    public ProfissionalRepository repository;
    @Autowired
    public ProfissionalConverter converter;

    @Override
    public Optional<ProfissionalDto> getById(Long id) {

        return repository.findById(id).map(entity -> Optional.of(converter.converterEntityToDto(entity)))
                .orElse(Optional.empty());
    }

    @Override
    public List<ProfissionalDto> getAll() {
    	return converter.converterListEntityToListDto( (Collection<ProfissionalEntity>) repository.findAll());
    }

    @Override
    public ProfissionalDto create(ProfissionalDto profissional) {

        // fazer 1- não deve permitir que um profissional se cadastre com o mesmo CPF, Email e Telefone Celular
    	profissional.getAcesso().setAtivo(false);
        if(!profissional.getAcesso().isAceitouTermos()){
            // Erro!!!
        }
        //fazer 4- A aplicação deve enviar um e-mail para o e-mail do cliente;

    	ProfissionalEntity entity =  repository.save(converter.converterDtoToEntity(profissional));

        return converter.converterEntityToDto(entity);
    }

    @Override
    public Optional<ProfissionalDto> update(Long id, ProfissionalDto profissional) {

        return repository.findById(id).map(entity -> {

            entity.setCpf(profissional.getCpf());
            entity.setNomeCompleto(profissional.getNomeCompleto());
            entity.setDataNascimento(profissional.getDataNascimento());
            entity.setNomeMae(profissional.getNomeMae());
            entity.setNomePai(profissional.getNomePai());

            repository.save(entity);

            return Optional.of(converter.converterEntityToDto(entity));

        }).orElse(Optional.empty());

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
