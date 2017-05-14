package pl.project.surveyization;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class FilledSurvey implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idf;
	int ids;
	int idt;
	String description;
	String date;
	Survey parent;
	Teacher evaluated;
	Set<Answer> answers = new HashSet<Answer>();
	
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
	public int getIds(){
		return ids;
	}
	public void setIds(int ids){
		this.ids = ids;
	}
	public int getIdt(){
		return idt;
	}
	public void setIdt(int idt){
		this.idt = idt;
	}
	@ManyToOne
	@XmlTransient
	public Teacher getEvaluated(){
		return evaluated;
	}
	public void setEvaluated(Teacher teacher){
		this.evaluated = teacher;
	}
	@ManyToOne
	@XmlTransient
	public Survey getParent(){
		return parent;
	}
	public void setParent(Survey parent){
		this.parent = parent;
	}
	@XmlElement
	@OneToMany(targetEntity=Answer.class,mappedBy="filledSurvey",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	public Set<Answer> getAnswers(){
		return answers;
	}
	public void setAnswers(Set<Answer> answers){
		if(answers != null){
		for (Answer q : answers)
			q.filledSurvey = this;
		}
		this.answers = answers;
		}
}
