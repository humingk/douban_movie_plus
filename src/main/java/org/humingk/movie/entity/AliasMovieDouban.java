package org.humingk.movie.entity;

public class AliasMovieDouban {
    private Long idMovieDouban;

    private String nameAlias;

    public AliasMovieDouban(Long idMovieDouban, String nameAlias) {
        this.idMovieDouban = idMovieDouban;
        this.nameAlias = nameAlias;
    }

    public AliasMovieDouban() {
        super();
    }

    public Long getIdMovieDouban() {
        return idMovieDouban;
    }

    public void setIdMovieDouban(Long idMovieDouban) {
        this.idMovieDouban = idMovieDouban;
    }

    public String getNameAlias() {
        return nameAlias;
    }

    public void setNameAlias(String nameAlias) {
        this.nameAlias = nameAlias == null ? null : nameAlias.trim();
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
        AliasMovieDouban other = (AliasMovieDouban) that;
        return (this.getIdMovieDouban() == null ? other.getIdMovieDouban() == null : this.getIdMovieDouban().equals(other.getIdMovieDouban()))
            && (this.getNameAlias() == null ? other.getNameAlias() == null : this.getNameAlias().equals(other.getNameAlias()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdMovieDouban() == null) ? 0 : getIdMovieDouban().hashCode());
        result = prime * result + ((getNameAlias() == null) ? 0 : getNameAlias().hashCode());
        return result;
    }
}