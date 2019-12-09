package org.humingk.movie.entity;

public class PlaceSceneToTypePlaceScene {
    private Long idPlaceScene;

    private Byte idTypePlaceScene;

    public PlaceSceneToTypePlaceScene(Long idPlaceScene, Byte idTypePlaceScene) {
        this.idPlaceScene = idPlaceScene;
        this.idTypePlaceScene = idTypePlaceScene;
    }

    public PlaceSceneToTypePlaceScene() {
        super();
    }

    public Long getIdPlaceScene() {
        return idPlaceScene;
    }

    public void setIdPlaceScene(Long idPlaceScene) {
        this.idPlaceScene = idPlaceScene;
    }

    public Byte getIdTypePlaceScene() {
        return idTypePlaceScene;
    }

    public void setIdTypePlaceScene(Byte idTypePlaceScene) {
        this.idTypePlaceScene = idTypePlaceScene;
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
        PlaceSceneToTypePlaceScene other = (PlaceSceneToTypePlaceScene) that;
        return (this.getIdPlaceScene() == null ? other.getIdPlaceScene() == null : this.getIdPlaceScene().equals(other.getIdPlaceScene()))
            && (this.getIdTypePlaceScene() == null ? other.getIdTypePlaceScene() == null : this.getIdTypePlaceScene().equals(other.getIdTypePlaceScene()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdPlaceScene() == null) ? 0 : getIdPlaceScene().hashCode());
        result = prime * result + ((getIdTypePlaceScene() == null) ? 0 : getIdTypePlaceScene().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idPlaceScene=").append(idPlaceScene);
        sb.append(", idTypePlaceScene=").append(idTypePlaceScene);
        sb.append("]");
        return sb.toString();
    }
}