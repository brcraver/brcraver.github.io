package br.com.project.plusfriends.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.plusfriends.model.Pessoa;
import br.com.project.plusfriends.service.PessoaService;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:8080/plusFriends")
@RestController
@AllArgsConstructor
@RequestMapping("/**")
public class PessoaController {

    private PessoaService pessoaService;

    @CrossOrigin
    @GetMapping(path = "/getUsuarioBancoDados")
    public ResponseEntity<?> findAll(){
        List<Pessoa> pessoas =  pessoaService.findAll();
        return ResponseEntity.ok(pessoas.get(0).getNome());
    }

    @CrossOrigin
    @GetMapping(path = "/getUsuarioBancoDados/{nomUsuario}/{senhaUsuario}")
    public ResponseEntity<?> findUsuarioSenha(@PathVariable String nomUsuario, @PathVariable String senhaUsuario){
        List<Pessoa> pessoas =  pessoaService.findAll();
        int indice = verificaIndiceUsuario(pessoas, nomUsuario);
        if(indice > -1)
            return ResponseEntity
                    .ok(verificaSenhaCorreto(pessoas, indice, senhaUsuario) > -1 ? pessoas.get(indice) : "Senha incorreta");
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/postUsuarioBancoDados")
    public ResponseEntity<?> save(@RequestBody Pessoa pessoa){
        Pessoa pessoaAdded = pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaAdded);
    }


    public int verificaIndiceUsuario(List<Pessoa> pessoas, String nomUsuario){
        int indice = -1;

        for(int x = 0; x<=pessoas.size(); x++){
            if(pessoas.get(x).getUsuario().toString().equals(nomUsuario)){
                indice = x;
                x = pessoas.size();
            }
        }

        return indice;
    }

    public int verificaSenhaCorreto(List<Pessoa> pessoas, int indice, String senhaUsuario){

        if(pessoas.get(indice).getSenha().toString().equals(senhaUsuario))
            return indice;
        else
            return -1;
    }
    
}