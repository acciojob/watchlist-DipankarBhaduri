package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService ;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie (@RequestBody Movie movie ){
        movieService.addMovie(movie) ;
        return new ResponseEntity<>( "New Movie added" , HttpStatus.CREATED ) ;
    }

    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New Director added", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movie, @RequestParam String director){
        movieService.createMovieDirectorPair(movie, director);
        return new ResponseEntity<>("New movie-director pair added", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName ( @PathVariable String name){
        Movie movie = movieService.getMovieByName(name) ;
        return new ResponseEntity<>( movie , HttpStatus.CREATED) ;
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName ( @PathVariable String name){
       Director director = movieService.getDirectorByName(name) ;
        return new ResponseEntity<>( director , HttpStatus.CREATED) ;
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName ( @PathVariable String director ){
        List<String> movies  = movieService.getMoviesByDirectorName( director) ;
        return new ResponseEntity( movies , HttpStatus.CREATED) ;
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies (){
        List<String> movies = movieService.findAllMovies () ;
        return new ResponseEntity( movies , HttpStatus.CREATED) ;
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName ( @RequestParam String director ){
        movieService.deleteDirectorByName( director ) ;
        return new ResponseEntity( "removed successfully" , HttpStatus.CREATED) ;
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors (){
        movieService.deleteAllDirectors() ;
        return new ResponseEntity( "All directors deleted successfully" , HttpStatus.CREATED);
    }
}
