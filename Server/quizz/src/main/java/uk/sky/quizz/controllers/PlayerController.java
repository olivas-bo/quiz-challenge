package uk.sky.quizz.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import uk.sky.quizz.domain.Player;
import uk.sky.quizz.repositories.PlayerRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/player")
public class PlayerController {

	private final PlayerRepository playerRepository;

	@Autowired
	public PlayerController(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/register/{playerName}")
	public Integer registerUser(@PathVariable String playerName) {
		Player player = new Player();
		player.setName(playerName);
		playerRepository.save(player);
		return player.getId();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/scores")
	public Map<String, Integer> scores() {
		return playerRepository.getScores()
			.stream()
			.map(objs -> Collections.singletonMap(objs[0].toString(), Integer.valueOf(objs[1].toString())))
			.sorted((m1, m2) -> m2.values().stream().findFirst().get().compareTo(m1.values().stream().findFirst().get()))
			.reduce((m1, m2) -> {
				Map<String, Integer> m = new LinkedHashMap<>();
				m.putAll(m1);
				m.putAll(m2);
				return m;
			}).get();
	}
}
