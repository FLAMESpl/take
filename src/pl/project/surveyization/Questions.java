package pl.project.surveyization;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Questions {
	private List<Question> questions = new ArrayList<Question>();
		
	public Questions(List<Question> questions){
		this.questions = questions;
	}
	public Questions() { }
	
	public List<Question> getQuestions(){
		return questions;
	}
	public void setQuestions(List<Question> questions){
		this.questions = questions;
	}

}
