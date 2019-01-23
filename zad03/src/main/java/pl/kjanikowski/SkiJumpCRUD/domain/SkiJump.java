package pl.kjanikowski.SkiJumpCRUD.domain;

import java.sql.Date;

public class SkiJump {
	
	private long id;
	private String name;
	private int size;
	private Date doc;
	private boolean hasRecord;
	
	public SkiJump() {
		
	}
	
	public SkiJump(String name, int size, Date doc, boolean hasRecord) {
		super();
		this.name = name;
		this.size = size;
		this.doc = doc;
		this.hasRecord = hasRecord;
	}
	
	public String toString() {
		return name + ", wielkosc " + size + " dzien zawodow " + doc.toString() + " ma rekord? "+ hasRecord;
	}
	
	
	
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

}
