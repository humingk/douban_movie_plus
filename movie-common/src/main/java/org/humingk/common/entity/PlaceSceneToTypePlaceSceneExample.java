package org.humingk.common.entity;

import java.util.ArrayList;
import java.util.List;

public class PlaceSceneToTypePlaceSceneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PlaceSceneToTypePlaceSceneExample() {
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

        public Criteria andIdPlaceSceneIsNull() {
            addCriterion("id_place_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneIsNotNull() {
            addCriterion("id_place_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneEqualTo(Long value) {
            addCriterion("id_place_scene =", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneNotEqualTo(Long value) {
            addCriterion("id_place_scene <>", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneGreaterThan(Long value) {
            addCriterion("id_place_scene >", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneGreaterThanOrEqualTo(Long value) {
            addCriterion("id_place_scene >=", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneLessThan(Long value) {
            addCriterion("id_place_scene <", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneLessThanOrEqualTo(Long value) {
            addCriterion("id_place_scene <=", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneIn(List<Long> values) {
            addCriterion("id_place_scene in", values, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneNotIn(List<Long> values) {
            addCriterion("id_place_scene not in", values, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneBetween(Long value1, Long value2) {
            addCriterion("id_place_scene between", value1, value2, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneNotBetween(Long value1, Long value2) {
            addCriterion("id_place_scene not between", value1, value2, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneIsNull() {
            addCriterion("id_type_place_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneIsNotNull() {
            addCriterion("id_type_place_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneEqualTo(Byte value) {
            addCriterion("id_type_place_scene =", value, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneNotEqualTo(Byte value) {
            addCriterion("id_type_place_scene <>", value, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneGreaterThan(Byte value) {
            addCriterion("id_type_place_scene >", value, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneGreaterThanOrEqualTo(Byte value) {
            addCriterion("id_type_place_scene >=", value, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneLessThan(Byte value) {
            addCriterion("id_type_place_scene <", value, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneLessThanOrEqualTo(Byte value) {
            addCriterion("id_type_place_scene <=", value, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneIn(List<Byte> values) {
            addCriterion("id_type_place_scene in", values, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneNotIn(List<Byte> values) {
            addCriterion("id_type_place_scene not in", values, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneBetween(Byte value1, Byte value2) {
            addCriterion("id_type_place_scene between", value1, value2, "idTypePlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdTypePlaceSceneNotBetween(Byte value1, Byte value2) {
            addCriterion("id_type_place_scene not between", value1, value2, "idTypePlaceScene");
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