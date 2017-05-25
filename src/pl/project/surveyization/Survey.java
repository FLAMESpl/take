package pl.project.surveyization;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.TransactionAttribute;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ids;
	String description;
	String date;
	
	Set<Question> questions = new HashSet<Question>();
	Set<FilledSurvey> filledSurveys = new HashSet<FilledSurvey>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	public int getIds(){
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDate(){
		return date;
	}
	public void setDate(String date){
		this.date = date;
	}
	@XmlElement
	@OneToMany(targetEntity=Question.class,mappedBy="survey",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	public Set<Question> getQuestions(){
		return questions;
	}
	public void setQuestions(Set<Question> questions){
		this.questions = questions;
		}
	@XmlElement
	@OneToMany(targetEntity=FilledSurvey.class,mappedBy="parent",cascade=CascadeType.MERGE,fetch=FetchType.EAGER,orphanRemoval=true)
	public Set<FilledSurvey> getFilledSurveys(){
		return filledSurveys;
	}
	public void setFilledSurveys(Set<FilledSurvey> filledSurveys){
		this.filledSurveys = filledSurveys;
	}
	
}
