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
public class UserDoubanToClassicDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDoubanToClassicDoubanExample() {
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

        public Criteria andIdUserDoubanIsNull() {
            addCriterion("id_user_douban is null");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanIsNotNull() {
            addCriterion("id_user_douban is not null");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanEqualTo(String value) {
            addCriterion("id_user_douban =", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanNotEqualTo(String value) {
            addCriterion("id_user_douban <>", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanGreaterThan(String value) {
            addCriterion("id_user_douban >", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanGreaterThanOrEqualTo(String value) {
            addCriterion("id_user_douban >=", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanLessThan(String value) {
            addCriterion("id_user_douban <", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanLessThanOrEqualTo(String value) {
            addCriterion("id_user_douban <=", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanLike(String value) {
            addCriterion("id_user_douban like", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanNotLike(String value) {
            addCriterion("id_user_douban not like", value, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanIn(List<String> values) {
            addCriterion("id_user_douban in", values, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanNotIn(List<String> values) {
            addCriterion("id_user_douban not in", values, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanBetween(String value1, String value2) {
            addCriterion("id_user_douban between", value1, value2, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdUserDoubanNotBetween(String value1, String value2) {
            addCriterion("id_user_douban not between", value1, value2, "idUserDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanIsNull() {
            addCriterion("id_classic_douban is null");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanIsNotNull() {
            addCriterion("id_classic_douban is not null");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanEqualTo(String value) {
            addCriterion("id_classic_douban =", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanNotEqualTo(String value) {
            addCriterion("id_classic_douban <>", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanGreaterThan(String value) {
            addCriterion("id_classic_douban >", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanGreaterThanOrEqualTo(String value) {
            addCriterion("id_classic_douban >=", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanLessThan(String value) {
            addCriterion("id_classic_douban <", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanLessThanOrEqualTo(String value) {
            addCriterion("id_classic_douban <=", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanLike(String value) {
            addCriterion("id_classic_douban like", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanNotLike(String value) {
            addCriterion("id_classic_douban not like", value, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanIn(List<String> values) {
            addCriterion("id_classic_douban in", values, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanNotIn(List<String> values) {
            addCriterion("id_classic_douban not in", values, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanBetween(String value1, String value2) {
            addCriterion("id_classic_douban between", value1, value2, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andIdClassicDoubanNotBetween(String value1, String value2) {
            addCriterion("id_classic_douban not between", value1, value2, "idClassicDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanIsNull() {
            addCriterion("name_zh_user_douban is null");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanIsNotNull() {
            addCriterion("name_zh_user_douban is not null");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanEqualTo(String value) {
            addCriterion("name_zh_user_douban =", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanNotEqualTo(String value) {
            addCriterion("name_zh_user_douban <>", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanGreaterThan(String value) {
            addCriterion("name_zh_user_douban >", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanGreaterThanOrEqualTo(String value) {
            addCriterion("name_zh_user_douban >=", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanLessThan(String value) {
            addCriterion("name_zh_user_douban <", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanLessThanOrEqualTo(String value) {
            addCriterion("name_zh_user_douban <=", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanLike(String value) {
            addCriterion("name_zh_user_douban like", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanNotLike(String value) {
            addCriterion("name_zh_user_douban not like", value, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanIn(List<String> values) {
            addCriterion("name_zh_user_douban in", values, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanNotIn(List<String> values) {
            addCriterion("name_zh_user_douban not in", values, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanBetween(String value1, String value2) {
            addCriterion("name_zh_user_douban between", value1, value2, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andNameZhUserDoubanNotBetween(String value1, String value2) {
            addCriterion("name_zh_user_douban not between", value1, value2, "nameZhUserDouban");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeIsNull() {
            addCriterion("record_datetime is null");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeIsNotNull() {
            addCriterion("record_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeEqualTo(Long value) {
            addCriterion("record_datetime =", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeNotEqualTo(Long value) {
            addCriterion("record_datetime <>", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeGreaterThan(Long value) {
            addCriterion("record_datetime >", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("record_datetime >=", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeLessThan(Long value) {
            addCriterion("record_datetime <", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeLessThanOrEqualTo(Long value) {
            addCriterion("record_datetime <=", value, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeIn(List<Long> values) {
            addCriterion("record_datetime in", values, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeNotIn(List<Long> values) {
            addCriterion("record_datetime not in", values, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeBetween(Long value1, Long value2) {
            addCriterion("record_datetime between", value1, value2, "recordDatetime");
            return (Criteria) this;
        }

        public Criteria andRecordDatetimeNotBetween(Long value1, Long value2) {
            addCriterion("record_datetime not between", value1, value2, "recordDatetime");
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