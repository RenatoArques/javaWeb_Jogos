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

    public void deletarJogoPorNome(String nome){
        repository.deleteByNome(nome);
    }

    public  void atualizarJogoPorId(Integer id, Jogo jogo){
        Jogo jogoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Jogo nao encontrado"));
        Jogo jogoAtualizado = Jogo.builder()
                .nome(jogo.getNome() != null ? jogo.getNome() :
                        jogoEntity.getNome())
                .plataforma(jogo.getPlataforma() != null ? jogo.getPlataforma() :
                        jogoEntity.getPlataforma())
                .genero(jogo.getGenero() != null ? jogo.getGenero() :
                        jogoEntity.getGenero())
                .preco(jogo.getPreco() != null ? jogo.getPreco() :
                        jogoEntity.getPreco())
                .id(jogoEntity.getId())
                .build();
        //novas mudancas
    }
}
