package org.humingk.common.entity;

import java.io.Serializable;

public class CelebrityDoubanToClassic implements Serializable {
    private Long idCelebrityDouban;

    private Long idClassicDouban;

    private static final long serialVersionUID = 1L;

    public CelebrityDoubanToClassic(Long idCelebrityDouban, Long idClassicDouban) {
        this.idCelebrityDouban = idCelebrityDouban;
        this.idClassicDouban = idClassicDouban;
    }

    public CelebrityDoubanToClassic() {
        super();
    }

    public Long getIdCelebrityDouban() {
        return idCelebrityDouban;
    }

    public void setIdCelebrityDouban(Long idCelebrityDouban) {
        this.idCelebrityDouban = idCelebrityDouban;
    }

    public Long getIdClassicDouban() {
        return idClassicDouban;
    }

    public void setIdClassicDouban(Long idClassicDouban) {
        this.idClassicDouban = idClassicDouban;
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
        CelebrityDoubanToClassic other = (CelebrityDoubanToClassic) that;
        return (this.getIdCelebrityDouban() == null ? other.getIdCelebrityDouban() == null : this.getIdCelebrityDouban().equals(other.getIdCelebrityDouban()))
            && (this.getIdClassicDouban() == null ? other.getIdClassicDouban() == null : this.getIdClassicDouban().equals(other.getIdClassicDouban()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdCelebrityDouban() == null) ? 0 : getIdCelebrityDouban().hashCode());
        result = prime * result + ((getIdClassicDouban() == null) ? 0 : getIdClassicDouban().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idCelebrityDouban=").append(idCelebrityDouban);
        sb.append(", idClassicDouban=").append(idClassicDouban);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}