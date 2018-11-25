package com.piuna.CartaoVacinaOnline.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AplicacaoVacinaDTO {

    private Long id;

    private String usuario;

    private String vacina;

    private String clinica;

    private LocalDate dataAplicacao;

    public AplicacaoVacinaDTO(Long id, String usuario, String vacina, String clinica, LocalDate dataAplicacao) {
        this.id = id;
        this.usuario = usuario;
        this.vacina = vacina;
        this.clinica = clinica;
        this.dataAplicacao = dataAplicacao;
    }

    public AplicacaoVacinaDTO() {
        //Construtor vazio
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getVacina() {
        return vacina;
    }

    public void setVacina(String vacina) {
        this.vacina = vacina;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getDataAplicacaoStr() {
        return this.dataAplicacao.format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
