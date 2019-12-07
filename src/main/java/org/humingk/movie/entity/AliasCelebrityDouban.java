package org.humingk.movie.entity;

public class AliasCelebrityDouban {
    private Long idCelebrityDouban;

    private String nameAlias;

    private Boolean isNikename;

    public AliasCelebrityDouban(Long idCelebrityDouban, String nameAlias, Boolean isNikename) {
        this.idCelebrityDouban = idCelebrityDouban;
        this.nameAlias = nameAlias;
        this.isNikename = isNikename;
    }

    public AliasCelebrityDouban() {
        super();
    }

    public Long getIdCelebrityDouban() {
        return idCelebrityDouban;
    }

    public void setIdCelebrityDouban(Long idCelebrityDouban) {
        this.idCelebrityDouban = idCelebrityDouban;
    }

    public String getNameAlias() {
        return nameAlias;
    }

    public void setNameAlias(String nameAlias) {
        this.nameAlias = nameAlias == null ? null : nameAlias.trim();
    }

    public Boolean getIsNikename() {
        return isNikename;
    }

    public void setIsNikename(Boolean isNikename) {
        this.isNikename = isNikename;
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
        AliasCelebrityDouban other = (AliasCelebrityDouban) that;
        return (this.getIdCelebrityDouban() == null ? other.getIdCelebrityDouban() == null : this.getIdCelebrityDouban().equals(other.getIdCelebrityDouban()))
            && (this.getNameAlias() == null ? other.getNameAlias() == null : this.getNameAlias().equals(other.getNameAlias()))
            && (this.getIsNikename() == null ? other.getIsNikename() == null : this.getIsNikename().equals(other.getIsNikename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdCelebrityDouban() == null) ? 0 : getIdCelebrityDouban().hashCode());
        result = prime * result + ((getNameAlias() == null) ? 0 : getNameAlias().hashCode());
        result = prime * result + ((getIsNikename() == null) ? 0 : getIsNikename().hashCode());
        return result;
    }
}