package org.humingk.movie.dal.entity;

import java.io.Serializable;

public class ArtistNeteaseToAlbumNetease implements Serializable {
    private Long idArtistNetease;

    private Long idAlbumNetease;

    private static final long serialVersionUID = 1L;

    public ArtistNeteaseToAlbumNetease(Long idArtistNetease, Long idAlbumNetease) {
        this.idArtistNetease = idArtistNetease;
        this.idAlbumNetease = idAlbumNetease;
    }

    public ArtistNeteaseToAlbumNetease() {
        super();
    }

    public Long getIdArtistNetease() {
        return idArtistNetease;
    }

    public void setIdArtistNetease(Long idArtistNetease) {
        this.idArtistNetease = idArtistNetease;
    }

    public Long getIdAlbumNetease() {
        return idAlbumNetease;
    }

    public void setIdAlbumNetease(Long idAlbumNetease) {
        this.idAlbumNetease = idAlbumNetease;
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
        ArtistNeteaseToAlbumNetease other = (ArtistNeteaseToAlbumNetease) that;
        return (this.getIdArtistNetease() == null ? other.getIdArtistNetease() == null : this.getIdArtistNetease().equals(other.getIdArtistNetease()))
            && (this.getIdAlbumNetease() == null ? other.getIdAlbumNetease() == null : this.getIdAlbumNetease().equals(other.getIdAlbumNetease()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdArtistNetease() == null) ? 0 : getIdArtistNetease().hashCode());
        result = prime * result + ((getIdAlbumNetease() == null) ? 0 : getIdAlbumNetease().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idArtistNetease=").append(idArtistNetease);
        sb.append(", idAlbumNetease=").append(idAlbumNetease);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}