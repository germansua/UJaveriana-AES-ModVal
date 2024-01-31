package co.edu.javeriana.aes.patrones.repository;

import co.edu.javeriana.aes.patrones.entity.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Integer> {
    
}
