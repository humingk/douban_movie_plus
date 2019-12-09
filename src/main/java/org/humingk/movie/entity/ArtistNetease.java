package org.humingk.movie.entity;

public class ArtistNetease {
    private Long id;

    private String nameZh;

    private String urlPortrait;

    public ArtistNetease(Long id, String nameZh, String urlPortrait) {
        this.id = id;
        this.nameZh = nameZh;
        this.urlPortrait = urlPortrait;
    }

    public ArtistNetease() {
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

    public String getUrlPortrait() {
        return urlPortrait;
    }

    public void setUrlPortrait(String urlPortrait) {
        this.urlPortrait = urlPortrait == null ? null : urlPortrait.trim();
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
        ArtistNetease other = (ArtistNetease) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getUrlPortrait() == null ? other.getUrlPortrait() == null : this.getUrlPortrait().equals(other.getUrlPortrait()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getUrlPortrait() == null) ? 0 : getUrlPortrait().hashCode());
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
        sb.append(", urlPortrait=").append(urlPortrait);
        sb.append("]");
        return sb.toString();
    }
}