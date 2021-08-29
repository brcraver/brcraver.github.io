package br.com.project.plusfriends.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jdk.jfr.Name;
import lombok.Data;

@Entity
@Table
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Name("nome")
    String nome;

    @Name("sobrenome")
    String sobrenome;

    @Name("sexo")
    String sexo;

    @Name("idade")
    int idade;

    @Name("cpf")
    String cpf;

    @Name("email")
    String email;

    @Name("usuario")
    String usuario;

    @Name("senha")
    String senha;
}