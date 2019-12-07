package org.humingk.movie.entity;

public class CommentNetease {
    private Long idSongNetease;

    private Long id;

    private Long idUserNetease;

    private Long createDatetime;

    private String content;

    private Integer agreeVote;

    public CommentNetease(Long idSongNetease, Long id, Long idUserNetease, Long createDatetime, String content, Integer agreeVote) {
        this.idSongNetease = idSongNetease;
        this.id = id;
        this.idUserNetease = idUserNetease;
        this.createDatetime = createDatetime;
        this.content = content;
        this.agreeVote = agreeVote;
    }

    public CommentNetease() {
        super();
    }

    public Long getIdSongNetease() {
        return idSongNetease;
    }

    public void setIdSongNetease(Long idSongNetease) {
        this.idSongNetease = idSongNetease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUserNetease() {
        return idUserNetease;
    }

    public void setIdUserNetease(Long idUserNetease) {
        this.idUserNetease = idUserNetease;
    }

    public Long getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Long createDatetime) {
        this.createDatetime = createDatetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        CommentNetease other = (CommentNetease) that;
        return (this.getIdSongNetease() == null ? other.getIdSongNetease() == null : this.getIdSongNetease().equals(other.getIdSongNetease()))
            && (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdUserNetease() == null ? other.getIdUserNetease() == null : this.getIdUserNetease().equals(other.getIdUserNetease()))
            && (this.getCreateDatetime() == null ? other.getCreateDatetime() == null : this.getCreateDatetime().equals(other.getCreateDatetime()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getAgreeVote() == null ? other.getAgreeVote() == null : this.getAgreeVote().equals(other.getAgreeVote()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdSongNetease() == null) ? 0 : getIdSongNetease().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdUserNetease() == null) ? 0 : getIdUserNetease().hashCode());
        result = prime * result + ((getCreateDatetime() == null) ? 0 : getCreateDatetime().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getAgreeVote() == null) ? 0 : getAgreeVote().hashCode());
        return result;
    }
}