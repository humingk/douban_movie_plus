package org.humingk.movie.entity;

public class SongNeteaseToAlbumNetease {
    private Long idSongNetease;

    private Long idAlbumNetease;

    public SongNeteaseToAlbumNetease(Long idSongNetease, Long idAlbumNetease) {
        this.idSongNetease = idSongNetease;
        this.idAlbumNetease = idAlbumNetease;
    }

    public SongNeteaseToAlbumNetease() {
        super();
    }

    public Long getIdSongNetease() {
        return idSongNetease;
    }

    public void setIdSongNetease(Long idSongNetease) {
        this.idSongNetease = idSongNetease;
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
        SongNeteaseToAlbumNetease other = (SongNeteaseToAlbumNetease) that;
        return (this.getIdSongNetease() == null ? other.getIdSongNetease() == null : this.getIdSongNetease().equals(other.getIdSongNetease()))
            && (this.getIdAlbumNetease() == null ? other.getIdAlbumNetease() == null : this.getIdAlbumNetease().equals(other.getIdAlbumNetease()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdSongNetease() == null) ? 0 : getIdSongNetease().hashCode());
        result = prime * result + ((getIdAlbumNetease() == null) ? 0 : getIdAlbumNetease().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idSongNetease=").append(idSongNetease);
        sb.append(", idAlbumNetease=").append(idAlbumNetease);
        sb.append("]");
        return sb.toString();
    }
}