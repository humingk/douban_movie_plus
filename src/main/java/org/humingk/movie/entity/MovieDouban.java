package org.humingk.movie.entity;

public class MovieDouban {
    private Long id;

    private Byte idTypeVideo;

    private Long idMovieImdb;

    private Short startYear;

    private String nameZh;

    private String nameOrigin;

    private Short runtime;

    private Long urlPoster;

    private Integer haveSeen;

    private Integer wannaSee;

    private Boolean isNetease;

    private Boolean isZhihu;

    private String summary;

    public MovieDouban(Long id, Byte idTypeVideo, Long idMovieImdb, Short startYear, String nameZh, String nameOrigin, Short runtime, Long urlPoster, Integer haveSeen, Integer wannaSee, Boolean isNetease, Boolean isZhihu) {
        this.id = id;
        this.idTypeVideo = idTypeVideo;
        this.idMovieImdb = idMovieImdb;
        this.startYear = startYear;
        this.nameZh = nameZh;
        this.nameOrigin = nameOrigin;
        this.runtime = runtime;
        this.urlPoster = urlPoster;
        this.haveSeen = haveSeen;
        this.wannaSee = wannaSee;
        this.isNetease = isNetease;
        this.isZhihu = isZhihu;
    }

    public MovieDouban(Long id, Byte idTypeVideo, Long idMovieImdb, Short startYear, String nameZh, String nameOrigin, Short runtime, Long urlPoster, Integer haveSeen, Integer wannaSee, Boolean isNetease, Boolean isZhihu, String summary) {
        this.id = id;
        this.idTypeVideo = idTypeVideo;
        this.idMovieImdb = idMovieImdb;
        this.startYear = startYear;
        this.nameZh = nameZh;
        this.nameOrigin = nameOrigin;
        this.runtime = runtime;
        this.urlPoster = urlPoster;
        this.haveSeen = haveSeen;
        this.wannaSee = wannaSee;
        this.isNetease = isNetease;
        this.isZhihu = isZhihu;
        this.summary = summary;
    }

    public MovieDouban() {
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

    public Long getIdMovieImdb() {
        return idMovieImdb;
    }

    public void setIdMovieImdb(Long idMovieImdb) {
        this.idMovieImdb = idMovieImdb;
    }

    public Short getStartYear() {
        return startYear;
    }

    public void setStartYear(Short startYear) {
        this.startYear = startYear;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
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

    public Long getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPoster(Long urlPoster) {
        this.urlPoster = urlPoster;
    }

    public Integer getHaveSeen() {
        return haveSeen;
    }

    public void setHaveSeen(Integer haveSeen) {
        this.haveSeen = haveSeen;
    }

    public Integer getWannaSee() {
        return wannaSee;
    }

    public void setWannaSee(Integer wannaSee) {
        this.wannaSee = wannaSee;
    }

    public Boolean getIsNetease() {
        return isNetease;
    }

    public void setIsNetease(Boolean isNetease) {
        this.isNetease = isNetease;
    }

    public Boolean getIsZhihu() {
        return isZhihu;
    }

    public void setIsZhihu(Boolean isZhihu) {
        this.isZhihu = isZhihu;
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
        MovieDouban other = (MovieDouban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdTypeVideo() == null ? other.getIdTypeVideo() == null : this.getIdTypeVideo().equals(other.getIdTypeVideo()))
            && (this.getIdMovieImdb() == null ? other.getIdMovieImdb() == null : this.getIdMovieImdb().equals(other.getIdMovieImdb()))
            && (this.getStartYear() == null ? other.getStartYear() == null : this.getStartYear().equals(other.getStartYear()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getNameOrigin() == null ? other.getNameOrigin() == null : this.getNameOrigin().equals(other.getNameOrigin()))
            && (this.getRuntime() == null ? other.getRuntime() == null : this.getRuntime().equals(other.getRuntime()))
            && (this.getUrlPoster() == null ? other.getUrlPoster() == null : this.getUrlPoster().equals(other.getUrlPoster()))
            && (this.getHaveSeen() == null ? other.getHaveSeen() == null : this.getHaveSeen().equals(other.getHaveSeen()))
            && (this.getWannaSee() == null ? other.getWannaSee() == null : this.getWannaSee().equals(other.getWannaSee()))
            && (this.getIsNetease() == null ? other.getIsNetease() == null : this.getIsNetease().equals(other.getIsNetease()))
            && (this.getIsZhihu() == null ? other.getIsZhihu() == null : this.getIsZhihu().equals(other.getIsZhihu()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdTypeVideo() == null) ? 0 : getIdTypeVideo().hashCode());
        result = prime * result + ((getIdMovieImdb() == null) ? 0 : getIdMovieImdb().hashCode());
        result = prime * result + ((getStartYear() == null) ? 0 : getStartYear().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getNameOrigin() == null) ? 0 : getNameOrigin().hashCode());
        result = prime * result + ((getRuntime() == null) ? 0 : getRuntime().hashCode());
        result = prime * result + ((getUrlPoster() == null) ? 0 : getUrlPoster().hashCode());
        result = prime * result + ((getHaveSeen() == null) ? 0 : getHaveSeen().hashCode());
        result = prime * result + ((getWannaSee() == null) ? 0 : getWannaSee().hashCode());
        result = prime * result + ((getIsNetease() == null) ? 0 : getIsNetease().hashCode());
        result = prime * result + ((getIsZhihu() == null) ? 0 : getIsZhihu().hashCode());
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
        sb.append(", idMovieImdb=").append(idMovieImdb);
        sb.append(", startYear=").append(startYear);
        sb.append(", nameZh=").append(nameZh);
        sb.append(", nameOrigin=").append(nameOrigin);
        sb.append(", runtime=").append(runtime);
        sb.append(", urlPoster=").append(urlPoster);
        sb.append(", haveSeen=").append(haveSeen);
        sb.append(", wannaSee=").append(wannaSee);
        sb.append(", isNetease=").append(isNetease);
        sb.append(", isZhihu=").append(isZhihu);
        sb.append(", summary=").append(summary);
        sb.append("]");
        return sb.toString();
    }
}