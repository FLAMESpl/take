package pl.project.surveyization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class FilledSurvey implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idf;
	String description;
	String date;
	List<Answer> answers = new ArrayList<Answer>();
	
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdf(){
		return idf;
	}
	public void setIdf(int idf) {
		this.idf = idf;
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
	@OneToMany(targetEntity=Answer.class,mappedBy="filledSurvey",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	public List<Answer> getAnswers(){
		return answers;
	}
	public void setAnswers(List<Answer> answers){
		if(answers != null){
		for (Answer q : answers)
			q.filledSurvey = this;
		}
		this.answers = answers;
		}
}
