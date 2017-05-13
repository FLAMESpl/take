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
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ida;
	FilledSurvey filled;
	String text;	
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIda(){
		return ida;
	}
	public void setIda(int ida){
		this.ida = ida;
	}
	public String getText(){
		return text;
	}
	public void setText(String text){
		this.text = text;
	}
	@ManyToOne
	@XmlTransient
	public FilledSurvey getFilledSurvey(){
		return filled;
	}
	public void setFilledSurvey(FilledSurvey filled){
		this.filled = filled;
	}
}
