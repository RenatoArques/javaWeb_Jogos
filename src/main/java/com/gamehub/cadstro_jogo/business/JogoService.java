package com.gamehub.cadstro_jogo.business;

import com.gamehub.cadstro_jogo.infrastructure.entitys.Jogo;
import com.gamehub.cadstro_jogo.infrastructure.repository.JogoRepository;
import org.springframework.stereotype.Service;

@Service
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public void salvarJogo(Jogo jogo){
        repository.saveAndFlush(jogo);
    }

    public Jogo buscarJogoPorNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("nome nao encontrado")
        );
    }
}
