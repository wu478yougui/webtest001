package wu.you.gui.service;

import java.util.ArrayList;

import wu.you.gui.domain.Film;
import wu.you.gui.uilts.SqlHelper;

public class FilmService {
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
		System.out.println(newAl);
		return newAl;
	}
	
	public boolean delfilm(String id){
		boolean b=true;
		String sql="delete from film where film_id=? CASCADE ";
		String parameters[]={id};
		try {
			SqlHelper.executeUpdate(sql, parameters);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return b;
	
	}
}
