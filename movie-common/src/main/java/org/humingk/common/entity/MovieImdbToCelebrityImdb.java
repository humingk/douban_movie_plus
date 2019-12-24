package org.humingk.common.entity;

import java.io.Serializable;

public class MovieImdbToCelebrityImdb implements Serializable {
    private Long idMovieImdb;

    private Long idCelebrityImdb;

    private Byte idProfession;

    private static final long serialVersionUID = 1L;

    public MovieImdbToCelebrityImdb(Long idMovieImdb, Long idCelebrityImdb, Byte idProfession) {
        this.idMovieImdb = idMovieImdb;
        this.idCelebrityImdb = idCelebrityImdb;
        this.idProfession = idProfession;
    }

    public MovieImdbToCelebrityImdb() {
        super();
    }

    public Long getIdMovieImdb() {
        return idMovieImdb;
    }

    public void setIdMovieImdb(Long idMovieImdb) {
        this.idMovieImdb = idMovieImdb;
    }

    public Long getIdCelebrityImdb() {
        return idCelebrityImdb;
    }

    public void setIdCelebrityImdb(Long idCelebrityImdb) {
        this.idCelebrityImdb = idCelebrityImdb;
    }

    public Byte getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Byte idProfession) {
        this.idProfession = idProfession;
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
        MovieImdbToCelebrityImdb other = (MovieImdbToCelebrityImdb) that;
        return (this.getIdMovieImdb() == null ? other.getIdMovieImdb() == null : this.getIdMovieImdb().equals(other.getIdMovieImdb()))
            && (this.getIdCelebrityImdb() == null ? other.getIdCelebrityImdb() == null : this.getIdCelebrityImdb().equals(other.getIdCelebrityImdb()))
            && (this.getIdProfession() == null ? other.getIdProfession() == null : this.getIdProfession().equals(other.getIdProfession()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieImdb() == null) ? 0 : getIdMovieImdb().hashCode());
        result = prime * result + ((getIdCelebrityImdb() == null) ? 0 : getIdCelebrityImdb().hashCode());
        result = prime * result + ((getIdProfession() == null) ? 0 : getIdProfession().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idMovieImdb=").append(idMovieImdb);
        sb.append(", idCelebrityImdb=").append(idCelebrityImdb);
        sb.append(", idProfession=").append(idProfession);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}