package org.humingk.movie.service.common.entity;

import java.io.Serializable;

public class ClassicDouban implements Serializable {
    private Long id;

    private Long idMovieDouban;

    private String content;

    private Integer happenTime;

    private Integer agreeVote;

    private static final long serialVersionUID = 1L;

    public ClassicDouban(Long id, Long idMovieDouban, String content, Integer happenTime, Integer agreeVote) {
        this.id = id;
        this.idMovieDouban = idMovieDouban;
        this.content = content;
        this.happenTime = happenTime;
        this.agreeVote = agreeVote;
    }

    public ClassicDouban() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Integer happenTime) {
        this.happenTime = happenTime;
    }

    public Integer getAgreeVote() {
        return agreeVote;
    }

    public void setAgreeVote(Integer agreeVote) {
        this.agreeVote = agreeVote;
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
        ClassicDouban other = (ClassicDouban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getHappenTime() == null ? other.getHappenTime() == null : this.getHappenTime().equals(other.getHappenTime()))
            && (this.getAgreeVote() == null ? other.getAgreeVote() == null : this.getAgreeVote().equals(other.getAgreeVote()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getHappenTime() == null) ? 0 : getHappenTime().hashCode());
        result = prime * result + ((getAgreeVote() == null) ? 0 : getAgreeVote().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idMovieDouban=").append(idMovieDouban);
        sb.append(", content=").append(content);
        sb.append(", happenTime=").append(happenTime);
        sb.append(", agreeVote=").append(agreeVote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}