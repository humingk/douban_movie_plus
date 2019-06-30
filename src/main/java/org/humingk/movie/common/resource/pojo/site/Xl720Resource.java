package org.humingk.movie.common.resource.pojo.site;

import org.humingk.movie.common.resource.pojo.ClientResource;
import org.humingk.movie.common.resource.pojo.Resource;

import java.util.List;

/**
 * @author lzx
 * @author humingk
 */
public class Xl720Resource extends ClientResource {
    /**
     * 磁力链接
     */
    private List<Resource> magnet;
    /**
     * 迅雷链接
     */
    private List<Resource> thunder;

    public List<Resource> getMagnet() {
        return magnet;
    }

    public void setMagnet(List<Resource> magnet) {
        this.magnet = magnet;
    }

    public List<Resource> getThunder() {
        return thunder;
    }

    public void setThunder(List<Resource> thunder) {
        this.thunder = thunder;
    }

}
