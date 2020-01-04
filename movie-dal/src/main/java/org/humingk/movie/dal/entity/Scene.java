package org.humingk.movie.dal.entity;

import java.io.Serializable;

public class Scene implements Serializable {
    private Long id;

    private Long idMovieScene;

    private Long idPlaceScene;

    private String nameZh;

    private Integer happenTime;

    private static final long serialVersionUID = 1L;

    public Scene(Long id, Long idMovieScene, Long idPlaceScene, String nameZh, Integer happenTime) {
        this.id = id;
        this.idMovieScene = idMovieScene;
        this.idPlaceScene = idPlaceScene;
        this.nameZh = nameZh;
        this.happenTime = happenTime;
    }

    public Scene() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMovieScene() {
        return idMovieScene;
    }

    public void setIdMovieScene(Long idMovieScene) {
        this.idMovieScene = idMovieScene;
    }

    public Long getIdPlaceScene() {
        return idPlaceScene;
    }

    public void setIdPlaceScene(Long idPlaceScene) {
        this.idPlaceScene = idPlaceScene;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public Integer getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Integer happenTime) {
        this.happenTime = happenTime;
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
        Scene other = (Scene) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdMovieScene() == null ? other.getIdMovieScene() == null : this.getIdMovieScene().equals(other.getIdMovieScene()))
            && (this.getIdPlaceScene() == null ? other.getIdPlaceScene() == null : this.getIdPlaceScene().equals(other.getIdPlaceScene()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getHappenTime() == null ? other.getHappenTime() == null : this.getHappenTime().equals(other.getHappenTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdMovieScene() == null) ? 0 : getIdMovieScene().hashCode());
        result = prime * result + ((getIdPlaceScene() == null) ? 0 : getIdPlaceScene().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getHappenTime() == null) ? 0 : getHappenTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idMovieScene=").append(idMovieScene);
        sb.append(", idPlaceScene=").append(idPlaceScene);
        sb.append(", nameZh=").append(nameZh);
        sb.append(", happenTime=").append(happenTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}