package com.ashokit.sql.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.ashokit.sql.binding.Movie;
import com.ashokit.sql.service.MovieService;

@RestController
public class MovieRestController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/movie")
	public ResponseEntity<String> createMovie(@RequestBody Movie movie){
		String status = movieService.upsert(movie);
		return new ResponseEntity<>(status, HttpStatus.CREATED);	
	}
	
	@GetMapping("/movie/{movie_id}")
	public ResponseEntity<Movie> getMovie(@PathVariable Integer movie_id){	
	 Movie movie = movieService.getById(movie_id);
		return new ResponseEntity<> (movie, HttpStatus.OK);
	}
	
	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		List<Movie> allMovies = movieService.getAllmovies();
		return new ResponseEntity<>(allMovies, HttpStatus.OK);
		
	}
	@PutMapping("/movie")
	public ResponseEntity<String> updateMovie(@RequestBody Movie movie){
		String status = movieService.upsert(movie);
		return new ResponseEntity<>(status, HttpStatus.OK);	
	}
	@DeleteMapping("/movie/{movie_id}")
	public ResponseEntity<String> deleteMovie(@PathVariable Integer movie_id){
	 String status = movieService.deleteById(movie_id);
		return new ResponseEntity<> (status, HttpStatus.OK);
	}
	
	
	

}
