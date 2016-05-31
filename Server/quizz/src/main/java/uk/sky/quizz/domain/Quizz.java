package uk.sky.quizz.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Configurable
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Table(name = "quizz")
@Slf4j
@Data
public class Quizz {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private Long id;

	private String nameOfShow;

	private Date date;


}
