package org.humingk.movie.common.resource.pojo;

/**
 * @author humingk
 */
public class Resource {
    private String resourceName;
    private String resourceUrl;

    public Resource(String resourceName, String resourceUrl){
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
    }
    public Resource(){}

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
