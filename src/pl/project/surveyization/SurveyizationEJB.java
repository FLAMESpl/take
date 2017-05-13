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
		for (Question q : survey.questions){
			manager.persist(q);
			System.out.println(q.text);
		}
		manager.persist(survey);
	}
	public void delete(int ids) {
		System.out.println("Deleting survey!");
		Survey survey = manager.find(Survey.class, ids);
		manager.remove(survey);
	}
	public Survey find(int ids) {
		return manager.find(Survey.class, ids);
	}
	public List<Survey> get(){
		Query q = manager.createQuery("select s from Survey s");
		@SuppressWarnings("unchecked")
		List<Survey> list = q.getResultList();
		return list;
	}
	public void update(Survey survey){
		survey = manager.merge(survey);
	}
}