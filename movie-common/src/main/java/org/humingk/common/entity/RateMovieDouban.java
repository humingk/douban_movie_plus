package org.humingk.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class RateMovieDouban implements Serializable {
    private Long id;

    private BigDecimal score;

    private Integer vote;

    private BigDecimal score5;

    private BigDecimal score4;

    private BigDecimal score3;

    private BigDecimal score2;

    private BigDecimal score1;

    private static final long serialVersionUID = 1L;

    public RateMovieDouban(Long id, BigDecimal score, Integer vote, BigDecimal score5, BigDecimal score4, BigDecimal score3, BigDecimal score2, BigDecimal score1) {
        this.id = id;
        this.score = score;
        this.vote = vote;
        this.score5 = score5;
        this.score4 = score4;
        this.score3 = score3;
        this.score2 = score2;
        this.score1 = score1;
    }

    public RateMovieDouban() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public BigDecimal getScore5() {
        return score5;
    }

    public void setScore5(BigDecimal score5) {
        this.score5 = score5;
    }

    public BigDecimal getScore4() {
        return score4;
    }

    public void setScore4(BigDecimal score4) {
        this.score4 = score4;
    }

    public BigDecimal getScore3() {
        return score3;
    }

    public void setScore3(BigDecimal score3) {
        this.score3 = score3;
    }

    public BigDecimal getScore2() {
        return score2;
    }

    public void setScore2(BigDecimal score2) {
        this.score2 = score2;
    }

    public BigDecimal getScore1() {
        return score1;
    }

    public void setScore1(BigDecimal score1) {
        this.score1 = score1;
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
        RateMovieDouban other = (RateMovieDouban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getVote() == null ? other.getVote() == null : this.getVote().equals(other.getVote()))
            && (this.getScore5() == null ? other.getScore5() == null : this.getScore5().equals(other.getScore5()))
            && (this.getScore4() == null ? other.getScore4() == null : this.getScore4().equals(other.getScore4()))
            && (this.getScore3() == null ? other.getScore3() == null : this.getScore3().equals(other.getScore3()))
            && (this.getScore2() == null ? other.getScore2() == null : this.getScore2().equals(other.getScore2()))
            && (this.getScore1() == null ? other.getScore1() == null : this.getScore1().equals(other.getScore1()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getVote() == null) ? 0 : getVote().hashCode());
        result = prime * result + ((getScore5() == null) ? 0 : getScore5().hashCode());
        result = prime * result + ((getScore4() == null) ? 0 : getScore4().hashCode());
        result = prime * result + ((getScore3() == null) ? 0 : getScore3().hashCode());
        result = prime * result + ((getScore2() == null) ? 0 : getScore2().hashCode());
        result = prime * result + ((getScore1() == null) ? 0 : getScore1().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", score=").append(score);
        sb.append(", vote=").append(vote);
        sb.append(", score5=").append(score5);
        sb.append(", score4=").append(score4);
        sb.append(", score3=").append(score3);
        sb.append(", score2=").append(score2);
        sb.append(", score1=").append(score1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}