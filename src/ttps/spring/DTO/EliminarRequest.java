package ttps.spring.DTO;

public class EliminarRequest {
	private int id;

	public EliminarRequest() {}
	
	public EliminarRequest(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
