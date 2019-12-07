package org.humingk.movie.entity;

public class SongNeteaseToPlaylistNetease {
    private Long idSongNetease;

    private Long idPlaylistNetease;

    private Byte songPop;

    public SongNeteaseToPlaylistNetease(Long idSongNetease, Long idPlaylistNetease, Byte songPop) {
        this.idSongNetease = idSongNetease;
        this.idPlaylistNetease = idPlaylistNetease;
        this.songPop = songPop;
    }

    public SongNeteaseToPlaylistNetease() {
        super();
    }

    public Long getIdSongNetease() {
        return idSongNetease;
    }

    public void setIdSongNetease(Long idSongNetease) {
        this.idSongNetease = idSongNetease;
    }

    public Long getIdPlaylistNetease() {
        return idPlaylistNetease;
    }

    public void setIdPlaylistNetease(Long idPlaylistNetease) {
        this.idPlaylistNetease = idPlaylistNetease;
    }

    public Byte getSongPop() {
        return songPop;
    }

    public void setSongPop(Byte songPop) {
        this.songPop = songPop;
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
        SongNeteaseToPlaylistNetease other = (SongNeteaseToPlaylistNetease) that;
        return (this.getIdSongNetease() == null ? other.getIdSongNetease() == null : this.getIdSongNetease().equals(other.getIdSongNetease()))
            && (this.getIdPlaylistNetease() == null ? other.getIdPlaylistNetease() == null : this.getIdPlaylistNetease().equals(other.getIdPlaylistNetease()))
            && (this.getSongPop() == null ? other.getSongPop() == null : this.getSongPop().equals(other.getSongPop()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdSongNetease() == null) ? 0 : getIdSongNetease().hashCode());
        result = prime * result + ((getIdPlaylistNetease() == null) ? 0 : getIdPlaylistNetease().hashCode());
        result = prime * result + ((getSongPop() == null) ? 0 : getSongPop().hashCode());
        return result;
    }
}