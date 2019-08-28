package com.stock.stc.model;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Sector {
 @Id
 private int id;
 private String name;
 private String brief;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrief() {
	return brief;
}
public void setBrief(String brief) {
	this.brief = brief;
}
@Override
public String toString() {
	return "Sector [id=" + id + ", name=" + name + ", brief=" + brief + "]";
}
 
}
