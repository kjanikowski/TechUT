package pl.kjanikowski.hibernate.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SkiJump {
	
	private long id;
	private String name;
	private int size;
	private Date doc;
	private boolean hasRecord;
	
	
	private City city;
	
	private List<Competition> competition;
	
	private SkiType skiType;
	
	
	public SkiJump() {
		
	}
	
	public SkiJump(String name, int size, Date doc, boolean hasRecord, String city, String competition) {
		super();
		this.name = name;
		this.size = size;
		this.doc = doc;
		this.hasRecord = hasRecord;
		setCity(new City(city));
		
	}
	
	public String toString() {
		return name;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Date getDoc() {
		return doc;
	}
	public void setDoc(Date doc) {
		this.doc = doc;
	}
	public boolean isHasRecord() {
		return hasRecord;
	}
	public void setHasRecord(boolean hasRecord) {
		this.hasRecord = hasRecord;
	}

	@ManyToOne
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne
	public List<Competition> getCompetition() {
		return competition;
	}

	public void setCompetition(List<Competition> competition) {
		this.competition = competition;
	}

	@OneToOne
	public SkiType getSkiType() {
		return skiType;
	}

	public void setSkiType(SkiType skiType) {
		this.skiType = skiType;
	}

}
