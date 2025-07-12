package com.ashokit.sql.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.sql.binding.Movie;

public interface MovieRepository extends JpaRepository<Movie, Serializable> {

}
