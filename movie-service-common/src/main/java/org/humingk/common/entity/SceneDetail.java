package org.humingk.common.entity;

import java.io.Serializable;

public class SceneDetail implements Serializable {
    private Long id;

    private Long idScene;

    private Long idMovieScene;

    private Integer happenTime;

    private String description;

    private static final long serialVersionUID = 1L;

    public SceneDetail(Long id, Long idScene, Long idMovieScene, Integer happenTime, String description) {
        this.id = id;
        this.idScene = idScene;
        this.idMovieScene = idMovieScene;
        this.happenTime = happenTime;
        this.description = description;
    }

    public SceneDetail() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdScene() {
        return idScene;
    }

    public void setIdScene(Long idScene) {
        this.idScene = idScene;
    }

    public Long getIdMovieScene() {
        return idMovieScene;
    }

    public void setIdMovieScene(Long idMovieScene) {
        this.idMovieScene = idMovieScene;
    }

    public Integer getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Integer happenTime) {
        this.happenTime = happenTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        SceneDetail other = (SceneDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdScene() == null ? other.getIdScene() == null : this.getIdScene().equals(other.getIdScene()))
            && (this.getIdMovieScene() == null ? other.getIdMovieScene() == null : this.getIdMovieScene().equals(other.getIdMovieScene()))
            && (this.getHappenTime() == null ? other.getHappenTime() == null : this.getHappenTime().equals(other.getHappenTime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdScene() == null) ? 0 : getIdScene().hashCode());
        result = prime * result + ((getIdMovieScene() == null) ? 0 : getIdMovieScene().hashCode());
        result = prime * result + ((getHappenTime() == null) ? 0 : getHappenTime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idScene=").append(idScene);
        sb.append(", idMovieScene=").append(idMovieScene);
        sb.append(", happenTime=").append(happenTime);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}