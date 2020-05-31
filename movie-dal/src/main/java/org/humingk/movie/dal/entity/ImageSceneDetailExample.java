package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

/** @author humingk */
@Repository
@Data
@AllArgsConstructor
public class ImageSceneDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImageSceneDetailExample() {
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

    public Criteria start() {
        oredCriteria = new ArrayList<>();
        clear();
        return createCriteria();
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

        public Criteria andIdSceneDetailIsNull() {
            addCriterion("id_scene_detail is null");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailIsNotNull() {
            addCriterion("id_scene_detail is not null");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailEqualTo(Long value) {
            addCriterion("id_scene_detail =", value, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailNotEqualTo(Long value) {
            addCriterion("id_scene_detail <>", value, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailGreaterThan(Long value) {
            addCriterion("id_scene_detail >", value, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailGreaterThanOrEqualTo(Long value) {
            addCriterion("id_scene_detail >=", value, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailLessThan(Long value) {
            addCriterion("id_scene_detail <", value, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailLessThanOrEqualTo(Long value) {
            addCriterion("id_scene_detail <=", value, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailIn(List<Long> values) {
            addCriterion("id_scene_detail in", values, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailNotIn(List<Long> values) {
            addCriterion("id_scene_detail not in", values, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailBetween(Long value1, Long value2) {
            addCriterion("id_scene_detail between", value1, value2, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andIdSceneDetailNotBetween(Long value1, Long value2) {
            addCriterion("id_scene_detail not between", value1, value2, "idSceneDetail");
            return (Criteria) this;
        }

        public Criteria andUrlImageIsNull() {
            addCriterion("url_image is null");
            return (Criteria) this;
        }

        public Criteria andUrlImageIsNotNull() {
            addCriterion("url_image is not null");
            return (Criteria) this;
        }

        public Criteria andUrlImageEqualTo(String value) {
            addCriterion("url_image =", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageNotEqualTo(String value) {
            addCriterion("url_image <>", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageGreaterThan(String value) {
            addCriterion("url_image >", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageGreaterThanOrEqualTo(String value) {
            addCriterion("url_image >=", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageLessThan(String value) {
            addCriterion("url_image <", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageLessThanOrEqualTo(String value) {
            addCriterion("url_image <=", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageLike(String value) {
            addCriterion("url_image like", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageNotLike(String value) {
            addCriterion("url_image not like", value, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageIn(List<String> values) {
            addCriterion("url_image in", values, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageNotIn(List<String> values) {
            addCriterion("url_image not in", values, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageBetween(String value1, String value2) {
            addCriterion("url_image between", value1, value2, "urlImage");
            return (Criteria) this;
        }

        public Criteria andUrlImageNotBetween(String value1, String value2) {
            addCriterion("url_image not between", value1, value2, "urlImage");
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