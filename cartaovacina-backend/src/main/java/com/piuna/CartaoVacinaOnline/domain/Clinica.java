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
@Table(name = "TBL_CLINICA")
public class Clinica {

    @GeneratedValue
    @Id
    @Column(name = "ID_CLINICA")
    private Long id;

    @NotNull
    @Column(name = "NOME_CLINICA")
    private String nome;

    @NotNull
    @Column(name = "NU_CNPJ")
    private String cnpj;

    public Clinica(@NotNull String nome, @NotNull String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Clinica() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
