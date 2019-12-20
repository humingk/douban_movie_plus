package org.humingk.movie.entity;

import java.io.Serializable;

public class ImageSceneDetail implements Serializable {
    private Long id;

    private Long idSceneDetail;

    private String urlImage;

    private static final long serialVersionUID = 1L;

    public ImageSceneDetail(Long id, Long idSceneDetail, String urlImage) {
        this.id = id;
        this.idSceneDetail = idSceneDetail;
        this.urlImage = urlImage;
    }

    public ImageSceneDetail() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSceneDetail() {
        return idSceneDetail;
    }

    public void setIdSceneDetail(Long idSceneDetail) {
        this.idSceneDetail = idSceneDetail;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage == null ? null : urlImage.trim();
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
        ImageSceneDetail other = (ImageSceneDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdSceneDetail() == null ? other.getIdSceneDetail() == null : this.getIdSceneDetail().equals(other.getIdSceneDetail()))
            && (this.getUrlImage() == null ? other.getUrlImage() == null : this.getUrlImage().equals(other.getUrlImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdSceneDetail() == null) ? 0 : getIdSceneDetail().hashCode());
        result = prime * result + ((getUrlImage() == null) ? 0 : getUrlImage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idSceneDetail=").append(idSceneDetail);
        sb.append(", urlImage=").append(urlImage);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}