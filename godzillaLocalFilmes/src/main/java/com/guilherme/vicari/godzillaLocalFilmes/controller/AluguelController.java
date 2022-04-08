package com.guilherme.vicari.godzillaLocalFilmes.controller;

import com.guilherme.vicari.godzillaLocalFilmes.domain.Aluguel;
import com.guilherme.vicari.godzillaLocalFilmes.domain.Filme;
import com.guilherme.vicari.godzillaLocalFilmes.repository.AluguelRepository;
import com.guilherme.vicari.godzillaLocalFilmes.repository.FilmeRepository;
import com.guilherme.vicari.godzillaLocalFilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AluguelController {
    @Autowired
    private AluguelRepository repositoryAluguel;

    @Autowired
    private FilmeRepository repositoryFilme;


    @PostMapping("/aluguel/{token}/{idFilme}")
    public ResponseEntity addFilme(@PathVariable String token, @PathVariable Integer idFilme){

        Aluguel aluguel = new Aluguel();
        aluguel.setTokenUsuario(token);
        aluguel.setIdFilme(idFilme);

        Filme filme = new Filme();
        filme = repositoryFilme.findById(idFilme).get();
        if(filme.getEstoque()>0){
            repositoryAluguel.save(aluguel);
            filme.setEstoque(filme.getEstoque() - 1);
            repositoryFilme.save(filme);
            return ResponseEntity.status(201).body(aluguel);
        }
        return ResponseEntity.status(403).body("Filme fora de estoque!!");
    }
}
