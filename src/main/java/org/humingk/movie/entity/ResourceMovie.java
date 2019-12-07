package org.humingk.movie.entity;

public class ResourceMovie {
    private Long id;

    private Long idMovieDouban;

    private Long idMovieImdb;

    private Short idWebsiteResource;

    private Short idTypeResource;

    private String nameZh;

    private Short createYear;

    private String nameOrigin;

    private String urlResource;

    public ResourceMovie(Long id, Long idMovieDouban, Long idMovieImdb, Short idWebsiteResource, Short idTypeResource, String nameZh, Short createYear, String nameOrigin, String urlResource) {
        this.id = id;
        this.idMovieDouban = idMovieDouban;
        this.idMovieImdb = idMovieImdb;
        this.idWebsiteResource = idWebsiteResource;
        this.idTypeResource = idTypeResource;
        this.nameZh = nameZh;
        this.createYear = createYear;
        this.nameOrigin = nameOrigin;
        this.urlResource = urlResource;
    }

    public ResourceMovie() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public Long getIdMovieImdb() {
        return idMovieImdb;
    }

    public void setIdMovieImdb(Long idMovieImdb) {
        this.idMovieImdb = idMovieImdb;
    }

    public Short getIdWebsiteResource() {
        return idWebsiteResource;
    }

    public void setIdWebsiteResource(Short idWebsiteResource) {
        this.idWebsiteResource = idWebsiteResource;
    }

    public Short getIdTypeResource() {
        return idTypeResource;
    }

    public void setIdTypeResource(Short idTypeResource) {
        this.idTypeResource = idTypeResource;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public Short getCreateYear() {
        return createYear;
    }

    public void setCreateYear(Short createYear) {
        this.createYear = createYear;
    }

    public String getNameOrigin() {
        return nameOrigin;
    }

    public void setNameOrigin(String nameOrigin) {
        this.nameOrigin = nameOrigin == null ? null : nameOrigin.trim();
    }

    public String getUrlResource() {
        return urlResource;
    }

    public void setUrlResource(String urlResource) {
        this.urlResource = urlResource == null ? null : urlResource.trim();
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
        ResourceMovie other = (ResourceMovie) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getIdMovieImdb() == null ? other.getIdMovieImdb() == null : this.getIdMovieImdb().equals(other.getIdMovieImdb()))
            && (this.getIdWebsiteResource() == null ? other.getIdWebsiteResource() == null : this.getIdWebsiteResource().equals(other.getIdWebsiteResource()))
            && (this.getIdTypeResource() == null ? other.getIdTypeResource() == null : this.getIdTypeResource().equals(other.getIdTypeResource()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getCreateYear() == null ? other.getCreateYear() == null : this.getCreateYear().equals(other.getCreateYear()))
            && (this.getNameOrigin() == null ? other.getNameOrigin() == null : this.getNameOrigin().equals(other.getNameOrigin()))
            && (this.getUrlResource() == null ? other.getUrlResource() == null : this.getUrlResource().equals(other.getUrlResource()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getIdMovieImdb() == null) ? 0 : getIdMovieImdb().hashCode());
        result = prime * result + ((getIdWebsiteResource() == null) ? 0 : getIdWebsiteResource().hashCode());
        result = prime * result + ((getIdTypeResource() == null) ? 0 : getIdTypeResource().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getCreateYear() == null) ? 0 : getCreateYear().hashCode());
        result = prime * result + ((getNameOrigin() == null) ? 0 : getNameOrigin().hashCode());
        result = prime * result + ((getUrlResource() == null) ? 0 : getUrlResource().hashCode());
        return result;
    }
}