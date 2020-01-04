package org.humingk.movie.dal.entity;

import java.io.Serializable;

public class AliasMovieDouban implements Serializable {
    private Long idMovieDouban;

    private String nameAlias;

    private static final long serialVersionUID = 1L;

    public AliasMovieDouban(Long idMovieDouban, String nameAlias) {
        this.idMovieDouban = idMovieDouban;
        this.nameAlias = nameAlias;
    }

    public AliasMovieDouban() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public String getNameAlias() {
        return nameAlias;
    }

    public void setNameAlias(String nameAlias) {
        this.nameAlias = nameAlias == null ? null : nameAlias.trim();
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
        AliasMovieDouban other = (AliasMovieDouban) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getNameAlias() == null ? other.getNameAlias() == null : this.getNameAlias().equals(other.getNameAlias()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getNameAlias() == null) ? 0 : getNameAlias().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idMovieDouban=").append(idMovieDouban);
        sb.append(", nameAlias=").append(nameAlias);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}