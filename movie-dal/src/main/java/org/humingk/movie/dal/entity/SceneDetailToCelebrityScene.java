package org.humingk.movie.dal.entity;

import java.io.Serializable;

public class SceneDetailToCelebrityScene implements Serializable {
    private Long idSceneDetail;

    private Long idCelebrityScene;

    private static final long serialVersionUID = 1L;

    public SceneDetailToCelebrityScene(Long idSceneDetail, Long idCelebrityScene) {
        this.idSceneDetail = idSceneDetail;
        this.idCelebrityScene = idCelebrityScene;
    }

    public SceneDetailToCelebrityScene() {
        super();
    }

    public Long getIdSceneDetail() {
        return idSceneDetail;
    }

    public void setIdSceneDetail(Long idSceneDetail) {
        this.idSceneDetail = idSceneDetail;
    }

    public Long getIdCelebrityScene() {
        return idCelebrityScene;
    }

    public void setIdCelebrityScene(Long idCelebrityScene) {
        this.idCelebrityScene = idCelebrityScene;
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
        SceneDetailToCelebrityScene other = (SceneDetailToCelebrityScene) that;
        return (this.getIdSceneDetail() == null ? other.getIdSceneDetail() == null : this.getIdSceneDetail().equals(other.getIdSceneDetail()))
            && (this.getIdCelebrityScene() == null ? other.getIdCelebrityScene() == null : this.getIdCelebrityScene().equals(other.getIdCelebrityScene()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdSceneDetail() == null) ? 0 : getIdSceneDetail().hashCode());
        result = prime * result + ((getIdCelebrityScene() == null) ? 0 : getIdCelebrityScene().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idSceneDetail=").append(idSceneDetail);
        sb.append(", idCelebrityScene=").append(idCelebrityScene);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}