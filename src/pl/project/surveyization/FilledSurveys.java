package pl.project.surveyization;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FilledSurveys {
	private List<FilledSurvey> filled = new ArrayList<FilledSurvey>();
		
	public FilledSurveys(List<FilledSurvey> filled){
		this.filled = filled;
	}
	public FilledSurveys() { }
	
	public List<FilledSurvey> getFilledSurveys(){
		return filled;
	}
	public void setFilledSurveys(List<FilledSurvey> filled){
		this.filled = filled;
	}

}
