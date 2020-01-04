package org.humingk.movie.service.common.entity;

import java.io.Serializable;

public class ImageCelebrityDouban implements Serializable {
    private Long id;

    private Long idCelebrityDouban;

    private Byte sort;

    private Integer length;

    private Integer width;

    private static final long serialVersionUID = 1L;

    public ImageCelebrityDouban(Long id, Long idCelebrityDouban, Byte sort, Integer length, Integer width) {
        this.id = id;
        this.idCelebrityDouban = idCelebrityDouban;
        this.sort = sort;
        this.length = length;
        this.width = width;
    }

    public ImageCelebrityDouban() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCelebrityDouban() {
        return idCelebrityDouban;
    }

    public void setIdCelebrityDouban(Long idCelebrityDouban) {
        this.idCelebrityDouban = idCelebrityDouban;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
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
        ImageCelebrityDouban other = (ImageCelebrityDouban) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdCelebrityDouban() == null ? other.getIdCelebrityDouban() == null : this.getIdCelebrityDouban().equals(other.getIdCelebrityDouban()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdCelebrityDouban() == null) ? 0 : getIdCelebrityDouban().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idCelebrityDouban=").append(idCelebrityDouban);
        sb.append(", sort=").append(sort);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}