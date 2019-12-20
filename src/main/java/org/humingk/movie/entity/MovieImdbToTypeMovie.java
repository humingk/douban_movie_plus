package org.humingk.movie.entity;

import java.io.Serializable;

public class MovieImdbToTypeMovie implements Serializable {
    private Long idMovieImdb;

    private Short idTypeMovie;

    private static final long serialVersionUID = 1L;

    public MovieImdbToTypeMovie(Long idMovieImdb, Short idTypeMovie) {
        this.idMovieImdb = idMovieImdb;
        this.idTypeMovie = idTypeMovie;
    }

    public MovieImdbToTypeMovie() {
        super();
    }

    public Long getIdMovieImdb() {
        return idMovieImdb;
    }

    public void setIdMovieImdb(Long idMovieImdb) {
        this.idMovieImdb = idMovieImdb;
    }

    public Short getIdTypeMovie() {
        return idTypeMovie;
    }

    public void setIdTypeMovie(Short idTypeMovie) {
        this.idTypeMovie = idTypeMovie;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MovieImdbToTypeMovie other = (MovieImdbToTypeMovie) that;
        return (this.getIdMovieImdb() == null ? other.getIdMovieImdb() == null : this.getIdMovieImdb().equals(other.getIdMovieImdb()))
            && (this.getIdTypeMovie() == null ? other.getIdTypeMovie() == null : this.getIdTypeMovie().equals(other.getIdTypeMovie()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieImdb() == null) ? 0 : getIdMovieImdb().hashCode());
        result = prime * result + ((getIdTypeMovie() == null) ? 0 : getIdTypeMovie().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idMovieImdb=").append(idMovieImdb);
        sb.append(", idTypeMovie=").append(idTypeMovie);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}