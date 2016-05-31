package uk.sky.quizz.repositories;

import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uk.sky.quizz.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

	@Query(value = "SELECT p.name, count(pa.answer_id) from player p join player_answer pa on p.id = pa.player_id " +
		"join answer a on a.id = pa.answer_id WHERE a.correct GROUP BY p.name",
		nativeQuery = true)
	Map<String, Integer> getScores();

}
