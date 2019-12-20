package org.humingk.movie.entity;

import java.io.Serializable;

public class ReviewMovieDouban implements Serializable {
    private Long id;

    private Integer agreeVote;

    private Integer againstVote;

    private Long createDatetime;

    private String title;

    private String content;

    private static final long serialVersionUID = 1L;

    public ReviewMovieDouban(Long id, Integer agreeVote, Integer againstVote, Long createDatetime, String title) {
        this.id = id;
        this.agreeVote = agreeVote;
        this.againstVote = againstVote;
        this.createDatetime = createDatetime;
        this.title = title;
    }

    public ReviewMovieDouban(Long id, Integer agreeVote, Integer againstVote, Long createDatetime, String title, String content) {
        this.id = id;
        this.agreeVote = agreeVote;
        this.againstVote = againstVote;
        this.createDatetime = createDatetime;
        this.title = title;
        this.content = content;
    }

    public ReviewMovieDouban() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAgreeVote() {
        return agreeVote;
    }

    public void setAgreeVote(Integer agreeVote) {
        this.agreeVote = agreeVote;
    }

    public Integer getAgainstVote() {
        return againstVote;
    }

    public void setAgainstVote(Integer againstVote) {
        this.againstVote = againstVote;
    }

    public Long getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Long createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        ReviewMovieDouban other = (ReviewMovieDouban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAgreeVote() == null ? other.getAgreeVote() == null : this.getAgreeVote().equals(other.getAgreeVote()))
            && (this.getAgainstVote() == null ? other.getAgainstVote() == null : this.getAgainstVote().equals(other.getAgainstVote()))
            && (this.getCreateDatetime() == null ? other.getCreateDatetime() == null : this.getCreateDatetime().equals(other.getCreateDatetime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAgreeVote() == null) ? 0 : getAgreeVote().hashCode());
        result = prime * result + ((getAgainstVote() == null) ? 0 : getAgainstVote().hashCode());
        result = prime * result + ((getCreateDatetime() == null) ? 0 : getCreateDatetime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", agreeVote=").append(agreeVote);
        sb.append(", againstVote=").append(againstVote);
        sb.append(", createDatetime=").append(createDatetime);
        sb.append(", title=").append(title);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}