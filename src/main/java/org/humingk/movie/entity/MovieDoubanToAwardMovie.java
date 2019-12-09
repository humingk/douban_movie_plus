package org.humingk.movie.entity;

public class MovieDoubanToAwardMovie {
    private Long idMovieDouban;

    private String idAwardMovie;

    private Long idCelebrityDouban;

    private String typeAward;

    private Short awardTh;

    private Boolean isNominated;

    public MovieDoubanToAwardMovie(Long idMovieDouban, String idAwardMovie, Long idCelebrityDouban, String typeAward, Short awardTh, Boolean isNominated) {
        this.idMovieDouban = idMovieDouban;
        this.idAwardMovie = idAwardMovie;
        this.idCelebrityDouban = idCelebrityDouban;
        this.typeAward = typeAward;
        this.awardTh = awardTh;
        this.isNominated = isNominated;
    }

    public MovieDoubanToAwardMovie() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public String getIdAwardMovie() {
        return idAwardMovie;
    }

    public void setIdAwardMovie(String idAwardMovie) {
        this.idAwardMovie = idAwardMovie == null ? null : idAwardMovie.trim();
    }

    public Long getIdCelebrityDouban() {
        return idCelebrityDouban;
    }

    public void setIdCelebrityDouban(Long idCelebrityDouban) {
        this.idCelebrityDouban = idCelebrityDouban;
    }

    public String getTypeAward() {
        return typeAward;
    }

    public void setTypeAward(String typeAward) {
        this.typeAward = typeAward == null ? null : typeAward.trim();
    }

    public Short getAwardTh() {
        return awardTh;
    }

    public void setAwardTh(Short awardTh) {
        this.awardTh = awardTh;
    }

    public Boolean getIsNominated() {
        return isNominated;
    }

    public void setIsNominated(Boolean isNominated) {
        this.isNominated = isNominated;
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
        MovieDoubanToAwardMovie other = (MovieDoubanToAwardMovie) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getIdAwardMovie() == null ? other.getIdAwardMovie() == null : this.getIdAwardMovie().equals(other.getIdAwardMovie()))
            && (this.getIdCelebrityDouban() == null ? other.getIdCelebrityDouban() == null : this.getIdCelebrityDouban().equals(other.getIdCelebrityDouban()))
            && (this.getTypeAward() == null ? other.getTypeAward() == null : this.getTypeAward().equals(other.getTypeAward()))
            && (this.getAwardTh() == null ? other.getAwardTh() == null : this.getAwardTh().equals(other.getAwardTh()))
            && (this.getIsNominated() == null ? other.getIsNominated() == null : this.getIsNominated().equals(other.getIsNominated()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getIdAwardMovie() == null) ? 0 : getIdAwardMovie().hashCode());
        result = prime * result + ((getIdCelebrityDouban() == null) ? 0 : getIdCelebrityDouban().hashCode());
        result = prime * result + ((getTypeAward() == null) ? 0 : getTypeAward().hashCode());
        result = prime * result + ((getAwardTh() == null) ? 0 : getAwardTh().hashCode());
        result = prime * result + ((getIsNominated() == null) ? 0 : getIsNominated().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idMovieDouban=").append(idMovieDouban);
        sb.append(", idAwardMovie=").append(idAwardMovie);
        sb.append(", idCelebrityDouban=").append(idCelebrityDouban);
        sb.append(", typeAward=").append(typeAward);
        sb.append(", awardTh=").append(awardTh);
        sb.append(", isNominated=").append(isNominated);
        sb.append("]");
        return sb.toString();
    }
}