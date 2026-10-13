package com.gamehub.cadstro_jogo.controller;


import com.gamehub.cadstro_jogo.business.JogoService;
import com.gamehub.cadstro_jogo.infrastructure.entitys.Jogo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogo")
@RequiredArgsConstructor
public class JogoController {

    private final JogoService jogoService;

    @PostMapping
    public ResponseEntity<Void> salvarJogo(@RequestBody Jogo jogo){
        jogoService.salvarJogo(jogo);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Jogo> buscarJogoPorNome(@RequestParam String nome){
        return  ResponseEntity.ok(jogoService.buscarJogoPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteJogoPorNome(@RequestParam String nome){
        jogoService.deletarJogoPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarJogoPorId(@RequestBody Jogo jogo,
                                                    @RequestParam Integer id) {
        jogoService.atualizarJogoPorId(id, jogo);
        return ResponseEntity.ok().build();
    }
}
