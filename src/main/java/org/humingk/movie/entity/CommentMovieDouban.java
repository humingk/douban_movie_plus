package org.humingk.movie.entity;

public class CommentMovieDouban {
    private Long idMovieDouban;

    private String idUserDouban;

    private Short agreeVote;

    private Long createDate;

    private String content;

    public CommentMovieDouban(Long idMovieDouban, String idUserDouban, Short agreeVote, Long createDate, String content) {
        this.idMovieDouban = idMovieDouban;
        this.idUserDouban = idUserDouban;
        this.agreeVote = agreeVote;
        this.createDate = createDate;
        this.content = content;
    }

    public CommentMovieDouban() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public String getIdUserDouban() {
        return idUserDouban;
    }

    public void setIdUserDouban(String idUserDouban) {
        this.idUserDouban = idUserDouban == null ? null : idUserDouban.trim();
    }

    public Short getAgreeVote() {
        return agreeVote;
    }

    public void setAgreeVote(Short agreeVote) {
        this.agreeVote = agreeVote;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
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
        CommentMovieDouban other = (CommentMovieDouban) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getIdUserDouban() == null ? other.getIdUserDouban() == null : this.getIdUserDouban().equals(other.getIdUserDouban()))
            && (this.getAgreeVote() == null ? other.getAgreeVote() == null : this.getAgreeVote().equals(other.getAgreeVote()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getIdUserDouban() == null) ? 0 : getIdUserDouban().hashCode());
        result = prime * result + ((getAgreeVote() == null) ? 0 : getAgreeVote().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }
}