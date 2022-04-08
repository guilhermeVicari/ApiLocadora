package com.guilherme.vicari.godzillaLocalFilmes.repository;

import com.guilherme.vicari.godzillaLocalFilmes.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
