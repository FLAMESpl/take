package pl.project.surveyization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idt;
	String firstName;
	String lastName;
	//@OneToMany(mappedBy="evaluated",fetch=FetchType.LAZY)
	//List<FilledSurvey> surveys = new ArrayList<FilledSurvey>();
	
	@Id
	@GeneratedValue
	@XmlAttribute
	public int getIdt(){
		return idt;
	}
	public void setidt(int idt){
		this.idt = idt;
	}
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	//public List<FilledSurvey> getFilledSurveys(){
	//	return surveys;
	//}
	//public void setFilledSurveys(List<Survey> surveys){
	//	this.surveys = surveys;
	//}
}
