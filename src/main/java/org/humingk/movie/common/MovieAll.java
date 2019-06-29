package org.humingk.movie.common;

import org.humingk.movie.entity.*;

import java.util.List;

/**
 * 电影详细信息
 *
 * @author humingk
 */
public class MovieAll {
    private Integer movieId;

    private String name;

    private Float rate;

    private String imdbId;

    private String alias;

    private List<Actor> directors;

    private List<Actor> writers;

    private List<Actor> leadingactors;

    private List<Type> types;

    private List<Tag> tags;

    private List<Releasetime> releasetimes;

    public MovieAll(){}

    public MovieAll(Movie movie){
       this.movieId=movie.getMovieId();
       this.name=movie.getName();
       this.rate=movie.getRate();
       this.imdbId=movie.getImdbId();
       this.alias=movie.getAlias();
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Actor> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Actor> directors) {
        this.directors = directors;
    }

    public List<Actor> getWriters() {
        return writers;
    }

    public void setWriters(List<Actor> writers) {
        this.writers = writers;
    }

    public List<Actor> getLeadingactors() {
        return leadingactors;
    }

    public void setLeadingactors(List<Actor> leadingactors) {
        this.leadingactors = leadingactors;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Releasetime> getReleasetimes() {
        return releasetimes;
    }

    public void setReleasetimes(List<Releasetime> releasetimes) {
        this.releasetimes = releasetimes;
    }
}
