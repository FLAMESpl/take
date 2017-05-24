package pl.project.surveyization;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FilledCreator {
	int ids;
	int idt;
	FilledSurvey filled;
	
	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public int getIdt() {
		return idt;
	}
	public void setIdt(int idt) {
		this.idt = idt;
	}
	public FilledSurvey getFilled() {
		return filled;
	}
	public void setFilled(FilledSurvey filled) {
		this.filled = filled;
	}

}
