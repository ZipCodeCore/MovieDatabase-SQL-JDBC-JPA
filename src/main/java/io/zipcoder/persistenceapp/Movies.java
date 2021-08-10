package io.zipcoder.persistenceapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private int runtime;
    private String genre;
    private int imdbScore;
    private String rating;

    public Movies() {
    }

    public Movies(Integer id, String title, int runtime, String genre, int imdbScore, String rating) {
        this.id = id;
        this.title = title;
        this.runtime = runtime;
        this.genre = genre;
        this.imdbScore = imdbScore;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(int imdbScore) {
        this.imdbScore = imdbScore;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
