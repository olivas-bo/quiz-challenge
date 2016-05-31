package uk.sky.quizz.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(catalog = "quiz", schema = "")
@XmlRootElement
public class Show implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
	private Integer id;
	@Column(length = 255)
	private String text;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "showId")
	private Collection<Quiz> quizCollection;

	public Show() {
	}

	public Show(Integer id) {
		this.id = id;
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
	public Collection<Quiz> getQuizCollection() {
		return quizCollection;
	}

	public void setQuizCollection(Collection<Quiz> quizCollection) {
		this.quizCollection = quizCollection;
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
		if (!(object instanceof Show)) {
			return false;
		}
		Show other = (Show) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "uk.sky.quizz.domain.Show[ id=" + id + " ]";
	}

}
