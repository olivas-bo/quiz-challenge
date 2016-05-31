package uk.sky.quizz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.sky.quizz.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
