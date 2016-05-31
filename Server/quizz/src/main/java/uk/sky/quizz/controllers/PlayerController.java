package uk.sky.quizz.controllers;

import java.util.HashMap;
import java.util.Map;
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

	@RequestMapping(method = RequestMethod.POST, path = "/{playerId}/play/{answerId}/")
	public void play(@PathVariable int playerId, @PathVariable int answerId) {

	}

	@RequestMapping(method = RequestMethod.GET, path = "/scores")
	public Map<String, Integer> scores() {
		return playerRepository.getScores();
	}
}
