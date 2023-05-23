package br.com.helpmatch.helpmatchbackend.service;

import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    //Construtor passando argumentos obrigatorios.
    @Nonnull
    public ClienteService(cpf, email, telefone) {

    //metodo para validar o cpf iserido
     ValidaCpf cpf = new ValidaCpf(){
         if ( cpf == List<ClienteService.findALL>)

         {
             return System.out.println("CPF já cadastrado!")
             else{
                 new save(ClienteService.cpf);
             }
         };

     };

     //metodo para validar o email inserido
     ValidaEmail validaEmail = new ValidaEmail(){

     }


    }
}
