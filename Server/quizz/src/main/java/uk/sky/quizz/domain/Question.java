package uk.sky.quizz.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Table(catalog = "quiz", schema = "")
@XmlRootElement
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Integer id;
	@Basic(optional = false)
	@Column(nullable = false, length = 255)
	private String text;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
	private Collection<Answer> answerCollection;
	@JoinColumn(name = "quiz_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(optional = false)
	private Quiz quizId;
	@OneToMany(mappedBy = "questionId")
	private Collection<Player> playerCollection;

	public Question(Integer id) {
		this.id = id;
	}
}
