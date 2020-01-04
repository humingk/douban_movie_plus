package org.humingk.movie.service.common.entity;

import java.io.Serializable;

public class WebsiteResource implements Serializable {
    private Short id;

    private String nameZh;

    private String websiteSrc;

    private static final long serialVersionUID = 1L;

    public WebsiteResource(Short id, String nameZh, String websiteSrc) {
        this.id = id;
        this.nameZh = nameZh;
        this.websiteSrc = websiteSrc;
    }

    public WebsiteResource() {
        super();
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public String getWebsiteSrc() {
        return websiteSrc;
    }

    public void setWebsiteSrc(String websiteSrc) {
        this.websiteSrc = websiteSrc == null ? null : websiteSrc.trim();
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
        WebsiteResource other = (WebsiteResource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getWebsiteSrc() == null ? other.getWebsiteSrc() == null : this.getWebsiteSrc().equals(other.getWebsiteSrc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getWebsiteSrc() == null) ? 0 : getWebsiteSrc().hashCode());
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
        sb.append(", websiteSrc=").append(websiteSrc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}