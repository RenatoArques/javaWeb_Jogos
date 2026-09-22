package com.gamehub.cadstro_jogo.infrastructure.repository;

import com.gamehub.cadstro_jogo.infrastructure.entitys.Jogo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogo, Integer>{
    Optional<Jogo> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}

