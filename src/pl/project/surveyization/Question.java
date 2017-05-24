package pl.project.surveyization;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idq;
	Survey survey;
	String text;	
	Set<Answer> answers = new HashSet<Answer>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	public int getIdq(){
		return idq;
	}
	public void setIdq(int idq){
		this.idq = idq;
	}
	public String getText(){
		return text;
	}
	public void setText(String text){
		this.text = text;
	}
	@ManyToOne
	@XmlTransient
	public Survey getSurvey(){
		return survey;
	}
	public void setSurvey(Survey survey){
		this.survey = survey;
	}
	@XmlElement
	@OneToMany(targetEntity=Answer.class,mappedBy="question",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	public Set<Answer> getAnswers(){
		return answers;
	}
	public void setAnswers(Set<Answer> answers){
		this.answers = answers;
	}
}
