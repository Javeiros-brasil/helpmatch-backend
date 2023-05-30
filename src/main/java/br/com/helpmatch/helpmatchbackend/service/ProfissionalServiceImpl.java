package br.com.helpmatch.helpmatchbackend.service;

import br.com.helpmatch.helpmatchbackend.dto.ProfissionalDto;
import br.com.helpmatch.helpmatchbackend.entity.ProfissionalEntity;
import br.com.helpmatch.helpmatchbackend.repository.ProfissionalRepository;
import br.com.helpmatch.helpmatchbackend.util.CPFUtil;
import br.com.helpmatch.helpmatchbackend.util.CelularUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    	List<ProfissionalDto> listProfissionalDto = new  ArrayList<>();
    	 
    	
    	for(ProfissionalEntity entity : repository.findAll()) {
    		listProfissionalDto.add(new ProfissionalDto(entity));
    	}
    	
    	
        return listProfissionalDto;
    }

    @Override
    public ProfissionalDto create(ProfissionalDto profissional) {
        //fazer 1- não deve permitir que um profissional se cadastre com o mesmo CPF, Email e Telefone Celular
    	//2- deve verificar se o CPF está em um formato correto;
    	if(!CPFUtil.isCPF(profissional.getCpf())) {
    		throw new RuntimeException("CPF Incorreto!");
    	}
    	
    	
    	//3- deve verificar se o Telefone Celular está em um formato correto; +55XX9XXXXXXXX
    	
		  if(profissional.getContato()== null){
			  throw new RuntimeException("Contato Obrigatório");
		  }
		  
    	if(!CelularUtil.isCelular(profissional.getContato().getCelular())){
		   throw new RuntimeException("Celular Incorreto!");
		   
	   }
    	
    	
    	//4- A aplicação deve enviar um e-mail para o e-mail do cliente;
    	//5- Todo profissional novo deve ser registrado contendo o valor false no campo Ativo
    	//6- O Profissional que ler e aceitar os termos consegue criar uma conta;
    	//7- O Profissional que não preencher as informações obrigatórias corretamente
    	
    	
    	
    	//8- O Profissional que não aceitar os termos não consegue criar uma conta;
    	
    	ProfissionalEntity entity =  repository.save(new ProfissionalEntity(profissional));
        return new ProfissionalDto(entity);
    }

    @Override
    public ProfissionalDto update(Long id, ProfissionalDto profissional) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
