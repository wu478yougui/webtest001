package wu.you.gui.domain;

public class Film {
private int film_id;
private String title;
private String description;
private int language;

public Film() {
	
}
public Film(int film_id, String title, String description, int language) {
	super();
	this.film_id = film_id;
	this.title = title;
	this.description = description;
	this.language = language;
}
public int getFilm_id() {
	return film_id;
}
public void setFilm_id(int film_id) {
	this.film_id = film_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getLanguage() {
	return language;
}
public void setLanguage(int language) {
	this.language = language;
}
}
