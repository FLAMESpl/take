package pl.project.surveyization;
import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListResponse<T> {

	private List<T> list = new ArrayList<T>();
	
	public ListResponse(List<T> list){
		this.list = list;
	}
	
	public ListResponse() { }
	
	public List<T> getList(){
		return list;
	}
	public void setList(List<T> list){
		this.list = list;
	}
}
