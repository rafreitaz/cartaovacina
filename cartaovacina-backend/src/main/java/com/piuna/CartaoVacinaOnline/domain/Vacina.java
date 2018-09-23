package com.piuna.CartaoVacinaOnline.domain;

/**
 * NOTA: Todos os objetos comuns que usaremos ficarão no pacote "domain"
 * Para maior organização vamos utilizar um pacote diferente pra cada tipo de objeto
 */

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity  //Define a classe como uma entidade, ou seja, representada por uma tabela no banco (vamos colocar qual depois)
@EqualsAndHashCode  //Gera os métodos equals() e hashcode() utilizados pelos arquivos de configuração
@ToString  //Gera o método toString() que basicamente transforma o objeto em uma string com os atributos, tb usado pela configuração
public class Vacina {

    @Id  //É sempre necessário identificar o ID da entidade para fazer o mapeamento do banco
    @GeneratedValue  //Autoexplicativo
    private Long id;

    private String nome;

    //Construtor
    public Vacina(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Vacina() {
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
}
