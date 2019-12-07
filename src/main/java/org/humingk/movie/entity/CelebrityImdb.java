package org.humingk.movie.entity;

public class CelebrityImdb {
    private Long id;

    private String nameEn;

    private Short birthYear;

    private Long idCelebrityDouban;

    public CelebrityImdb(Long id, String nameEn, Short birthYear, Long idCelebrityDouban) {
        this.id = id;
        this.nameEn = nameEn;
        this.birthYear = birthYear;
        this.idCelebrityDouban = idCelebrityDouban;
    }

    public CelebrityImdb() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public Short getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Short birthYear) {
        this.birthYear = birthYear;
    }

    public Long getIdCelebrityDouban() {
        return idCelebrityDouban;
    }

    public void setIdCelebrityDouban(Long idCelebrityDouban) {
        this.idCelebrityDouban = idCelebrityDouban;
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
        CelebrityImdb other = (CelebrityImdb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getBirthYear() == null ? other.getBirthYear() == null : this.getBirthYear().equals(other.getBirthYear()))
            && (this.getIdCelebrityDouban() == null ? other.getIdCelebrityDouban() == null : this.getIdCelebrityDouban().equals(other.getIdCelebrityDouban()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getBirthYear() == null) ? 0 : getBirthYear().hashCode());
        result = prime * result + ((getIdCelebrityDouban() == null) ? 0 : getIdCelebrityDouban().hashCode());
        return result;
    }
}