package uk.sky.quizz.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Configurable
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(name = "userscore")
@Slf4j
@Data
public class UserScore {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;


	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quizz_id", nullable = false)
	private Quizz quizz;

	private String name;

	private int score;

}
