package pl.project.surveyization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Survey.class,FilledSurvey.class,Teacher.class})
public class SetResponse<T> {

	private Set<T> set = new HashSet<T>();
	
	public SetResponse(Set<T> set){
		this.set = set;
	}
	
	public SetResponse(List<T> list){
		this.set = new HashSet<T>(list);
	}
	
	public SetResponse() { }
	
	public Set<T> getSet(){
		return set;
	}
	public void setSet(Set<T> set){
		this.set = set;
	}
}
