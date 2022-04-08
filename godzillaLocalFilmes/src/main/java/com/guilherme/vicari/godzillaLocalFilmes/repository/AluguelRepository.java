package com.guilherme.vicari.godzillaLocalFilmes.repository;

import com.guilherme.vicari.godzillaLocalFilmes.domain.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {

}
