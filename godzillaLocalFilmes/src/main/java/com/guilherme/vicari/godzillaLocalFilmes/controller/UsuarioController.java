package com.guilherme.vicari.godzillaLocalFilmes.controller;
import java.util.Random;
import com.guilherme.vicari.godzillaLocalFilmes.domain.Filme;
import com.guilherme.vicari.godzillaLocalFilmes.domain.Usuario;
import com.guilherme.vicari.godzillaLocalFilmes.repository.FilmeRepository;
import com.guilherme.vicari.godzillaLocalFilmes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/usuario")
    public ResponseEntity addUsuario(@RequestBody Usuario user){
        Random r = new Random();
        String token = "";
        String alphabet = "1234567890abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 20; i++) {
            token += alphabet.charAt(r.nextInt(alphabet.length()));
        }
        user.setToken(token);
        repository.save(user);
        user.setSenha("senha criptografada");
        return ResponseEntity.status(201).body(user);
    }


}
