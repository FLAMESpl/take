package pl.project.surveyization;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idq;
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
}
