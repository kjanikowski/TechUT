package pl.kjanikowski.hibernate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SkiType {
	
	private long id;
	private String Type;
	
	public SkiType(String type) {
		super();
		Type = type;
	}

	public SkiType() {
		super();
		// TODO Auto-generated constructor stub
	}


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}


}
