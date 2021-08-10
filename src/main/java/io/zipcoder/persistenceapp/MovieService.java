package io.zipcoder.persistenceapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepo repo;

    public Movies create(Movies movie) {
        return repo.save(movie);
    }

    public Movies read(Integer id) {
        return repo.findOne(id);
    }

    public List<Movies> readAll() {
        Iterable<Movies> moviesIterable = repo.findAll();
        List<Movies> result = new ArrayList<>();
        moviesIterable.forEach(result::add);
        return result;
    }

    public Movies update(Integer id, Movies movieToUpdate) {
        Movies movieInDb = read(id);
        movieInDb.setGenre(movieToUpdate.getGenre());
        movieInDb.setImdbScore(movieToUpdate.getImdbScore());
        movieInDb.setRating(movieToUpdate.getRating());
        movieInDb.setRuntime(movieToUpdate.getRuntime());
        movieInDb.setTitle(movieToUpdate.getTitle());
        movieInDb = repo.save(movieInDb);
        return movieInDb;
    }

    public Movies delete(Integer id) {
        Movies movie = read(id);
        repo.delete(movie);
        return movie;
    }

    public Movies delete(Movies movie) {
        return delete(movie.getId());
    }
}
