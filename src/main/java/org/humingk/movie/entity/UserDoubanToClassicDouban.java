package org.humingk.movie.entity;

public class UserDoubanToClassicDouban {
    private String idUserDouban;

    private Long idClassicDouban;

    private Long recordDatetime;

    private String description;

    public UserDoubanToClassicDouban(String idUserDouban, Long idClassicDouban, Long recordDatetime, String description) {
        this.idUserDouban = idUserDouban;
        this.idClassicDouban = idClassicDouban;
        this.recordDatetime = recordDatetime;
        this.description = description;
    }

    public UserDoubanToClassicDouban() {
        super();
    }

    public String getIdUserDouban() {
        return idUserDouban;
    }

    public void setIdUserDouban(String idUserDouban) {
        this.idUserDouban = idUserDouban == null ? null : idUserDouban.trim();
    }

    public Long getIdClassicDouban() {
        return idClassicDouban;
    }

    public void setIdClassicDouban(Long idClassicDouban) {
        this.idClassicDouban = idClassicDouban;
    }

    public Long getRecordDatetime() {
        return recordDatetime;
    }

    public void setRecordDatetime(Long recordDatetime) {
        this.recordDatetime = recordDatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        UserDoubanToClassicDouban other = (UserDoubanToClassicDouban) that;
        return (this.getIdUserDouban() == null ? other.getIdUserDouban() == null : this.getIdUserDouban().equals(other.getIdUserDouban()))
            && (this.getIdClassicDouban() == null ? other.getIdClassicDouban() == null : this.getIdClassicDouban().equals(other.getIdClassicDouban()))
            && (this.getRecordDatetime() == null ? other.getRecordDatetime() == null : this.getRecordDatetime().equals(other.getRecordDatetime()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdUserDouban() == null) ? 0 : getIdUserDouban().hashCode());
        result = prime * result + ((getIdClassicDouban() == null) ? 0 : getIdClassicDouban().hashCode());
        result = prime * result + ((getRecordDatetime() == null) ? 0 : getRecordDatetime().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idUserDouban=").append(idUserDouban);
        sb.append(", idClassicDouban=").append(idClassicDouban);
        sb.append(", recordDatetime=").append(recordDatetime);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}