package org.humingk.movie.entity;

public class ResourceResourcelist {
    private String resourceUrl;

    private Integer resourcelistId;

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public Integer getResourcelistId() {
        return resourcelistId;
    }

    public void setResourcelistId(Integer resourcelistId) {
        this.resourcelistId = resourcelistId;
    }
}