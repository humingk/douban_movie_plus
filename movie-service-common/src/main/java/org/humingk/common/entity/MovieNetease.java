package org.humingk.common.entity;

import java.io.Serializable;

public class MovieNetease implements Serializable {
    private Long idMovieDouban;

    private Long idNetease;

    private Byte neteaseType;

    private Byte sort;

    private static final long serialVersionUID = 1L;

    public MovieNetease(Long idMovieDouban, Long idNetease, Byte neteaseType, Byte sort) {
        this.idMovieDouban = idMovieDouban;
        this.idNetease = idNetease;
        this.neteaseType = neteaseType;
        this.sort = sort;
    }

    public MovieNetease() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public Long getIdNetease() {
        return idNetease;
    }

    public void setIdNetease(Long idNetease) {
        this.idNetease = idNetease;
    }

    public Byte getNeteaseType() {
        return neteaseType;
    }

    public void setNeteaseType(Byte neteaseType) {
        this.neteaseType = neteaseType;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
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
        MovieNetease other = (MovieNetease) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getIdNetease() == null ? other.getIdNetease() == null : this.getIdNetease().equals(other.getIdNetease()))
            && (this.getNeteaseType() == null ? other.getNeteaseType() == null : this.getNeteaseType().equals(other.getNeteaseType()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getIdNetease() == null) ? 0 : getIdNetease().hashCode());
        result = prime * result + ((getNeteaseType() == null) ? 0 : getNeteaseType().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idMovieDouban=").append(idMovieDouban);
        sb.append(", idNetease=").append(idNetease);
        sb.append(", neteaseType=").append(neteaseType);
        sb.append(", sort=").append(sort);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}