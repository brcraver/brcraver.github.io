package br.com.project.plusfriends.repository;

import br.com.project.plusfriends.model.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}