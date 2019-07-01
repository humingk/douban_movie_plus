package org.humingk.movie.entity;

public class Resourcetype {
    private Integer resourcetypeId;

    private String resourcetypeName;

    public Integer getResourcetypeId() {
        return resourcetypeId;
    }

    public void setResourcetypeId(Integer resourcetypeId) {
        this.resourcetypeId = resourcetypeId;
    }

    public String getResourcetypeName() {
        return resourcetypeName;
    }

    public void setResourcetypeName(String resourcetypeName) {
        this.resourcetypeName = resourcetypeName == null ? null : resourcetypeName.trim();
    }
}