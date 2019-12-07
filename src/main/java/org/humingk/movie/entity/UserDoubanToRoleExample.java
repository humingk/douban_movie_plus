package org.humingk.movie.entity;

import java.util.ArrayList;
import java.util.List;

public class UserDoubanToRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDoubanToRoleExample() {
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

        public Criteria andIdRoleIsNull() {
            addCriterion("id_role is null");
            return (Criteria) this;
        }

        public Criteria andIdRoleIsNotNull() {
            addCriterion("id_role is not null");
            return (Criteria) this;
        }

        public Criteria andIdRoleEqualTo(Byte value) {
            addCriterion("id_role =", value, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleNotEqualTo(Byte value) {
            addCriterion("id_role <>", value, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleGreaterThan(Byte value) {
            addCriterion("id_role >", value, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("id_role >=", value, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleLessThan(Byte value) {
            addCriterion("id_role <", value, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleLessThanOrEqualTo(Byte value) {
            addCriterion("id_role <=", value, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleIn(List<Byte> values) {
            addCriterion("id_role in", values, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleNotIn(List<Byte> values) {
            addCriterion("id_role not in", values, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleBetween(Byte value1, Byte value2) {
            addCriterion("id_role between", value1, value2, "idRole");
            return (Criteria) this;
        }

        public Criteria andIdRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("id_role not between", value1, value2, "idRole");
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