package com.guilherme.vicari.godzillaLocalFilmes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idFilme;
    private String tokenUsuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getTokenUsuario() {
        return tokenUsuario;
    }

    public void setTokenUsuario(String tokenUsuario) {
        this.tokenUsuario = tokenUsuario;
    }
}
