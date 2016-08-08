package wu.you.gui.service;

import java.util.ArrayList;

import wu.you.gui.domain.Film;
import wu.you.gui.uilts.SqlHelper;

public class FilmService {
	
	//查询全部film
	public ArrayList getAllFilm(){
		
		String sql="SELECT f.`film_id`,f.`title`,f.`description`,l.`language_id` LANGUAGE FROM film f,"
				+ "LANGUAGE l WHERE  f.`language_id`=l.`language_id` and 1=?;";
		String parameters[]={"1"};
		ArrayList al=SqlHelper.executeQuery3(sql, parameters);
		ArrayList<Film> newAl=new ArrayList<Film>();
		for(int i=0;i<al.size();i++){
		Object object[]=(Object[])al.get(i);
		Film film=new Film();
		film.setFilm_id(Integer.parseInt(object[0].toString()));
		film.setTitle(object[1].toString());
		film.setDescription(object[2].toString());
		film.setLanguage(Integer.parseInt(object[3].toString()));
		newAl.add(film);
		}
		return newAl;
	}
	
	//查询一部film
public ArrayList getOneFilm(String s){
		
		String sql="SELECT f.`film_id`,f.`title`,f.`description`,l.`language_id` LANGUAGE FROM film f,"
				+ "LANGUAGE l WHERE  f.`language_id`=l.`language_id` and f.film_id=?;";
		String parameters[]={s};
		ArrayList al=SqlHelper.executeQuery3(sql, parameters);
		ArrayList<Film> newAl=new ArrayList<Film>();
		for(int i=0;i<al.size();i++){
		Object object[]=(Object[])al.get(i);
		Film film=new Film();
		film.setFilm_id(Integer.parseInt(object[0].toString()));
		film.setTitle(object[1].toString());
		film.setDescription(object[2].toString());
		film.setLanguage(Integer.parseInt(object[3].toString()));
		newAl.add(film);
		}
		return newAl;
	}


	//删除
	public boolean delfilm(String id){
		boolean b=true;
		String sql="delete from film where film_id=?";
		String parameters[]={id};
		try {
			SqlHelper.executeUpdate(sql, parameters);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	
	}
	
	
	//更新
	public boolean updatefilm(Film film){
		boolean b=true;
		String sql="update film f set f.title=?,f.description=?,f.language_id=? where film_id=?";
		String parameters[]={film.getTitle(),film.getDescription(),film.getLanguage()+"",film.getFilm_id()+""};
		try {
			SqlHelper.executeUpdate(sql, parameters);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	
	}
	
	//新增
	public boolean addfilm(Film film){
		boolean b=true;
		String sql="INSERT INTO film(title,description,language_id)  VALUES(?,?,?)";
		String parameters[]={film.getTitle(),film.getDescription(),film.getLanguage()+""};
		try {
			SqlHelper.executeUpdate(sql, parameters);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	
	}
}
