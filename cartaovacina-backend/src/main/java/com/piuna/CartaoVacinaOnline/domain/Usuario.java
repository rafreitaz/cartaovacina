package com.piuna.CartaoVacinaOnline.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "TBL_USUARIO")
public class Usuario {

    @GeneratedValue
    @Id
    @Column(name = "ID_USUARIO")
    private Long id;

    @NotNull
    @Column(name = "NOME_USUARIO")
    private String nome;

    @NotNull
    @Column(name = "NU_CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    public Usuario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Usuario() {
        //Construtor vazio
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
