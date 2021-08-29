package br.com.project.plusfriends.service;

import org.springframework.stereotype.Service;

import java.util.List;
import br.com.project.plusfriends.model.Pessoa;
import br.com.project.plusfriends.repository.PessoaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa save(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    
}