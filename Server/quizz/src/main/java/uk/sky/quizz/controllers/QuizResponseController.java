package uk.sky.quizz.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz/response")
public class QuizResponseController {

	public void receiveResponse(String userId, long quizQuestionId, int response) {

	}
}
