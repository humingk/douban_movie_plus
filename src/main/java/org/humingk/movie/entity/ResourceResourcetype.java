package org.humingk.movie.entity;

public class ResourceResourcetype {
    private String resourceUrl;

    private Integer resourcetypeId;

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public Integer getResourcetypeId() {
        return resourcetypeId;
    }

    public void setResourcetypeId(Integer resourcetypeId) {
        this.resourcetypeId = resourcetypeId;
    }
}