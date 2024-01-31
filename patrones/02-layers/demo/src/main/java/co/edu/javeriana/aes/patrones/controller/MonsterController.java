package co.edu.javeriana.aes.patrones.controller;

import co.edu.javeriana.aes.patrones.entity.Monster;
import co.edu.javeriana.aes.patrones.service.MonsterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monsters")
@RequiredArgsConstructor
public class MonsterController {
    
    private final MonsterService monsterService;

    @GetMapping
    public List<Monster> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monster> getMonsterById(@PathVariable int id) {
        return monsterService.getMonsterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Monster> createMonster(@RequestBody Monster monster) {
        Monster createdMonster = monsterService.createMonster(monster);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMonster);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonster(@PathVariable int id) {
        monsterService.deleteMonster(id);
        return ResponseEntity.noContent().build();
    }
}
