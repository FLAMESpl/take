package pl.project.surveyization;

import java.util.Iterator;
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
				q.setSurvey(survey);
			}
		}
		manager.persist(survey);
	}
	public String deleteSurvey(int ids) {
		System.out.println("Deleting survey!");
		Query q = manager.createQuery("select s from Survey s where s.ids = :ids");
		q.setParameter("ids", ids);
		Survey survey = (Survey)q.getSingleResult();
		survey.setDeleted(true);
		manager.merge(survey);
		return survey.getDescription();
	}
	public Survey findSurvey(int ids) {
		Query q = manager.createQuery("select s from Survey s where s.ids = :ids and s.deleted = false");
		q.setParameter("ids", ids);
		Survey survey = (Survey)q.getSingleResult();
		Iterator<FilledSurvey> it = survey.getFilledSurveys().iterator();
		while (it.hasNext()){
			FilledSurvey filled = it.next();
			if (filled.isDeleted() == true){
				it.remove();
			}
		}
		return survey;
	}
	public List<Survey> getSurveys(){
		Query q = manager.createQuery("select s from Survey s where s.deleted = false");
		@SuppressWarnings("unchecked")
		List<Survey> list = q.getResultList();
		for (Survey survey : list){
			Iterator<FilledSurvey> it = survey.getFilledSurveys().iterator();
			while (it.hasNext()){
				FilledSurvey filled = it.next();
				if (filled.isDeleted() == true){
					it.remove();
				}
			}
		}
		return list;		
	}
	public void updateSurvey(Survey survey){
		Query q = manager.createQuery("select s from Survey s where s.ids = :ids");
		q.setParameter("ids", survey.getIds());
		Survey old  = (Survey)q.getSingleResult();
		for (FilledSurvey filled : old.getFilledSurveys()){
			filled.setParent(survey);
			survey.filledSurveys.add(filled);
		}
		for (Question question : old.getQuestions()){
			q = manager.createQuery("delete from Question where dsurvey_ids = :ids");
			q.setParameter("ids", survey.getIds());
			int deletedcount = q.executeUpdate();
			question.setSurvey(survey);
			survey.questions.add(question);
		}
//		old.questions.clear();
//		old.filledSurveys.clear();
		manager.merge(survey);
	}
	public void create(FilledCreator filled) {
		System.out.println("Creating filled!");
		Query q = manager.createQuery("select s from Survey s where s.ids = :ids");
		q.setParameter("ids", filled.ids);
		Survey survey = (Survey)q.getSingleResult();
		q = manager.createQuery("select t from Teacher t where t.idt = :idt");
		q.setParameter("idt", filled.idt);
		Teacher teacher = (Teacher)q.getSingleResult();
		filled.getFilled().setParent(survey);
		filled.getFilled().setEvaluated(teacher);
		if(filled.getFilled().getAnswers() != null){
			for (Answer a : filled.getFilled().getAnswers()){
				q = manager.createQuery("select q from Question q where q.idq = :idq");
				q.setParameter("idq", a.getIdq());
				Question quest = (Question)q.getSingleResult();
				a.setQuestion(quest);
			}
		}
		manager.persist(filled.getFilled());
	}
	public String deleteFilledSurvey(int idf) {
		System.out.println("Deleting filled!");
		Query q = manager.createQuery("select f from FilledSurvey f where f.idf = :idf");
		q.setParameter("idf", idf);
		FilledSurvey filled = (FilledSurvey)q.getSingleResult();
		filled.setDeleted(true);
		manager.persist(filled);
		return filled.getDescription();
	}
	public FilledSurvey findFilledSurvey(int idf) {
		Query q = manager.createQuery("select f from FilledSurvey f where f.idf = :idf and f.deleted = false");
		q.setParameter("idf", idf);
		FilledSurvey filled = (FilledSurvey)q.getSingleResult();
		if(filled.getAnswers() != null){
			for (Answer a : filled.getAnswers()){
				a.setIdq(a.getQuestion().getIdq());
			}
		}
		return filled;
	}
	public List<FilledSurvey> getFilledSurvey(){
		Query q = manager.createQuery("select f from FilledSurvey f where f.deleted = false");
		@SuppressWarnings("unchecked")
		List<FilledSurvey> list = q.getResultList();
		if(list.size() != 0){
			for (FilledSurvey filled : list){
				if(filled.getAnswers() != null){
					for (Answer a : filled.getAnswers()){
						a.setIdq(a.getQuestion().getIdq());
					}
				}
			}
		}
		return list;
	}
	public void updateFilledSurvey(int idf, FilledSurvey filled){
		filled.setIdf(idf);
		Query q = manager.createQuery("select f from FilledSurvey f where f.idf = :idf");
		q.setParameter("idf", idf);
		FilledSurvey old  = (FilledSurvey)q.getSingleResult();
		q = manager.createQuery("delete from Answer where filledsurvey_idf = :idf");
		q.setParameter("idf", idf);
		int deletedcount = q.executeUpdate();
		filled.setEvaluated(old.getEvaluated());
		filled.setParent(old.getParent());
		if(filled.getAnswers() != null){
			for (Answer a : filled.getAnswers()){
				q = manager.createQuery("select q from Question q where q.idq = :idq");
				q.setParameter("idq", a.getIdq());
				Question quest = (Question)q.getSingleResult();
				a.setQuestion(quest);
			}
		}
		filled = manager.merge(filled);
	}
	public void create(Teacher teacher) {
		System.out.println("Creating teacher!");
		manager.persist(teacher);
	}
	public String deleteTeacher(int idt) {
		System.out.println("Deleting teacher!");
		Query q = manager.createQuery("select t from Teacher t where t.idt = :idt");
		q.setParameter("idt", idt);
		Teacher teacher = (Teacher)q.getSingleResult();
		teacher.setDeleted(true);
		for (FilledSurvey filled : teacher.getFilledSurveys())
			filled.setDeleted(true);
		manager.merge(teacher);
		return (teacher.getFirstName() + " " + teacher.getLastName());
	}
	public Teacher findTeacher(int idt) {
		Query q = manager.createQuery("select t from Teacher t where t.idt = :idt and t.deleted = false");
		q.setParameter("idt", idt);
		Teacher teacher = (Teacher)q.getSingleResult();
		for (FilledSurvey filled : teacher.getFilledSurveys()){
			if (filled.isDeleted() == true)
				teacher.getFilledSurveys().remove(filled);
		}
		return teacher;
	}
	public List<Teacher> getTeacher(){
		Query q = manager.createQuery("select t from Teacher t where t.deleted = false");
		@SuppressWarnings("unchecked")
		List<Teacher> list = q.getResultList();
		for (Teacher teacher : list){
			Iterator<FilledSurvey> it = teacher.getFilledSurveys().iterator();
			while (it.hasNext()){
				FilledSurvey filled = it.next();
				if (filled.isDeleted() == true){
					it.remove();
				}
			}
		}
		return list;
	}
	public void updateTeacher(Teacher teacher){
		Query q = manager.createQuery("select t from Teacher t where t.idt = :idt");
		q.setParameter("idt", teacher.getIdt());
		Teacher old  = (Teacher)q.getSingleResult();
		Iterator<FilledSurvey> it = teacher.getFilledSurveys().iterator();
		while (it.hasNext()){
			FilledSurvey filled = it.next();
			if (filled.isDeleted() == true){
				it.remove();
			}
		}
		teacher = manager.merge(teacher);
	}
}
