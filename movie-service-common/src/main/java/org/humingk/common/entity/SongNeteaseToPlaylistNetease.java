package org.humingk.common.entity;

import java.io.Serializable;

public class SongNeteaseToPlaylistNetease implements Serializable {
    private Long idSongNetease;

    private Long idPlaylistNetease;

    private Byte songPop;

    private static final long serialVersionUID = 1L;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idSongNetease=").append(idSongNetease);
        sb.append(", idPlaylistNetease=").append(idPlaylistNetease);
        sb.append(", songPop=").append(songPop);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}