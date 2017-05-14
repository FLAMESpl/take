package pl.project.surveyization;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SurveyizationEJB {

	@PersistenceContext(name="surveyization")
	EntityManager manager;
	
	public void create(Survey survey) {
		System.out.println("Creating survey!");
		manager.persist(survey);
	}
	public void deleteSurvey(int ids) {
		System.out.println("Deleting survey!");
		Survey survey = manager.find(Survey.class, ids);
		manager.remove(survey);
	}
	public Survey findSurvey(int ids) {
		return manager.find(Survey.class, ids);
	}
	public List<Survey> getSurvey(){
		Query q = manager.createQuery("select s from Survey s");
		@SuppressWarnings("unchecked")
		List<Survey> list = q.getResultList();
		return list;
	}
	public void updateSurvey(Survey survey){
		survey = manager.merge(survey);
	}
	public void create(FilledSurvey filled) {
		System.out.println("Creating filled!");
		manager.persist(filled);
	}
	public void deleteFilledSurvey(int idf) {
		System.out.println("Deleting filled!");
		FilledSurvey filled = manager.find(FilledSurvey.class, idf);
		manager.remove(filled);
	}
	public FilledSurvey findFilledSurvey(int idf) {
		return manager.find(FilledSurvey.class, idf);
	}
	public List<FilledSurvey> getFilledSurvey(){
		Query q = manager.createQuery("select f from FilledSurvey f");
		@SuppressWarnings("unchecked")
		List<FilledSurvey> list = q.getResultList();
		return list;
	}
	public void updateFilledSurvey(FilledSurvey filled){
		filled = manager.merge(filled);
	}
	public void create(Teacher teacher) {
		System.out.println("Creating teacher!");
		manager.persist(teacher);
	}
	public void deleteTeacher(int idt) {
		System.out.println("Deleting teacher!");
		Teacher teacher = manager.find(Teacher.class, idt);
		manager.remove(teacher);
	}
	public Teacher findTeacher(int idt) {
		return manager.find(Teacher.class, idt);
	}
	public List<Teacher> getTeacher(){
		Query q = manager.createQuery("select t from Teacher t");
		@SuppressWarnings("unchecked")
		List<Teacher> list = q.getResultList();
		return list;
	}
	public void updateTeacher(Teacher teacher){
		teacher = manager.merge(teacher);
	}
}
