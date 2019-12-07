package org.humingk.movie.entity;

public class ArtistNeteaseToAlbumNetease {
    private Long idArtistNetease;

    private Long idAlbumNetease;

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
}