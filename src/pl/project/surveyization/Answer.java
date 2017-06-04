package pl.project.surveyization;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@XmlRootElement
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ida;
	private String questionText;
	@Transient
	private int idq;
	private Question question;
	private FilledSurvey filledSurvey;
	private String answerText;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	public int getIda(){
		return ida;
	}
	public void setIda(int ida){
		this.ida = ida;
	}
	public String getText(){
		return answerText;
	}
	public void setText(String text){
		this.answerText = text;
	}
	@Transient
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	@ManyToOne
	@XmlTransient
	public Question getQuestion(){
		return question;
	}
	public void setQuestion(Question question){
		this.question = question;
	}
	@ManyToOne
	@XmlTransient
	public FilledSurvey getFilledSurvey(){
		return filledSurvey;
	}
	public void setFilledSurvey(FilledSurvey filledsurvey){
		this.filledSurvey = filledsurvey;
	}
	@Transient
	public int getIdq() {
		return idq;
	}
	public void setIdq(int idq) {
		this.idq = idq;
	}
}
