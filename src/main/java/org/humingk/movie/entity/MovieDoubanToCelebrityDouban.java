package org.humingk.movie.entity;

public class MovieDoubanToCelebrityDouban {
    private Long idMovieDouban;

    private Long idCelebrityDouban;

    private Byte idProfession;

    private Short sort;

    public MovieDoubanToCelebrityDouban(Long idMovieDouban, Long idCelebrityDouban, Byte idProfession, Short sort) {
        this.idMovieDouban = idMovieDouban;
        this.idCelebrityDouban = idCelebrityDouban;
        this.idProfession = idProfession;
        this.sort = sort;
    }

    public MovieDoubanToCelebrityDouban() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public Long getIdCelebrityDouban() {
        return idCelebrityDouban;
    }

    public void setIdCelebrityDouban(Long idCelebrityDouban) {
        this.idCelebrityDouban = idCelebrityDouban;
    }

    public Byte getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Byte idProfession) {
        this.idProfession = idProfession;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
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
        MovieDoubanToCelebrityDouban other = (MovieDoubanToCelebrityDouban) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getIdCelebrityDouban() == null ? other.getIdCelebrityDouban() == null : this.getIdCelebrityDouban().equals(other.getIdCelebrityDouban()))
            && (this.getIdProfession() == null ? other.getIdProfession() == null : this.getIdProfession().equals(other.getIdProfession()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getIdCelebrityDouban() == null) ? 0 : getIdCelebrityDouban().hashCode());
        result = prime * result + ((getIdProfession() == null) ? 0 : getIdProfession().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }
}