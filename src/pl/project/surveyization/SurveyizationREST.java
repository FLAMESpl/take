package pl.project.surveyization;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/surveyization")
@Consumes({ "application/xml" })
@Produces({ "application/xml" })
public class SurveyizationREST implements Surveyization {

	@EJB
	SurveyizationEJB bean;
	
	@Override
	@POST
	public String create(Survey survey) {
		bean.create(survey);
		return "survey created!";
	}

	@Override
	@GET
	@Path("/{ids}")
	public Survey find(@PathParam("ids") int ids) {
		Survey survey = bean.find(ids);
		return survey;
	}

	@Override
	@GET
	public Surveys get() {
		List<Survey> list = bean.get();
		Surveys surveys = new Surveys(list);
		return surveys;
	}

	@Override
	@PUT
	public String update(Survey survey) {
		try {
			bean.update(survey);
			return "survey updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "survye not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("/{ids}")
	public String delete(@PathParam ("ids") int ids) {
		bean.delete(ids);	
		return "survey deleted";
	}

}
