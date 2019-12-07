package org.humingk.movie.entity;

public class TrailerMovieDouban {
    private Long id;

    private Long idMovieDouban;

    private String urlVideo;

    public TrailerMovieDouban(Long id, Long idMovieDouban, String urlVideo) {
        this.id = id;
        this.idMovieDouban = idMovieDouban;
        this.urlVideo = urlVideo;
    }

    public TrailerMovieDouban() {
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

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo == null ? null : urlVideo.trim();
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
        TrailerMovieDouban other = (TrailerMovieDouban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getUrlVideo() == null ? other.getUrlVideo() == null : this.getUrlVideo().equals(other.getUrlVideo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getUrlVideo() == null) ? 0 : getUrlVideo().hashCode());
        return result;
    }
}