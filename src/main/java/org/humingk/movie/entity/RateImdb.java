package org.humingk.movie.entity;

import java.math.BigDecimal;

public class RateImdb {
    private Long id;

    private BigDecimal imdbScore;

    private Integer imdbVote;

    private BigDecimal tomatoScore;

    private BigDecimal mtcScore;

    public RateImdb(Long id, BigDecimal imdbScore, Integer imdbVote, BigDecimal tomatoScore, BigDecimal mtcScore) {
        this.id = id;
        this.imdbScore = imdbScore;
        this.imdbVote = imdbVote;
        this.tomatoScore = tomatoScore;
        this.mtcScore = mtcScore;
    }

    public RateImdb() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(BigDecimal imdbScore) {
        this.imdbScore = imdbScore;
    }

    public Integer getImdbVote() {
        return imdbVote;
    }

    public void setImdbVote(Integer imdbVote) {
        this.imdbVote = imdbVote;
    }

    public BigDecimal getTomatoScore() {
        return tomatoScore;
    }

    public void setTomatoScore(BigDecimal tomatoScore) {
        this.tomatoScore = tomatoScore;
    }

    public BigDecimal getMtcScore() {
        return mtcScore;
    }

    public void setMtcScore(BigDecimal mtcScore) {
        this.mtcScore = mtcScore;
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
        RateImdb other = (RateImdb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getImdbScore() == null ? other.getImdbScore() == null : this.getImdbScore().equals(other.getImdbScore()))
            && (this.getImdbVote() == null ? other.getImdbVote() == null : this.getImdbVote().equals(other.getImdbVote()))
            && (this.getTomatoScore() == null ? other.getTomatoScore() == null : this.getTomatoScore().equals(other.getTomatoScore()))
            && (this.getMtcScore() == null ? other.getMtcScore() == null : this.getMtcScore().equals(other.getMtcScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getImdbScore() == null) ? 0 : getImdbScore().hashCode());
        result = prime * result + ((getImdbVote() == null) ? 0 : getImdbVote().hashCode());
        result = prime * result + ((getTomatoScore() == null) ? 0 : getTomatoScore().hashCode());
        result = prime * result + ((getMtcScore() == null) ? 0 : getMtcScore().hashCode());
        return result;
    }
}