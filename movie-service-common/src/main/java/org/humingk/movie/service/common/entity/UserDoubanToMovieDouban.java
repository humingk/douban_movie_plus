package org.humingk.movie.service.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserDoubanToMovieDouban implements Serializable {
    private String idUserDouban;

    private Long idMovieDouban;

    private BigDecimal score;

    private Boolean isWish;

    private Boolean isSeen;

    private static final long serialVersionUID = 1L;

    public UserDoubanToMovieDouban(String idUserDouban, Long idMovieDouban, BigDecimal score, Boolean isWish, Boolean isSeen) {
        this.idUserDouban = idUserDouban;
        this.idMovieDouban = idMovieDouban;
        this.score = score;
        this.isWish = isWish;
        this.isSeen = isSeen;
    }

    public UserDoubanToMovieDouban() {
        super();
    }

    public String getIdUserDouban() {
        return idUserDouban;
    }

    public void setIdUserDouban(String idUserDouban) {
        this.idUserDouban = idUserDouban == null ? null : idUserDouban.trim();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Boolean getIsWish() {
        return isWish;
    }

    public void setIsWish(Boolean isWish) {
        this.isWish = isWish;
    }

    public Boolean getIsSeen() {
        return isSeen;
    }

    public void setIsSeen(Boolean isSeen) {
        this.isSeen = isSeen;
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
        UserDoubanToMovieDouban other = (UserDoubanToMovieDouban) that;
        return (this.getIdUserDouban() == null ? other.getIdUserDouban() == null : this.getIdUserDouban().equals(other.getIdUserDouban()))
            && (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getIsWish() == null ? other.getIsWish() == null : this.getIsWish().equals(other.getIsWish()))
            && (this.getIsSeen() == null ? other.getIsSeen() == null : this.getIsSeen().equals(other.getIsSeen()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdUserDouban() == null) ? 0 : getIdUserDouban().hashCode());
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getIsWish() == null) ? 0 : getIsWish().hashCode());
        result = prime * result + ((getIsSeen() == null) ? 0 : getIsSeen().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idUserDouban=").append(idUserDouban);
        sb.append(", idMovieDouban=").append(idMovieDouban);
        sb.append(", score=").append(score);
        sb.append(", isWish=").append(isWish);
        sb.append(", isSeen=").append(isSeen);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}