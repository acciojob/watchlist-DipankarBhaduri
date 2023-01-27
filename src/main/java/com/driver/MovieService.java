package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository ;

    public void addMovie ( Movie movie ){
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepository.addDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director){
        movieRepository.createMovieDirectorPair(movie, director);
    }

    public Movie getMovieByName(String movieName){
        return movieRepository.findMovie(movieName);
    }

    public Director getDirectorByName(String directorName){
        return movieRepository.findDirector(directorName);
    }

    public List<String> getMoviesByDirectorName(String director){
        return movieRepository.findMoviesFromDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirectorByName(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }

}
