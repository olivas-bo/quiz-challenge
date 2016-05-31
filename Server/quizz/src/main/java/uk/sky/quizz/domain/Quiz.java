package uk.sky.quizz.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Table(catalog = "quiz", schema = "")
@XmlRootElement
@Entity
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
	private Integer id;
	@JoinColumn(name = "show_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
	private Show showId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "quizId")
	private Collection<Question> questionCollection;

	public Quiz() {
	}

	public Quiz(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Show getShowId() {
		return showId;
	}

	public void setShowId(Show showId) {
		this.showId = showId;
	}

	@XmlTransient
	public Collection<Question> getQuestionCollection() {
		return questionCollection;
	}

	public void setQuestionCollection(Collection<Question> questionCollection) {
		this.questionCollection = questionCollection;
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
		if (!(object instanceof Quiz)) {
			return false;
		}
		Quiz other = (Quiz) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "uk.sky.quizz.domain.Quiz[ id=" + id + " ]";
	}

}
