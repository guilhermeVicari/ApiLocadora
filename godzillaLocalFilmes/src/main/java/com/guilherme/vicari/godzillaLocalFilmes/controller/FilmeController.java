package com.guilherme.vicari.godzillaLocalFilmes.controller;

import com.guilherme.vicari.godzillaLocalFilmes.domain.Filme;
import com.guilherme.vicari.godzillaLocalFilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmeController {
    @Autowired
    private FilmeRepository repository;

    @GetMapping("/filmes")
    public ResponseEntity allFilmes(){
        if(repository.findAll().isEmpty()){
            return ResponseEntity.status(403).body("Não existe filmes");
        }
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping("/filme")
    public ResponseEntity addFilme(@RequestBody Filme novoFilme){
        repository.save(novoFilme);
        return ResponseEntity.status(201).body(novoFilme);
    }

    @GetMapping("/filmes/ano/{filmeAno}")
    public ResponseEntity allFilmesAno(@PathVariable Integer filmeAno){
        if(repository.findByAno(filmeAno).isEmpty()){
            return ResponseEntity.status(403).body("Não existe filmes nesse ano");
        }
        return ResponseEntity.status(200).body(repository.findByAno(filmeAno));
    }

    @GetMapping("/filmes/titulo/{filmeTitulo}")
    public ResponseEntity allFilmesTitulo(@PathVariable String filmeTitulo){

        if (repository.findByTituloContainingIgnoreCase(filmeTitulo).isEmpty()){
            return ResponseEntity.status(403).body("Não existe filme com esse nome");
        }
        return ResponseEntity.ok().body(repository.findByTituloContainingIgnoreCase(filmeTitulo));
    }




}
