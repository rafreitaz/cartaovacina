package com.piuna.CartaoVacinaOnline.domain;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TBL_ACESSO")
public class Acesso {

    @Id
    @GeneratedValue
    @Column(name = "ID_ACESSO")
    private Long id;

    @NotNull
    @Column(name = "LOGIN")
    private String login;

    @NotNull
    @Column(name = "SENHA")
    private String senha;

    @NotNull
    @Column(name = "TIPO_ACESSO")
    private String tipoAcesso;

    public Acesso(@NotNull String login, @NotNull String senha, @NotNull String tipoAcesso) {
        this.login = login;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
    }

    public Acesso() {
        //Construtor vazio
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(String tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }
}
