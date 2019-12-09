package org.humingk.movie.entity;

public class UserDoubanToRole {
    private String idUserDouban;

    private Byte idRole;

    public UserDoubanToRole(String idUserDouban, Byte idRole) {
        this.idUserDouban = idUserDouban;
        this.idRole = idRole;
    }

    public UserDoubanToRole() {
        super();
    }

    public String getIdUserDouban() {
        return idUserDouban;
    }

    public void setIdUserDouban(String idUserDouban) {
        this.idUserDouban = idUserDouban == null ? null : idUserDouban.trim();
    }

    public Byte getIdRole() {
        return idRole;
    }

    public void setIdRole(Byte idRole) {
        this.idRole = idRole;
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
        UserDoubanToRole other = (UserDoubanToRole) that;
        return (this.getIdUserDouban() == null ? other.getIdUserDouban() == null : this.getIdUserDouban().equals(other.getIdUserDouban()))
            && (this.getIdRole() == null ? other.getIdRole() == null : this.getIdRole().equals(other.getIdRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdUserDouban() == null) ? 0 : getIdUserDouban().hashCode());
        result = prime * result + ((getIdRole() == null) ? 0 : getIdRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idUserDouban=").append(idUserDouban);
        sb.append(", idRole=").append(idRole);
        sb.append("]");
        return sb.toString();
    }
}