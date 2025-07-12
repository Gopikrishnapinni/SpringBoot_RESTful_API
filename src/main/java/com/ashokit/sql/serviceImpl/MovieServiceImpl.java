package com.ashokit.sql.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.sql.binding.Movie;
import com.ashokit.sql.repo.MovieRepository;
import com.ashokit.sql.service.MovieService;


@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepo;

	@Override
	public String upsert(Movie movie) {
		
		movieRepo.save(movie);
		
		return "success";
	}

	@Override
	public Movie getById(Integer movie_id) {
		
		Optional<Movie> findById = movieRepo.findById(movie_id);
		
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

	@Override
	public List<Movie> getAllmovies() {
	
		return movieRepo.findAll();
		
	}

	@Override
	public String deleteById(Integer movie_id) {
	  
		if(movieRepo.existsById(movie_id)) {
			movieRepo.deleteById(movie_id);
			return "Delete Success";
		}else {
			return "No Record Found";
		}
		
		
	}

}
