package org.humingk.movie.common.resource.pojo.site;

import org.humingk.movie.common.resource.pojo.ClientResource;
import org.humingk.movie.common.resource.pojo.Resource;

import java.util.List;

/**
 * @author humingk
 */
public class LoldyttResource extends ClientResource {
    /**
     * 磁力链接
     */
    private List<Resource> magnet;
    /**
     * 迅雷链接
     */
    private List<Resource> thunder;

    public void setThunder(List<Resource> thunder) {
        this.thunder = thunder;
    }

    public List<Resource> getMagnet() {
        return magnet;
    }

    public void setMagnet(List<Resource> magnet) {
        this.magnet = magnet;
    }

}
