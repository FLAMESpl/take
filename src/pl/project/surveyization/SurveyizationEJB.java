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
		if(survey.getQuestions() != null){
			for (Question q : survey.getQuestions()){
				q.survey = survey;
			}
		}
		manager.persist(survey);
	}
	public void deleteSurvey(int ids) {
		System.out.println("Deleting survey!");
		Query q = manager.createQuery("select s from Survey s where s.ids like :ids");
		q.setParameter("ids", ids);
		Survey survey = (Survey)q.getSingleResult();
		manager.remove(survey);
	}
	public Survey findSurvey(int ids) {
		Query q = manager.createQuery("select s from Survey s where s.ids like :ids");
		q.setParameter("ids", ids);
		Survey survey = (Survey)q.getSingleResult();
		return survey;
	}
	public List<Survey> getSurveys(){
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
		Query q = manager.createQuery("select s from Survey s where s.ids like :ids");
		q.setParameter("ids", filled.ids);
		Survey survey = (Survey)q.getSingleResult();
		q = manager.createQuery("select t from Teacher t where t.idt like :idt");
		q.setParameter("idt", filled.idt);
		Teacher teacher = (Teacher)q.getSingleResult();
		filled.setParent(survey);
		filled.setEvaluated(teacher);
		if(filled.getAnswers() != null){
			for (Answer a : filled.getAnswers()){
				q = manager.createQuery("select q from Question q where q.idq like :idq");
				q.setParameter("idq", a.idq);
				Question quest = (Question)q.getSingleResult();
				a.setQuestion(quest);
			}
		}
		manager.persist(filled);
	}
	public void deleteFilledSurvey(int idf) {
		System.out.println("Deleting filled!");
		Query q = manager.createQuery("select f from FilledSurvey f where f.idf = :idf");
		q.setParameter("idf", idf);
		FilledSurvey filled = (FilledSurvey)q.getSingleResult();
		manager.remove(filled);
	}
	public FilledSurvey findFilledSurvey(int idf) {
		Query q = manager.createQuery("select f from FilledSurvey f where f.idf = :idf");
		q.setParameter("idf", idf);
		FilledSurvey filled = (FilledSurvey)q.getSingleResult();
		return filled;
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
		Query q = manager.createQuery("select t from Teacher t where t.idt = :idt");
		q.setParameter("idt", idt);
		Teacher teacher = (Teacher)q.getSingleResult();
		manager.remove(teacher);
	}
	public Teacher findTeacher(int idt) {
		Query q = manager.createQuery("select t from Teacher t where t.idt = :idt");
		q.setParameter("idt", idt);
		Teacher teacher = (Teacher)q.getSingleResult();
		return teacher;
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
