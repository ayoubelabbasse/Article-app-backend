package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

	@Id
	@GeneratedValue
 private Long id; 
 private String name;
 private String text;
 private String image;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getimage() {
	return image;
}
public void setPath(String image) {
	this.image = image;
}
public Article(String name, String text, String image) {
	super();
	this.name = name;
	this.text = text;
	this.image = image;
}
public Article() {
	
}
@Override
public String toString() {
	return "Article [id=" + id + ", name=" + name + ", text=" + text + ", image=" + image + "]";
}
 
	
}
