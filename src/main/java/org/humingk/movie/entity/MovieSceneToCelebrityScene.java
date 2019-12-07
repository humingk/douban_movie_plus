package org.humingk.movie.entity;

public class MovieSceneToCelebrityScene {
    private Long idMovieScene;

    private Long idCelebrityScene;

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
}