package org.humingk.movie.entity;

public class CelebrityDouban {
    private Long id;

    private Long idCelebrityImdb;

    private String nameZh;

    private String nameOrigin;

    private Boolean sex;

    private Long birthDate;

    private Long urlPortrait;

    private String summary;

    public CelebrityDouban(Long id, Long idCelebrityImdb, String nameZh, String nameOrigin, Boolean sex, Long birthDate, Long urlPortrait) {
        this.id = id;
        this.idCelebrityImdb = idCelebrityImdb;
        this.nameZh = nameZh;
        this.nameOrigin = nameOrigin;
        this.sex = sex;
        this.birthDate = birthDate;
        this.urlPortrait = urlPortrait;
    }

    public CelebrityDouban(Long id, Long idCelebrityImdb, String nameZh, String nameOrigin, Boolean sex, Long birthDate, Long urlPortrait, String summary) {
        this.id = id;
        this.idCelebrityImdb = idCelebrityImdb;
        this.nameZh = nameZh;
        this.nameOrigin = nameOrigin;
        this.sex = sex;
        this.birthDate = birthDate;
        this.urlPortrait = urlPortrait;
        this.summary = summary;
    }

    public CelebrityDouban() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCelebrityImdb() {
        return idCelebrityImdb;
    }

    public void setIdCelebrityImdb(Long idCelebrityImdb) {
        this.idCelebrityImdb = idCelebrityImdb;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Long getUrlPortrait() {
        return urlPortrait;
    }

    public void setUrlPortrait(Long urlPortrait) {
        this.urlPortrait = urlPortrait;
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
        CelebrityDouban other = (CelebrityDouban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdCelebrityImdb() == null ? other.getIdCelebrityImdb() == null : this.getIdCelebrityImdb().equals(other.getIdCelebrityImdb()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getNameOrigin() == null ? other.getNameOrigin() == null : this.getNameOrigin().equals(other.getNameOrigin()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getUrlPortrait() == null ? other.getUrlPortrait() == null : this.getUrlPortrait().equals(other.getUrlPortrait()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdCelebrityImdb() == null) ? 0 : getIdCelebrityImdb().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getNameOrigin() == null) ? 0 : getNameOrigin().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getUrlPortrait() == null) ? 0 : getUrlPortrait().hashCode());
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
        sb.append(", idCelebrityImdb=").append(idCelebrityImdb);
        sb.append(", nameZh=").append(nameZh);
        sb.append(", nameOrigin=").append(nameOrigin);
        sb.append(", sex=").append(sex);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", urlPortrait=").append(urlPortrait);
        sb.append(", summary=").append(summary);
        sb.append("]");
        return sb.toString();
    }
}