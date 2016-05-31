package uk.sky.quizz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uk.sky.quizz.domain.Player;
import uk.sky.quizz.repositories.PlayerRepository;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerRepository playerRepository;

	@RequestMapping(method = RequestMethod.GET, path = "/register/{playerName}")
	public Integer registerUser(@PathVariable String playerName) {

		Player player = new Player();
		player.setName(playerName);
		playerRepository.save(player);

		return player.getId();
	}
}