package uk.sky.quizz.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@XmlRootElement
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer id;


	@ManyToMany
	@JoinTable(name = "player_answer",
		joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "answer_id", referencedColumnName = "id"))

	private Collection<Answer> answerCollection;

	private String name;

	public Player(Integer id) {
		this.id = id;
	}
}
