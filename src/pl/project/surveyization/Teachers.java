package pl.project.surveyization;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Teachers {
	private List<Teacher> teachers = new ArrayList<Teacher>();
		
	public Teachers(List<Teacher> teachers){
		this.teachers = teachers;
	}
	public Teachers() { }
	
	public List<Teacher> getTeachers(){
		return teachers;
	}
	public void setTeachers(List<Teacher> teacher){
		this.teachers = teachers;
	}

}
