package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class ReviewMovieDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReviewMovieDoubanExample() {
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

        public Criteria andAgreeVoteIsNull() {
            addCriterion("agree_vote is null");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteIsNotNull() {
            addCriterion("agree_vote is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteEqualTo(Integer value) {
            addCriterion("agree_vote =", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteNotEqualTo(Integer value) {
            addCriterion("agree_vote <>", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteGreaterThan(Integer value) {
            addCriterion("agree_vote >", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("agree_vote >=", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteLessThan(Integer value) {
            addCriterion("agree_vote <", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteLessThanOrEqualTo(Integer value) {
            addCriterion("agree_vote <=", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteIn(List<Integer> values) {
            addCriterion("agree_vote in", values, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteNotIn(List<Integer> values) {
            addCriterion("agree_vote not in", values, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteBetween(Integer value1, Integer value2) {
            addCriterion("agree_vote between", value1, value2, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteNotBetween(Integer value1, Integer value2) {
            addCriterion("agree_vote not between", value1, value2, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteIsNull() {
            addCriterion("against_vote is null");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteIsNotNull() {
            addCriterion("against_vote is not null");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteEqualTo(Integer value) {
            addCriterion("against_vote =", value, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteNotEqualTo(Integer value) {
            addCriterion("against_vote <>", value, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteGreaterThan(Integer value) {
            addCriterion("against_vote >", value, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("against_vote >=", value, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteLessThan(Integer value) {
            addCriterion("against_vote <", value, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteLessThanOrEqualTo(Integer value) {
            addCriterion("against_vote <=", value, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteIn(List<Integer> values) {
            addCriterion("against_vote in", values, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteNotIn(List<Integer> values) {
            addCriterion("against_vote not in", values, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteBetween(Integer value1, Integer value2) {
            addCriterion("against_vote between", value1, value2, "againstVote");
            return (Criteria) this;
        }

        public Criteria andAgainstVoteNotBetween(Integer value1, Integer value2) {
            addCriterion("against_vote not between", value1, value2, "againstVote");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Long value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Long value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Long value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Long value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Long value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Long> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Long> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Long value1, Long value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Long value1, Long value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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