package uk.sky.quizz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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
	@JsonIgnore
	private Question questionId;

	@ManyToMany(mappedBy = "answerCollection")
	@JsonIgnore
	private Collection<Player> playerCollection;
}
