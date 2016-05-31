package uk.sky.quizz.domain;

import java.io.Serializable;
import java.util.Collection;
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
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer id;

	@Column(length = 255)
	private String text;
	private Boolean correct;

	@JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Question questionId;

	public Answer(Integer id) {
		this.id = id;
	}

	@ManyToMany(mappedBy = "answerCollection")
	private Collection<Player> playerCollection;
}
