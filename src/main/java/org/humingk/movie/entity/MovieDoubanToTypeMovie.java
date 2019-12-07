package org.humingk.movie.entity;

public class MovieDoubanToTypeMovie {
    private Long idMovieDouban;

    private Short idTypeMovie;

    public MovieDoubanToTypeMovie(Long idMovieDouban, Short idTypeMovie) {
        this.idMovieDouban = idMovieDouban;
        this.idTypeMovie = idTypeMovie;
    }

    public MovieDoubanToTypeMovie() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
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
        MovieDoubanToTypeMovie other = (MovieDoubanToTypeMovie) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getIdTypeMovie() == null ? other.getIdTypeMovie() == null : this.getIdTypeMovie().equals(other.getIdTypeMovie()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getIdTypeMovie() == null) ? 0 : getIdTypeMovie().hashCode());
        return result;
    }
}