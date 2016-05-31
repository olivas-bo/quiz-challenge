package uk.sky.quizz.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(catalog = "quiz", schema = "")
@XmlRootElement
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

	public Question() {
	}

	public Question(Integer id) {
		this.id = id;
	}

	public Question(Integer id, String text) {
		this.id = id;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@XmlTransient
	public Collection<Answer> getAnswerCollection() {
		return answerCollection;
	}

	public void setAnswerCollection(Collection<Answer> answerCollection) {
		this.answerCollection = answerCollection;
	}

	public Quiz getQuizId() {
		return quizId;
	}

	public void setQuizId(Quiz quizId) {
		this.quizId = quizId;
	}

	@XmlTransient
	public Collection<Player> getPlayerCollection() {
		return playerCollection;
	}

	public void setPlayerCollection(Collection<Player> playerCollection) {
		this.playerCollection = playerCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Question)) {
			return false;
		}
		Question other = (Question) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "uk.sky.quizz.domain.Question[ id=" + id + " ]";
	}

}
