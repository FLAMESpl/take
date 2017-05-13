package pl.project.surveyization;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Survey implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ids;
	String description;
	String date;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="survey")
	List<Question> questions = new ArrayList<Question>();
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	//List<FilledSurvey> filledSurveys = new ArrayList<FilledSurvey>();
	
	@Id
	@GeneratedValue
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
	public List<Question> getQuestions(){
		return questions;
	}
	public void setQuestions(List<Question> questions){
		this.questions = questions;
	}
	//public List<FilledSurvey> getFilledSurveys(){
	//	return filledSurveys;
	//}
	//public void setFilledSurveys(List<FilledSurvey> filledSurveys){
	//	this.filledSurveys = filledSurveys;
	//}
	
}
