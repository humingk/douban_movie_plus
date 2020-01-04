package org.humingk.movie.service.common.entity;

import java.io.Serializable;

public class RoleToPermission implements Serializable {
    private Byte idRole;

    private Integer idPermission;

    private static final long serialVersionUID = 1L;

    public RoleToPermission(Byte idRole, Integer idPermission) {
        this.idRole = idRole;
        this.idPermission = idPermission;
    }

    public RoleToPermission() {
        super();
    }

    public Byte getIdRole() {
        return idRole;
    }

    public void setIdRole(Byte idRole) {
        this.idRole = idRole;
    }

    public Integer getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Integer idPermission) {
        this.idPermission = idPermission;
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
        RoleToPermission other = (RoleToPermission) that;
        return (this.getIdRole() == null ? other.getIdRole() == null : this.getIdRole().equals(other.getIdRole()))
            && (this.getIdPermission() == null ? other.getIdPermission() == null : this.getIdPermission().equals(other.getIdPermission()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdRole() == null) ? 0 : getIdRole().hashCode());
        result = prime * result + ((getIdPermission() == null) ? 0 : getIdPermission().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idRole=").append(idRole);
        sb.append(", idPermission=").append(idPermission);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}