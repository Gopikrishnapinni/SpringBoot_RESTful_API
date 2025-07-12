package com.ashokit.sql.service;

import java.util.List;

import com.ashokit.sql.binding.Movie;

public interface MovieService {
   
	public String upsert(Movie movie );
	
	public Movie getById(Integer movie_id);
	
	public List<Movie> getAllmovies();
	
	public String deleteById(Integer movie_id);
}
