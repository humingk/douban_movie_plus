package org.humingk.common.entity;

import java.io.Serializable;

public class MovieImdb implements Serializable {
    private Long id;

    private Byte idTypeVideo;

    private String nameEn;

    private Short startYear;

    private Boolean isAdult;

    private String nameOrigin;

    private Short runtime;

    private String urlPoster;

    private Long idMovieDouban;

    private String summary;

    private static final long serialVersionUID = 1L;

    public MovieImdb(Long id, Byte idTypeVideo, String nameEn, Short startYear, Boolean isAdult, String nameOrigin, Short runtime, String urlPoster, Long idMovieDouban) {
        this.id = id;
        this.idTypeVideo = idTypeVideo;
        this.nameEn = nameEn;
        this.startYear = startYear;
        this.isAdult = isAdult;
        this.nameOrigin = nameOrigin;
        this.runtime = runtime;
        this.urlPoster = urlPoster;
        this.idMovieDouban = idMovieDouban;
    }

    public MovieImdb(Long id, Byte idTypeVideo, String nameEn, Short startYear, Boolean isAdult, String nameOrigin, Short runtime, String urlPoster, Long idMovieDouban, String summary) {
        this.id = id;
        this.idTypeVideo = idTypeVideo;
        this.nameEn = nameEn;
        this.startYear = startYear;
        this.isAdult = isAdult;
        this.nameOrigin = nameOrigin;
        this.runtime = runtime;
        this.urlPoster = urlPoster;
        this.idMovieDouban = idMovieDouban;
        this.summary = summary;
    }

    public MovieImdb() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getIdTypeVideo() {
        return idTypeVideo;
    }

    public void setIdTypeVideo(Byte idTypeVideo) {
        this.idTypeVideo = idTypeVideo;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public Short getStartYear() {
        return startYear;
    }

    public void setStartYear(Short startYear) {
        this.startYear = startYear;
    }

    public Boolean getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
    }

    public String getNameOrigin() {
        return nameOrigin;
    }

    public void setNameOrigin(String nameOrigin) {
        this.nameOrigin = nameOrigin == null ? null : nameOrigin.trim();
    }

    public Short getRuntime() {
        return runtime;
    }

    public void setRuntime(Short runtime) {
        this.runtime = runtime;
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster == null ? null : urlPoster.trim();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
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
        MovieImdb other = (MovieImdb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdTypeVideo() == null ? other.getIdTypeVideo() == null : this.getIdTypeVideo().equals(other.getIdTypeVideo()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getStartYear() == null ? other.getStartYear() == null : this.getStartYear().equals(other.getStartYear()))
            && (this.getIsAdult() == null ? other.getIsAdult() == null : this.getIsAdult().equals(other.getIsAdult()))
            && (this.getNameOrigin() == null ? other.getNameOrigin() == null : this.getNameOrigin().equals(other.getNameOrigin()))
            && (this.getRuntime() == null ? other.getRuntime() == null : this.getRuntime().equals(other.getRuntime()))
            && (this.getUrlPoster() == null ? other.getUrlPoster() == null : this.getUrlPoster().equals(other.getUrlPoster()))
            && (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdTypeVideo() == null) ? 0 : getIdTypeVideo().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getStartYear() == null) ? 0 : getStartYear().hashCode());
        result = prime * result + ((getIsAdult() == null) ? 0 : getIsAdult().hashCode());
        result = prime * result + ((getNameOrigin() == null) ? 0 : getNameOrigin().hashCode());
        result = prime * result + ((getRuntime() == null) ? 0 : getRuntime().hashCode());
        result = prime * result + ((getUrlPoster() == null) ? 0 : getUrlPoster().hashCode());
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idTypeVideo=").append(idTypeVideo);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", startYear=").append(startYear);
        sb.append(", isAdult=").append(isAdult);
        sb.append(", nameOrigin=").append(nameOrigin);
        sb.append(", runtime=").append(runtime);
        sb.append(", urlPoster=").append(urlPoster);
        sb.append(", idMovieDouban=").append(idMovieDouban);
        sb.append(", summary=").append(summary);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}