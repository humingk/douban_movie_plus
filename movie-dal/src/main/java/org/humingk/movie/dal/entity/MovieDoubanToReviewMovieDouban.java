package org.humingk.movie.dal.entity;

import java.io.Serializable;

public class MovieDoubanToReviewMovieDouban implements Serializable {
    private Long idMovieDouban;

    private Long idReviewMovieDouban;

    private static final long serialVersionUID = 1L;

    public MovieDoubanToReviewMovieDouban(Long idMovieDouban, Long idReviewMovieDouban) {
        this.idMovieDouban = idMovieDouban;
        this.idReviewMovieDouban = idReviewMovieDouban;
    }

    public MovieDoubanToReviewMovieDouban() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public Long getIdReviewMovieDouban() {
        return idReviewMovieDouban;
    }

    public void setIdReviewMovieDouban(Long idReviewMovieDouban) {
        this.idReviewMovieDouban = idReviewMovieDouban;
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
        MovieDoubanToReviewMovieDouban other = (MovieDoubanToReviewMovieDouban) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getIdReviewMovieDouban() == null ? other.getIdReviewMovieDouban() == null : this.getIdReviewMovieDouban().equals(other.getIdReviewMovieDouban()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getIdReviewMovieDouban() == null) ? 0 : getIdReviewMovieDouban().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idMovieDouban=").append(idMovieDouban);
        sb.append(", idReviewMovieDouban=").append(idReviewMovieDouban);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}