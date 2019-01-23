package pl.kjanikowski.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Competition {
	
	private long id;
	private String CompetitionName;
	public Competition(String competitionName) {
		super();
		CompetitionName = competitionName;
	}
	public Competition() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(unique = true)
	public String getCompetitionName() {
		return CompetitionName;
	}
	public void setCompetitionName(String competitionName) {
		CompetitionName = competitionName;
	}
}
