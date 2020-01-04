package org.humingk.movie.dal.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class PlaceScene implements Serializable {
    private Long id;

    private Byte idContinentScene;

    private Short idCountryScene;

    private Integer idStateScene;

    private Integer idCityScene;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String nameZh;

    private String nameEn;

    private String nameOther;

    private String alias;

    private String addressZh;

    private String addressEn;

    private String description;

    private String areaZh;

    private String areaEn;

    private String phone;

    private String urlPoster;

    private String urlEarth;

    private String urlSatellite;

    private String urlMap;

    private static final long serialVersionUID = 1L;

    public PlaceScene(Long id, Byte idContinentScene, Short idCountryScene, Integer idStateScene, Integer idCityScene, BigDecimal longitude, BigDecimal latitude, String nameZh, String nameEn, String nameOther, String alias, String addressZh, String addressEn, String description, String areaZh, String areaEn, String phone, String urlPoster, String urlEarth, String urlSatellite, String urlMap) {
        this.id = id;
        this.idContinentScene = idContinentScene;
        this.idCountryScene = idCountryScene;
        this.idStateScene = idStateScene;
        this.idCityScene = idCityScene;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nameZh = nameZh;
        this.nameEn = nameEn;
        this.nameOther = nameOther;
        this.alias = alias;
        this.addressZh = addressZh;
        this.addressEn = addressEn;
        this.description = description;
        this.areaZh = areaZh;
        this.areaEn = areaEn;
        this.phone = phone;
        this.urlPoster = urlPoster;
        this.urlEarth = urlEarth;
        this.urlSatellite = urlSatellite;
        this.urlMap = urlMap;
    }

    public PlaceScene() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getIdContinentScene() {
        return idContinentScene;
    }

    public void setIdContinentScene(Byte idContinentScene) {
        this.idContinentScene = idContinentScene;
    }

    public Short getIdCountryScene() {
        return idCountryScene;
    }

    public void setIdCountryScene(Short idCountryScene) {
        this.idCountryScene = idCountryScene;
    }

    public Integer getIdStateScene() {
        return idStateScene;
    }

    public void setIdStateScene(Integer idStateScene) {
        this.idStateScene = idStateScene;
    }

    public Integer getIdCityScene() {
        return idCityScene;
    }

    public void setIdCityScene(Integer idCityScene) {
        this.idCityScene = idCityScene;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh == null ? null : nameZh.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public String getNameOther() {
        return nameOther;
    }

    public void setNameOther(String nameOther) {
        this.nameOther = nameOther == null ? null : nameOther.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getAddressZh() {
        return addressZh;
    }

    public void setAddressZh(String addressZh) {
        this.addressZh = addressZh == null ? null : addressZh.trim();
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn == null ? null : addressEn.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getAreaZh() {
        return areaZh;
    }

    public void setAreaZh(String areaZh) {
        this.areaZh = areaZh == null ? null : areaZh.trim();
    }

    public String getAreaEn() {
        return areaEn;
    }

    public void setAreaEn(String areaEn) {
        this.areaEn = areaEn == null ? null : areaEn.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUrlPoster() {
        return urlPoster;
    }

    public void setUrlPoster(String urlPoster) {
        this.urlPoster = urlPoster == null ? null : urlPoster.trim();
    }

    public String getUrlEarth() {
        return urlEarth;
    }

    public void setUrlEarth(String urlEarth) {
        this.urlEarth = urlEarth == null ? null : urlEarth.trim();
    }

    public String getUrlSatellite() {
        return urlSatellite;
    }

    public void setUrlSatellite(String urlSatellite) {
        this.urlSatellite = urlSatellite == null ? null : urlSatellite.trim();
    }

    public String getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(String urlMap) {
        this.urlMap = urlMap == null ? null : urlMap.trim();
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
        PlaceScene other = (PlaceScene) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdContinentScene() == null ? other.getIdContinentScene() == null : this.getIdContinentScene().equals(other.getIdContinentScene()))
            && (this.getIdCountryScene() == null ? other.getIdCountryScene() == null : this.getIdCountryScene().equals(other.getIdCountryScene()))
            && (this.getIdStateScene() == null ? other.getIdStateScene() == null : this.getIdStateScene().equals(other.getIdStateScene()))
            && (this.getIdCityScene() == null ? other.getIdCityScene() == null : this.getIdCityScene().equals(other.getIdCityScene()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getNameZh() == null ? other.getNameZh() == null : this.getNameZh().equals(other.getNameZh()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getNameOther() == null ? other.getNameOther() == null : this.getNameOther().equals(other.getNameOther()))
            && (this.getAlias() == null ? other.getAlias() == null : this.getAlias().equals(other.getAlias()))
            && (this.getAddressZh() == null ? other.getAddressZh() == null : this.getAddressZh().equals(other.getAddressZh()))
            && (this.getAddressEn() == null ? other.getAddressEn() == null : this.getAddressEn().equals(other.getAddressEn()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAreaZh() == null ? other.getAreaZh() == null : this.getAreaZh().equals(other.getAreaZh()))
            && (this.getAreaEn() == null ? other.getAreaEn() == null : this.getAreaEn().equals(other.getAreaEn()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getUrlPoster() == null ? other.getUrlPoster() == null : this.getUrlPoster().equals(other.getUrlPoster()))
            && (this.getUrlEarth() == null ? other.getUrlEarth() == null : this.getUrlEarth().equals(other.getUrlEarth()))
            && (this.getUrlSatellite() == null ? other.getUrlSatellite() == null : this.getUrlSatellite().equals(other.getUrlSatellite()))
            && (this.getUrlMap() == null ? other.getUrlMap() == null : this.getUrlMap().equals(other.getUrlMap()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdContinentScene() == null) ? 0 : getIdContinentScene().hashCode());
        result = prime * result + ((getIdCountryScene() == null) ? 0 : getIdCountryScene().hashCode());
        result = prime * result + ((getIdStateScene() == null) ? 0 : getIdStateScene().hashCode());
        result = prime * result + ((getIdCityScene() == null) ? 0 : getIdCityScene().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getNameZh() == null) ? 0 : getNameZh().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getNameOther() == null) ? 0 : getNameOther().hashCode());
        result = prime * result + ((getAlias() == null) ? 0 : getAlias().hashCode());
        result = prime * result + ((getAddressZh() == null) ? 0 : getAddressZh().hashCode());
        result = prime * result + ((getAddressEn() == null) ? 0 : getAddressEn().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAreaZh() == null) ? 0 : getAreaZh().hashCode());
        result = prime * result + ((getAreaEn() == null) ? 0 : getAreaEn().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getUrlPoster() == null) ? 0 : getUrlPoster().hashCode());
        result = prime * result + ((getUrlEarth() == null) ? 0 : getUrlEarth().hashCode());
        result = prime * result + ((getUrlSatellite() == null) ? 0 : getUrlSatellite().hashCode());
        result = prime * result + ((getUrlMap() == null) ? 0 : getUrlMap().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idContinentScene=").append(idContinentScene);
        sb.append(", idCountryScene=").append(idCountryScene);
        sb.append(", idStateScene=").append(idStateScene);
        sb.append(", idCityScene=").append(idCityScene);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", nameZh=").append(nameZh);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", nameOther=").append(nameOther);
        sb.append(", alias=").append(alias);
        sb.append(", addressZh=").append(addressZh);
        sb.append(", addressEn=").append(addressEn);
        sb.append(", description=").append(description);
        sb.append(", areaZh=").append(areaZh);
        sb.append(", areaEn=").append(areaEn);
        sb.append(", phone=").append(phone);
        sb.append(", urlPoster=").append(urlPoster);
        sb.append(", urlEarth=").append(urlEarth);
        sb.append(", urlSatellite=").append(urlSatellite);
        sb.append(", urlMap=").append(urlMap);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}