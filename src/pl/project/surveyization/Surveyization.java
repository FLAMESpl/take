package pl.project.surveyization;

import javax.ejb.Local;

@Local
public interface Surveyization {

	public abstract String create(Survey survey);
	
	public abstract Survey find(int ids);

	public abstract Surveys getSurveys();

	public abstract String update(Survey survey);

	public abstract String delete(int ids);
	
}
