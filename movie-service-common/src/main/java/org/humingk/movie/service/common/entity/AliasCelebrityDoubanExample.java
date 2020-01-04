package org.humingk.movie.service.common.entity;

import java.util.ArrayList;
import java.util.List;

public class AliasCelebrityDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AliasCelebrityDoubanExample() {
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

        public Criteria andNameAliasIsNull() {
            addCriterion("name_alias is null");
            return (Criteria) this;
        }

        public Criteria andNameAliasIsNotNull() {
            addCriterion("name_alias is not null");
            return (Criteria) this;
        }

        public Criteria andNameAliasEqualTo(String value) {
            addCriterion("name_alias =", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasNotEqualTo(String value) {
            addCriterion("name_alias <>", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasGreaterThan(String value) {
            addCriterion("name_alias >", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasGreaterThanOrEqualTo(String value) {
            addCriterion("name_alias >=", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasLessThan(String value) {
            addCriterion("name_alias <", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasLessThanOrEqualTo(String value) {
            addCriterion("name_alias <=", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasLike(String value) {
            addCriterion("name_alias like", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasNotLike(String value) {
            addCriterion("name_alias not like", value, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasIn(List<String> values) {
            addCriterion("name_alias in", values, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasNotIn(List<String> values) {
            addCriterion("name_alias not in", values, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasBetween(String value1, String value2) {
            addCriterion("name_alias between", value1, value2, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andNameAliasNotBetween(String value1, String value2) {
            addCriterion("name_alias not between", value1, value2, "nameAlias");
            return (Criteria) this;
        }

        public Criteria andIsNikenameIsNull() {
            addCriterion("is_nikename is null");
            return (Criteria) this;
        }

        public Criteria andIsNikenameIsNotNull() {
            addCriterion("is_nikename is not null");
            return (Criteria) this;
        }

        public Criteria andIsNikenameEqualTo(Boolean value) {
            addCriterion("is_nikename =", value, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameNotEqualTo(Boolean value) {
            addCriterion("is_nikename <>", value, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameGreaterThan(Boolean value) {
            addCriterion("is_nikename >", value, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_nikename >=", value, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameLessThan(Boolean value) {
            addCriterion("is_nikename <", value, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameLessThanOrEqualTo(Boolean value) {
            addCriterion("is_nikename <=", value, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameIn(List<Boolean> values) {
            addCriterion("is_nikename in", values, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameNotIn(List<Boolean> values) {
            addCriterion("is_nikename not in", values, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameBetween(Boolean value1, Boolean value2) {
            addCriterion("is_nikename between", value1, value2, "isNikename");
            return (Criteria) this;
        }

        public Criteria andIsNikenameNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_nikename not between", value1, value2, "isNikename");
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