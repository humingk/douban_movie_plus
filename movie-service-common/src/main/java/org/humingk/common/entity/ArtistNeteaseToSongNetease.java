package org.humingk.common.entity;

import java.io.Serializable;

public class ArtistNeteaseToSongNetease implements Serializable {
    private Long idArtistNetease;

    private Long idSongNetease;

    private static final long serialVersionUID = 1L;

    public ArtistNeteaseToSongNetease(Long idArtistNetease, Long idSongNetease) {
        this.idArtistNetease = idArtistNetease;
        this.idSongNetease = idSongNetease;
    }

    public ArtistNeteaseToSongNetease() {
        super();
    }

    public Long getIdArtistNetease() {
        return idArtistNetease;
    }

    public void setIdArtistNetease(Long idArtistNetease) {
        this.idArtistNetease = idArtistNetease;
    }

    public Long getIdSongNetease() {
        return idSongNetease;
    }

    public void setIdSongNetease(Long idSongNetease) {
        this.idSongNetease = idSongNetease;
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
        ArtistNeteaseToSongNetease other = (ArtistNeteaseToSongNetease) that;
        return (this.getIdArtistNetease() == null ? other.getIdArtistNetease() == null : this.getIdArtistNetease().equals(other.getIdArtistNetease()))
            && (this.getIdSongNetease() == null ? other.getIdSongNetease() == null : this.getIdSongNetease().equals(other.getIdSongNetease()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdArtistNetease() == null) ? 0 : getIdArtistNetease().hashCode());
        result = prime * result + ((getIdSongNetease() == null) ? 0 : getIdSongNetease().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idArtistNetease=").append(idArtistNetease);
        sb.append(", idSongNetease=").append(idSongNetease);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}