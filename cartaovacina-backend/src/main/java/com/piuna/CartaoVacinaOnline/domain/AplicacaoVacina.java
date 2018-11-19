package com.piuna.CartaoVacinaOnline.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@Entity
@Table(name = "TBL_APLICACAO")
public class AplicacaoVacina {

    @GeneratedValue
    @Id
    @Column(name = "ID_APLICACAO")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_VACINA", referencedColumnName = "ID_VACINA")
    private Vacina vacina;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_CLINICA", referencedColumnName = "ID_CLINICA")
    private Clinica clinica;

    @NotNull
    @Column(name = "DATA_APLICACAO")
    private LocalDate dataAplicacao;

    public AplicacaoVacina(@NotNull Usuario usuario, @NotNull Vacina vacina,
                           @NotNull Clinica clinica, @NotNull LocalDate dataAplicacao) {
        this.usuario = usuario;
        this.vacina = vacina;
        this.clinica = clinica;
        this.dataAplicacao = dataAplicacao;
    }

    public AplicacaoVacina() {
        //Construtor vazio
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vacina getVacina() {
        return vacina;
    }

    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
