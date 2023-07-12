package br.com.helpmatch.helpmatchbackend.service;

import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.entities.Profissional;
import br.com.helpmatch.helpmatchbackend.repository.ProfissionalRepository;
import br.com.helpmatch.helpmatchbackend.service.email.IEmailConfirmationService;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfissionalService{

    @Autowired
    private ProfissionalRepository repository;
    
    @Autowired
    public IEmailConfirmationService emailService;
    
    @Autowired
    public ModelMapper mapper;
    
    /**
     * Metodo para pegar um profissional pelo Id dele
     * @param id - Identificador do profissional
     * @return ProfissionalDTO - profissional correspondente ao Id
     */
    public Optional<ProfissionalDto> getById(Long id) {

        return repository.findById(id).map(entity -> Optional.of( mapper.map( entity, ProfissionalDto.class )  ))
                .orElse(Optional.empty());
    }
    /**
     * Metodo para pegar todos os profissional
     * @return List<ProfissionalDto> - Lista com todos os profissionais na sistema
     */
    public List<ProfissionalDto> getAll() {
    	return ((Collection<Profissional>) repository.findAll()).stream().map(clienteEntity -> mapper.map(clienteEntity, ProfissionalDto.class)).collect(Collectors.toList());
    }
    /**
     * Metodo para criar um Profissional
     * @param profissional - Profissional que sera criado
     * @return ProfissionalDto - Profissional criado
     */
    public Optional<ProfissionalDto> create(ProfissionalDto profissional) {

        // fazer 1- não deve permitir que um profissional se cadastre com o mesmo CPF, Email e Telefone Celular
    	profissional.getAcesso().setAtivo(false);
        if(!profissional.getAcesso().isAceitouTermos()){
            // Erro!!!
        }

        emailService.sendEmail(profissional.getAcesso().getUsername());

    	Profissional entity =  repository.save( mapper.map( profissional, Profissional.class ) );
    	
    	profissional.setId(entity.getId());
    	
        return Optional.of( profissional );
    }
    /**
     * Metodo para criar um profissional
     * @param id - Identificador do cliente que sera atualizado
     * @param profissional - Profissional com os novos dados
     * @return ProfissionalDto - Profissional com os dados atualizados
     */
    public Optional<ProfissionalDto> update(Long id, ProfissionalDto profissional) {

        return repository.findById(id).map(entity -> {
        	
        	entity.withCpf(profissional.getCpf())
        		  .withNomeCompleto(profissional.getNomeCompleto())
        		  .withDataNascimento(profissional.getDataNascimento())
        		  .withNomeMae(profissional.getNomeMae())
        		  .withNomePai(profissional.getNomePai());

            repository.save(entity);

            return Optional.of( mapper.map( entity, ProfissionalDto.class ) );

        }).orElse(Optional.empty());

    }
    /**
     * Metodo para remover um profissional
     * @param id - Identificador do profissional que sera removido
     */
    @Transactional
    public void delete(Long id) {
        System.out.println(id);
        repository.deleteById(id);
    }
}
