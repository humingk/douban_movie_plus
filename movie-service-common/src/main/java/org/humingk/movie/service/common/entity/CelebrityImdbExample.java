package org.humingk.movie.service.common.entity;

import java.util.ArrayList;
import java.util.List;

public class CelebrityImdbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CelebrityImdbExample() {
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

        public Criteria andBirthYearIsNull() {
            addCriterion("birth_year is null");
            return (Criteria) this;
        }

        public Criteria andBirthYearIsNotNull() {
            addCriterion("birth_year is not null");
            return (Criteria) this;
        }

        public Criteria andBirthYearEqualTo(Short value) {
            addCriterion("birth_year =", value, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearNotEqualTo(Short value) {
            addCriterion("birth_year <>", value, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearGreaterThan(Short value) {
            addCriterion("birth_year >", value, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearGreaterThanOrEqualTo(Short value) {
            addCriterion("birth_year >=", value, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearLessThan(Short value) {
            addCriterion("birth_year <", value, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearLessThanOrEqualTo(Short value) {
            addCriterion("birth_year <=", value, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearIn(List<Short> values) {
            addCriterion("birth_year in", values, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearNotIn(List<Short> values) {
            addCriterion("birth_year not in", values, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearBetween(Short value1, Short value2) {
            addCriterion("birth_year between", value1, value2, "birthYear");
            return (Criteria) this;
        }

        public Criteria andBirthYearNotBetween(Short value1, Short value2) {
            addCriterion("birth_year not between", value1, value2, "birthYear");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanIsNull() {
            addCriterion("id_celebrity_douban is null");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanIsNotNull() {
            addCriterion("id_celebrity_douban is not null");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanEqualTo(Long value) {
            addCriterion("id_celebrity_douban =", value, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanNotEqualTo(Long value) {
            addCriterion("id_celebrity_douban <>", value, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanGreaterThan(Long value) {
            addCriterion("id_celebrity_douban >", value, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanGreaterThanOrEqualTo(Long value) {
            addCriterion("id_celebrity_douban >=", value, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanLessThan(Long value) {
            addCriterion("id_celebrity_douban <", value, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanLessThanOrEqualTo(Long value) {
            addCriterion("id_celebrity_douban <=", value, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanIn(List<Long> values) {
            addCriterion("id_celebrity_douban in", values, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanNotIn(List<Long> values) {
            addCriterion("id_celebrity_douban not in", values, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanBetween(Long value1, Long value2) {
            addCriterion("id_celebrity_douban between", value1, value2, "idCelebrityDouban");
            return (Criteria) this;
        }

        public Criteria andIdCelebrityDoubanNotBetween(Long value1, Long value2) {
            addCriterion("id_celebrity_douban not between", value1, value2, "idCelebrityDouban");
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