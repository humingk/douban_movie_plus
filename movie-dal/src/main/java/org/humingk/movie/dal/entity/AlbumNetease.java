package org.humingk.movie.dal.entity;

import java.io.Serializable;

public class AlbumNetease implements Serializable {
    private Long id;

    private String nameZh;

    private Short total;

    private String urlCover;

    private static final long serialVersionUID = 1L;

    public AlbumNetease(Long id, String nameZh, Short total, String urlCover) {
        this.id = id;
        this.nameZh = nameZh;
        this.total = total;
        this.urlCover = urlCover;
    }

    public AlbumNetease() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public Short getTotal() {
        return total;
    }

    public void setTotal(Short total) {
        this.total = total;
    }

    public String getUrlCover() {
        return urlCover;
    }

    public void setUrlCover(String urlCover) {
        this.urlCover = urlCover == null ? null : urlCover.trim();
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
        AlbumNetease other = (AlbumNetease) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getUrlCover() == null ? other.getUrlCover() == null : this.getUrlCover().equals(other.getUrlCover()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getUrlCover() == null) ? 0 : getUrlCover().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nameZh=").append(nameZh);
        sb.append(", total=").append(total);
        sb.append(", urlCover=").append(urlCover);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}