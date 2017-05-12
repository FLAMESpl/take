package pl.project.surveys;

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
	@Id
	@GeneratedValue
	@XmlAttribute
	int idt;
	String firstName;
	String lastName;
	@OneToMany(mappedBy="evaluated",fetch=FetchType.LAZY)
	List<FilledSurvey> surveys = new ArrayList<FilledSurvey>();
}
