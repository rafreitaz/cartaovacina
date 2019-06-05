package com.piuna.CartaoVacinaOnline.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@EqualsAndHashCode
@ToString
@Table(name = "TBL_VACINA")
public class Vacina {

    @Id
    @GeneratedValue
    @Column(name = "ID_VACINA")
    private Long id;

    @NotNull
    @Column(name = "NOME_VACINA")
    private String nome;

    public Vacina(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Vacina() {

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
}
