package org.humingk.movie.entity;

public class UserToRole {
    private String idUser;

    private Byte idRole;

    public UserToRole(String idUser, Byte idRole) {
        this.idUser = idUser;
        this.idRole = idRole;
    }

    public UserToRole() {
        super();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser == null ? null : idUser.trim();
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
        UserToRole other = (UserToRole) that;
        return (this.getIdUser() == null ? other.getIdUser() == null : this.getIdUser().equals(other.getIdUser()))
            && (this.getIdRole() == null ? other.getIdRole() == null : this.getIdRole().equals(other.getIdRole()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdUser() == null) ? 0 : getIdUser().hashCode());
        result = prime * result + ((getIdRole() == null) ? 0 : getIdRole().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idUser=").append(idUser);
        sb.append(", idRole=").append(idRole);
        sb.append("]");
        return sb.toString();
    }
}