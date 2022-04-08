package com.guilherme.vicari.godzillaLocalFilmes.repository;

import com.guilherme.vicari.godzillaLocalFilmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    List<Filme> findByAno(Integer filmeAno);
    List<Filme> findByTituloContainingIgnoreCase(String titulo);


}
