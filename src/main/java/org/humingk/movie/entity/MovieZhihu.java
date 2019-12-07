package org.humingk.movie.entity;

import java.math.BigDecimal;

public class MovieZhihu {
    private Long id;

    private Long idMovieDouban;

    private String nameZh;

    private BigDecimal zhihuScore;

    private Integer zhihuVote;

    private BigDecimal maoyanScore;

    public MovieZhihu(Long id, Long idMovieDouban, String nameZh, BigDecimal zhihuScore, Integer zhihuVote, BigDecimal maoyanScore) {
        this.id = id;
        this.idMovieDouban = idMovieDouban;
        this.nameZh = nameZh;
        this.zhihuScore = zhihuScore;
        this.zhihuVote = zhihuVote;
        this.maoyanScore = maoyanScore;
    }

    public MovieZhihu() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public BigDecimal getZhihuScore() {
        return zhihuScore;
    }

    public void setZhihuScore(BigDecimal zhihuScore) {
        this.zhihuScore = zhihuScore;
    }

    public Integer getZhihuVote() {
        return zhihuVote;
    }

    public void setZhihuVote(Integer zhihuVote) {
        this.zhihuVote = zhihuVote;
    }

    public BigDecimal getMaoyanScore() {
        return maoyanScore;
    }

    public void setMaoyanScore(BigDecimal maoyanScore) {
        this.maoyanScore = maoyanScore;
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
        MovieZhihu other = (MovieZhihu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getZhihuScore() == null ? other.getZhihuScore() == null : this.getZhihuScore().equals(other.getZhihuScore()))
            && (this.getZhihuVote() == null ? other.getZhihuVote() == null : this.getZhihuVote().equals(other.getZhihuVote()))
            && (this.getMaoyanScore() == null ? other.getMaoyanScore() == null : this.getMaoyanScore().equals(other.getMaoyanScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getZhihuScore() == null) ? 0 : getZhihuScore().hashCode());
        result = prime * result + ((getZhihuVote() == null) ? 0 : getZhihuVote().hashCode());
        result = prime * result + ((getMaoyanScore() == null) ? 0 : getMaoyanScore().hashCode());
        return result;
    }
}