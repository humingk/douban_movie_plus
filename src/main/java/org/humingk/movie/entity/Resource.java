package org.humingk.movie.entity;

public class Resource {
    private String resourceUrl;

    private String keyword;

    private String resourceName;

    private Integer resourceType;

    private Integer clientType;

    public Resource() {
    }

    public Resource(String keyword) {
        this.keyword = keyword;
    }

    public Resource(String resourceName, String resourceUrl) {
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
    }

    public Resource(String keyword, String resourceName, String resourceUrl, int clientType, int resourceType) {
        this.keyword = keyword;
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceType = resourceType;
        this.clientType = clientType;
    }

    public String toString() {
        return getKeyword() + " - " + getClientType() + " - " + getResourceType() + " - " + getResourceName() + " - " + getResourceUrl();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }
}