package com.gamehub.cadstro_jogo.controller;

import com.gamehub.cadstro_jogo.business.JogoService;
import com.gamehub.cadstro_jogo.infrastructure.entitys.Jogo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Libera o frontend (ex.: index.html aberto direto). Em produção, restrinja a origem.
public class JogoController {

    private final JogoService jogoService;

    // GET /api/jogos -> lista todos os jogos
    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos() {
        return ResponseEntity.ok(jogoService.listarJogos());
    }

    // GET /api/jogos/busca?nome=Zelda -> busca por nome (mantido do endpoint original)
    @GetMapping("/busca")
    public ResponseEntity<Jogo> buscarJogoPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(jogoService.buscarJogoPorNome(nome));
    }

    // POST /api/jogos -> cadastra um novo jogo (o id é gerado pelo banco)
    @PostMapping
    public ResponseEntity<Void> salvarJogo(@RequestBody Jogo jogo) {
        jogoService.salvarJogo(jogo);
        return ResponseEntity.ok().build();
    }

    // PUT /api/jogos/{id} -> atualiza o jogo com o id informado
    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarJogo(@PathVariable Integer id, @RequestBody Jogo jogo) {
        jogoService.atualizarJogoPorId(id, jogo);
        return ResponseEntity.ok().build();
    }

    // DELETE /api/jogos/{id} -> exclui o jogo com o id informado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogo(@PathVariable Integer id) {
        jogoService.deletarJogoPorId(id);
        return ResponseEntity.ok().build();
    }
}