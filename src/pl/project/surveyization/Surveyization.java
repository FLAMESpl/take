package pl.project.surveyization;

import javax.ejb.Local;

@Local
public interface Surveyization {

	public abstract String create(Survey survey);
	
	public abstract Survey findSurvey(int ids);

	public abstract SetResponse<Survey> getSurveys();

	public abstract String update(Survey survey);

	public abstract String deleteSurvey(int ids);
	
	public abstract String create(FilledSurvey filled);
	
	public abstract FilledSurvey findFilledSurvey(int idf);
	
	public abstract SetResponse<FilledSurvey> getFilledSurveys();
	
	public abstract String update(FilledSurvey filled);
	
	public abstract String deleteFilledSurvey(int idf);
	
	public abstract String create(Teacher teacher);
	
	public abstract Teacher findTeacher(int idt);

	public abstract SetResponse<Teacher> getTeachers();

	public abstract String update(Teacher teacher);

	public abstract String deleteTeacher(int idt);
	
}
