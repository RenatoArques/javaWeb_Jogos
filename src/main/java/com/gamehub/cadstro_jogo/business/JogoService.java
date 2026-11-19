package com.gamehub.cadstro_jogo.business;

import com.gamehub.cadstro_jogo.infrastructure.entitys.Jogo;
import com.gamehub.cadstro_jogo.infrastructure.repository.JogoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository repository;

    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public List<Jogo> listarJogos() {
        return repository.findAll();
    }

    public void salvarJogo(Jogo jogo) {
        // Garante que o POST sempre CRIE um registro novo (ignora id enviado pelo cliente)
        jogo.setId(null);
        repository.saveAndFlush(jogo);
    }

    public Jogo buscarJogoPorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo nao encontrado"));
    }

    public void deletarJogoPorNome(String nome) {
        repository.deleteByNome(nome);
    }

    public void deletarJogoPorId(Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo nao encontrado");
        }
        repository.deleteById(id);
    }

    public void atualizarJogoPorId(Integer id, Jogo jogo) {
        Jogo jogoEntity = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo nao encontrado"));

        Jogo jogoAtualizado = Jogo.builder()
                .id(jogoEntity.getId())
                .nome(jogo.getNome() != null ? jogo.getNome() : jogoEntity.getNome())
                .plataforma(jogo.getPlataforma() != null ? jogo.getPlataforma() : jogoEntity.getPlataforma())
                .genero(jogo.getGenero() != null ? jogo.getGenero() : jogoEntity.getGenero())
                .preco(jogo.getPreco() != null ? jogo.getPreco() : jogoEntity.getPreco())
                .build();

        repository.saveAndFlush(jogoAtualizado);
    }
}