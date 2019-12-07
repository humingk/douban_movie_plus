package org.humingk.movie.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PlaceSceneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlaceSceneExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneIsNull() {
            addCriterion("id_continent_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneIsNotNull() {
            addCriterion("id_continent_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneEqualTo(Byte value) {
            addCriterion("id_continent_scene =", value, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneNotEqualTo(Byte value) {
            addCriterion("id_continent_scene <>", value, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneGreaterThan(Byte value) {
            addCriterion("id_continent_scene >", value, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneGreaterThanOrEqualTo(Byte value) {
            addCriterion("id_continent_scene >=", value, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneLessThan(Byte value) {
            addCriterion("id_continent_scene <", value, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneLessThanOrEqualTo(Byte value) {
            addCriterion("id_continent_scene <=", value, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneIn(List<Byte> values) {
            addCriterion("id_continent_scene in", values, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneNotIn(List<Byte> values) {
            addCriterion("id_continent_scene not in", values, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneBetween(Byte value1, Byte value2) {
            addCriterion("id_continent_scene between", value1, value2, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdContinentSceneNotBetween(Byte value1, Byte value2) {
            addCriterion("id_continent_scene not between", value1, value2, "idContinentScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneIsNull() {
            addCriterion("id_country_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneIsNotNull() {
            addCriterion("id_country_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneEqualTo(Short value) {
            addCriterion("id_country_scene =", value, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneNotEqualTo(Short value) {
            addCriterion("id_country_scene <>", value, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneGreaterThan(Short value) {
            addCriterion("id_country_scene >", value, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneGreaterThanOrEqualTo(Short value) {
            addCriterion("id_country_scene >=", value, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneLessThan(Short value) {
            addCriterion("id_country_scene <", value, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneLessThanOrEqualTo(Short value) {
            addCriterion("id_country_scene <=", value, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneIn(List<Short> values) {
            addCriterion("id_country_scene in", values, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneNotIn(List<Short> values) {
            addCriterion("id_country_scene not in", values, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneBetween(Short value1, Short value2) {
            addCriterion("id_country_scene between", value1, value2, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdCountrySceneNotBetween(Short value1, Short value2) {
            addCriterion("id_country_scene not between", value1, value2, "idCountryScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneIsNull() {
            addCriterion("id_state_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneIsNotNull() {
            addCriterion("id_state_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneEqualTo(Integer value) {
            addCriterion("id_state_scene =", value, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneNotEqualTo(Integer value) {
            addCriterion("id_state_scene <>", value, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneGreaterThan(Integer value) {
            addCriterion("id_state_scene >", value, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_state_scene >=", value, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneLessThan(Integer value) {
            addCriterion("id_state_scene <", value, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneLessThanOrEqualTo(Integer value) {
            addCriterion("id_state_scene <=", value, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneIn(List<Integer> values) {
            addCriterion("id_state_scene in", values, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneNotIn(List<Integer> values) {
            addCriterion("id_state_scene not in", values, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneBetween(Integer value1, Integer value2) {
            addCriterion("id_state_scene between", value1, value2, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdStateSceneNotBetween(Integer value1, Integer value2) {
            addCriterion("id_state_scene not between", value1, value2, "idStateScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneIsNull() {
            addCriterion("id_city_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneIsNotNull() {
            addCriterion("id_city_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneEqualTo(Integer value) {
            addCriterion("id_city_scene =", value, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneNotEqualTo(Integer value) {
            addCriterion("id_city_scene <>", value, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneGreaterThan(Integer value) {
            addCriterion("id_city_scene >", value, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_city_scene >=", value, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneLessThan(Integer value) {
            addCriterion("id_city_scene <", value, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneLessThanOrEqualTo(Integer value) {
            addCriterion("id_city_scene <=", value, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneIn(List<Integer> values) {
            addCriterion("id_city_scene in", values, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneNotIn(List<Integer> values) {
            addCriterion("id_city_scene not in", values, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneBetween(Integer value1, Integer value2) {
            addCriterion("id_city_scene between", value1, value2, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andIdCitySceneNotBetween(Integer value1, Integer value2) {
            addCriterion("id_city_scene not between", value1, value2, "idCityScene");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andNameZhIsNull() {
            addCriterion("name_zh is null");
            return (Criteria) this;
        }

        public Criteria andNameZhIsNotNull() {
            addCriterion("name_zh is not null");
            return (Criteria) this;
        }

        public Criteria andNameZhEqualTo(String value) {
            addCriterion("name_zh =", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhNotEqualTo(String value) {
            addCriterion("name_zh <>", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhGreaterThan(String value) {
            addCriterion("name_zh >", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhGreaterThanOrEqualTo(String value) {
            addCriterion("name_zh >=", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhLessThan(String value) {
            addCriterion("name_zh <", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhLessThanOrEqualTo(String value) {
            addCriterion("name_zh <=", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhLike(String value) {
            addCriterion("name_zh like", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhNotLike(String value) {
            addCriterion("name_zh not like", value, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhIn(List<String> values) {
            addCriterion("name_zh in", values, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhNotIn(List<String> values) {
            addCriterion("name_zh not in", values, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhBetween(String value1, String value2) {
            addCriterion("name_zh between", value1, value2, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameZhNotBetween(String value1, String value2) {
            addCriterion("name_zh not between", value1, value2, "nameZh");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameOtherIsNull() {
            addCriterion("name_other is null");
            return (Criteria) this;
        }

        public Criteria andNameOtherIsNotNull() {
            addCriterion("name_other is not null");
            return (Criteria) this;
        }

        public Criteria andNameOtherEqualTo(String value) {
            addCriterion("name_other =", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherNotEqualTo(String value) {
            addCriterion("name_other <>", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherGreaterThan(String value) {
            addCriterion("name_other >", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherGreaterThanOrEqualTo(String value) {
            addCriterion("name_other >=", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherLessThan(String value) {
            addCriterion("name_other <", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherLessThanOrEqualTo(String value) {
            addCriterion("name_other <=", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherLike(String value) {
            addCriterion("name_other like", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherNotLike(String value) {
            addCriterion("name_other not like", value, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherIn(List<String> values) {
            addCriterion("name_other in", values, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherNotIn(List<String> values) {
            addCriterion("name_other not in", values, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherBetween(String value1, String value2) {
            addCriterion("name_other between", value1, value2, "nameOther");
            return (Criteria) this;
        }

        public Criteria andNameOtherNotBetween(String value1, String value2) {
            addCriterion("name_other not between", value1, value2, "nameOther");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAddressZhIsNull() {
            addCriterion("address_zh is null");
            return (Criteria) this;
        }

        public Criteria andAddressZhIsNotNull() {
            addCriterion("address_zh is not null");
            return (Criteria) this;
        }

        public Criteria andAddressZhEqualTo(String value) {
            addCriterion("address_zh =", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhNotEqualTo(String value) {
            addCriterion("address_zh <>", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhGreaterThan(String value) {
            addCriterion("address_zh >", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhGreaterThanOrEqualTo(String value) {
            addCriterion("address_zh >=", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhLessThan(String value) {
            addCriterion("address_zh <", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhLessThanOrEqualTo(String value) {
            addCriterion("address_zh <=", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhLike(String value) {
            addCriterion("address_zh like", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhNotLike(String value) {
            addCriterion("address_zh not like", value, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhIn(List<String> values) {
            addCriterion("address_zh in", values, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhNotIn(List<String> values) {
            addCriterion("address_zh not in", values, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhBetween(String value1, String value2) {
            addCriterion("address_zh between", value1, value2, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressZhNotBetween(String value1, String value2) {
            addCriterion("address_zh not between", value1, value2, "addressZh");
            return (Criteria) this;
        }

        public Criteria andAddressEnIsNull() {
            addCriterion("address_en is null");
            return (Criteria) this;
        }

        public Criteria andAddressEnIsNotNull() {
            addCriterion("address_en is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEnEqualTo(String value) {
            addCriterion("address_en =", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotEqualTo(String value) {
            addCriterion("address_en <>", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnGreaterThan(String value) {
            addCriterion("address_en >", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnGreaterThanOrEqualTo(String value) {
            addCriterion("address_en >=", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnLessThan(String value) {
            addCriterion("address_en <", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnLessThanOrEqualTo(String value) {
            addCriterion("address_en <=", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnLike(String value) {
            addCriterion("address_en like", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotLike(String value) {
            addCriterion("address_en not like", value, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnIn(List<String> values) {
            addCriterion("address_en in", values, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotIn(List<String> values) {
            addCriterion("address_en not in", values, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnBetween(String value1, String value2) {
            addCriterion("address_en between", value1, value2, "addressEn");
            return (Criteria) this;
        }

        public Criteria andAddressEnNotBetween(String value1, String value2) {
            addCriterion("address_en not between", value1, value2, "addressEn");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andAreaZhIsNull() {
            addCriterion("area_zh is null");
            return (Criteria) this;
        }

        public Criteria andAreaZhIsNotNull() {
            addCriterion("area_zh is not null");
            return (Criteria) this;
        }

        public Criteria andAreaZhEqualTo(String value) {
            addCriterion("area_zh =", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhNotEqualTo(String value) {
            addCriterion("area_zh <>", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhGreaterThan(String value) {
            addCriterion("area_zh >", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhGreaterThanOrEqualTo(String value) {
            addCriterion("area_zh >=", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhLessThan(String value) {
            addCriterion("area_zh <", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhLessThanOrEqualTo(String value) {
            addCriterion("area_zh <=", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhLike(String value) {
            addCriterion("area_zh like", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhNotLike(String value) {
            addCriterion("area_zh not like", value, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhIn(List<String> values) {
            addCriterion("area_zh in", values, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhNotIn(List<String> values) {
            addCriterion("area_zh not in", values, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhBetween(String value1, String value2) {
            addCriterion("area_zh between", value1, value2, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaZhNotBetween(String value1, String value2) {
            addCriterion("area_zh not between", value1, value2, "areaZh");
            return (Criteria) this;
        }

        public Criteria andAreaEnIsNull() {
            addCriterion("area_en is null");
            return (Criteria) this;
        }

        public Criteria andAreaEnIsNotNull() {
            addCriterion("area_en is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEnEqualTo(String value) {
            addCriterion("area_en =", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnNotEqualTo(String value) {
            addCriterion("area_en <>", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnGreaterThan(String value) {
            addCriterion("area_en >", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnGreaterThanOrEqualTo(String value) {
            addCriterion("area_en >=", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnLessThan(String value) {
            addCriterion("area_en <", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnLessThanOrEqualTo(String value) {
            addCriterion("area_en <=", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnLike(String value) {
            addCriterion("area_en like", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnNotLike(String value) {
            addCriterion("area_en not like", value, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnIn(List<String> values) {
            addCriterion("area_en in", values, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnNotIn(List<String> values) {
            addCriterion("area_en not in", values, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnBetween(String value1, String value2) {
            addCriterion("area_en between", value1, value2, "areaEn");
            return (Criteria) this;
        }

        public Criteria andAreaEnNotBetween(String value1, String value2) {
            addCriterion("area_en not between", value1, value2, "areaEn");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andUrlPosterIsNull() {
            addCriterion("url_poster is null");
            return (Criteria) this;
        }

        public Criteria andUrlPosterIsNotNull() {
            addCriterion("url_poster is not null");
            return (Criteria) this;
        }

        public Criteria andUrlPosterEqualTo(String value) {
            addCriterion("url_poster =", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterNotEqualTo(String value) {
            addCriterion("url_poster <>", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterGreaterThan(String value) {
            addCriterion("url_poster >", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterGreaterThanOrEqualTo(String value) {
            addCriterion("url_poster >=", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterLessThan(String value) {
            addCriterion("url_poster <", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterLessThanOrEqualTo(String value) {
            addCriterion("url_poster <=", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterLike(String value) {
            addCriterion("url_poster like", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterNotLike(String value) {
            addCriterion("url_poster not like", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterIn(List<String> values) {
            addCriterion("url_poster in", values, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterNotIn(List<String> values) {
            addCriterion("url_poster not in", values, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterBetween(String value1, String value2) {
            addCriterion("url_poster between", value1, value2, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterNotBetween(String value1, String value2) {
            addCriterion("url_poster not between", value1, value2, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlEarthIsNull() {
            addCriterion("url_earth is null");
            return (Criteria) this;
        }

        public Criteria andUrlEarthIsNotNull() {
            addCriterion("url_earth is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEarthEqualTo(String value) {
            addCriterion("url_earth =", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthNotEqualTo(String value) {
            addCriterion("url_earth <>", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthGreaterThan(String value) {
            addCriterion("url_earth >", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthGreaterThanOrEqualTo(String value) {
            addCriterion("url_earth >=", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthLessThan(String value) {
            addCriterion("url_earth <", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthLessThanOrEqualTo(String value) {
            addCriterion("url_earth <=", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthLike(String value) {
            addCriterion("url_earth like", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthNotLike(String value) {
            addCriterion("url_earth not like", value, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthIn(List<String> values) {
            addCriterion("url_earth in", values, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthNotIn(List<String> values) {
            addCriterion("url_earth not in", values, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthBetween(String value1, String value2) {
            addCriterion("url_earth between", value1, value2, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlEarthNotBetween(String value1, String value2) {
            addCriterion("url_earth not between", value1, value2, "urlEarth");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteIsNull() {
            addCriterion("url_satellite is null");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteIsNotNull() {
            addCriterion("url_satellite is not null");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteEqualTo(String value) {
            addCriterion("url_satellite =", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteNotEqualTo(String value) {
            addCriterion("url_satellite <>", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteGreaterThan(String value) {
            addCriterion("url_satellite >", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteGreaterThanOrEqualTo(String value) {
            addCriterion("url_satellite >=", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteLessThan(String value) {
            addCriterion("url_satellite <", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteLessThanOrEqualTo(String value) {
            addCriterion("url_satellite <=", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteLike(String value) {
            addCriterion("url_satellite like", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteNotLike(String value) {
            addCriterion("url_satellite not like", value, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteIn(List<String> values) {
            addCriterion("url_satellite in", values, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteNotIn(List<String> values) {
            addCriterion("url_satellite not in", values, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteBetween(String value1, String value2) {
            addCriterion("url_satellite between", value1, value2, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlSatelliteNotBetween(String value1, String value2) {
            addCriterion("url_satellite not between", value1, value2, "urlSatellite");
            return (Criteria) this;
        }

        public Criteria andUrlMapIsNull() {
            addCriterion("url_map is null");
            return (Criteria) this;
        }

        public Criteria andUrlMapIsNotNull() {
            addCriterion("url_map is not null");
            return (Criteria) this;
        }

        public Criteria andUrlMapEqualTo(String value) {
            addCriterion("url_map =", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapNotEqualTo(String value) {
            addCriterion("url_map <>", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapGreaterThan(String value) {
            addCriterion("url_map >", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapGreaterThanOrEqualTo(String value) {
            addCriterion("url_map >=", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapLessThan(String value) {
            addCriterion("url_map <", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapLessThanOrEqualTo(String value) {
            addCriterion("url_map <=", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapLike(String value) {
            addCriterion("url_map like", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapNotLike(String value) {
            addCriterion("url_map not like", value, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapIn(List<String> values) {
            addCriterion("url_map in", values, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapNotIn(List<String> values) {
            addCriterion("url_map not in", values, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapBetween(String value1, String value2) {
            addCriterion("url_map between", value1, value2, "urlMap");
            return (Criteria) this;
        }

        public Criteria andUrlMapNotBetween(String value1, String value2) {
            addCriterion("url_map not between", value1, value2, "urlMap");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}