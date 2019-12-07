package org.humingk.movie.entity;

public class UserDoubanToReviewMovieDouban {
    private String idUserDouban;

    private Long idReviewMovieDouban;

    public UserDoubanToReviewMovieDouban(String idUserDouban, Long idReviewMovieDouban) {
        this.idUserDouban = idUserDouban;
        this.idReviewMovieDouban = idReviewMovieDouban;
    }

    public UserDoubanToReviewMovieDouban() {
        super();
    }

    public String getIdUserDouban() {
        return idUserDouban;
    }

    public void setIdUserDouban(String idUserDouban) {
        this.idUserDouban = idUserDouban == null ? null : idUserDouban.trim();
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
        UserDoubanToReviewMovieDouban other = (UserDoubanToReviewMovieDouban) that;
        return (this.getIdUserDouban() == null ? other.getIdUserDouban() == null : this.getIdUserDouban().equals(other.getIdUserDouban()))
            && (this.getIdReviewMovieDouban() == null ? other.getIdReviewMovieDouban() == null : this.getIdReviewMovieDouban().equals(other.getIdReviewMovieDouban()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdUserDouban() == null) ? 0 : getIdUserDouban().hashCode());
        result = prime * result + ((getIdReviewMovieDouban() == null) ? 0 : getIdReviewMovieDouban().hashCode());
        return result;
    }
}