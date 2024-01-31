package co.edu.javeriana.aes.patrones.service;

import co.edu.javeriana.aes.patrones.entity.Monster;
import co.edu.javeriana.aes.patrones.repository.MonsterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonsterService {

    private final MonsterRepository monstersRepository;

    public List<Monster> getAllMonsters() {
        return monstersRepository.findAll();
    }

    public Optional<Monster> getMonsterById(int id) {
        return monstersRepository.findById(id);
    }

    public Monster createMonster(Monster monster) {
        return monstersRepository.save(monster);
    }

    public void deleteMonster(int id) {
        monstersRepository.deleteById(id);
    }
}