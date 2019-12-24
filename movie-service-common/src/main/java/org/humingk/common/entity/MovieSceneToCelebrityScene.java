package org.humingk.common.entity;

import java.io.Serializable;

public class MovieSceneToCelebrityScene implements Serializable {
    private Long idMovieScene;

    private Long idCelebrityScene;

    private static final long serialVersionUID = 1L;

    public MovieSceneToCelebrityScene(Long idMovieScene, Long idCelebrityScene) {
        this.idMovieScene = idMovieScene;
        this.idCelebrityScene = idCelebrityScene;
    }

    public MovieSceneToCelebrityScene() {
        super();
    }

    public Long getIdMovieScene() {
        return idMovieScene;
    }

    public void setIdMovieScene(Long idMovieScene) {
        this.idMovieScene = idMovieScene;
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
        MovieSceneToCelebrityScene other = (MovieSceneToCelebrityScene) that;
        return (this.getIdMovieScene() == null ? other.getIdMovieScene() == null : this.getIdMovieScene().equals(other.getIdMovieScene()))
            && (this.getIdCelebrityScene() == null ? other.getIdCelebrityScene() == null : this.getIdCelebrityScene().equals(other.getIdCelebrityScene()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieScene() == null) ? 0 : getIdMovieScene().hashCode());
        result = prime * result + ((getIdCelebrityScene() == null) ? 0 : getIdCelebrityScene().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idMovieScene=").append(idMovieScene);
        sb.append(", idCelebrityScene=").append(idCelebrityScene);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}