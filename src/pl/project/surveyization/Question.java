package pl.project.surveyization;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idq;
	Survey survey;
	String text;	
	@Id
	@GeneratedValue
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
}
