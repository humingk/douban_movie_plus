package org.humingk.movie.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RateImdbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RateImdbExample() {
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

        public Criteria andImdbScoreIsNull() {
            addCriterion("imdb_score is null");
            return (Criteria) this;
        }

        public Criteria andImdbScoreIsNotNull() {
            addCriterion("imdb_score is not null");
            return (Criteria) this;
        }

        public Criteria andImdbScoreEqualTo(BigDecimal value) {
            addCriterion("imdb_score =", value, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreNotEqualTo(BigDecimal value) {
            addCriterion("imdb_score <>", value, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreGreaterThan(BigDecimal value) {
            addCriterion("imdb_score >", value, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("imdb_score >=", value, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreLessThan(BigDecimal value) {
            addCriterion("imdb_score <", value, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("imdb_score <=", value, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreIn(List<BigDecimal> values) {
            addCriterion("imdb_score in", values, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreNotIn(List<BigDecimal> values) {
            addCriterion("imdb_score not in", values, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("imdb_score between", value1, value2, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("imdb_score not between", value1, value2, "imdbScore");
            return (Criteria) this;
        }

        public Criteria andImdbVoteIsNull() {
            addCriterion("imdb_vote is null");
            return (Criteria) this;
        }

        public Criteria andImdbVoteIsNotNull() {
            addCriterion("imdb_vote is not null");
            return (Criteria) this;
        }

        public Criteria andImdbVoteEqualTo(Integer value) {
            addCriterion("imdb_vote =", value, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteNotEqualTo(Integer value) {
            addCriterion("imdb_vote <>", value, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteGreaterThan(Integer value) {
            addCriterion("imdb_vote >", value, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("imdb_vote >=", value, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteLessThan(Integer value) {
            addCriterion("imdb_vote <", value, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteLessThanOrEqualTo(Integer value) {
            addCriterion("imdb_vote <=", value, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteIn(List<Integer> values) {
            addCriterion("imdb_vote in", values, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteNotIn(List<Integer> values) {
            addCriterion("imdb_vote not in", values, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteBetween(Integer value1, Integer value2) {
            addCriterion("imdb_vote between", value1, value2, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andImdbVoteNotBetween(Integer value1, Integer value2) {
            addCriterion("imdb_vote not between", value1, value2, "imdbVote");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreIsNull() {
            addCriterion("tomato_score is null");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreIsNotNull() {
            addCriterion("tomato_score is not null");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreEqualTo(BigDecimal value) {
            addCriterion("tomato_score =", value, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreNotEqualTo(BigDecimal value) {
            addCriterion("tomato_score <>", value, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreGreaterThan(BigDecimal value) {
            addCriterion("tomato_score >", value, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tomato_score >=", value, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreLessThan(BigDecimal value) {
            addCriterion("tomato_score <", value, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tomato_score <=", value, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreIn(List<BigDecimal> values) {
            addCriterion("tomato_score in", values, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreNotIn(List<BigDecimal> values) {
            addCriterion("tomato_score not in", values, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tomato_score between", value1, value2, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andTomatoScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tomato_score not between", value1, value2, "tomatoScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreIsNull() {
            addCriterion("mtc_score is null");
            return (Criteria) this;
        }

        public Criteria andMtcScoreIsNotNull() {
            addCriterion("mtc_score is not null");
            return (Criteria) this;
        }

        public Criteria andMtcScoreEqualTo(BigDecimal value) {
            addCriterion("mtc_score =", value, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreNotEqualTo(BigDecimal value) {
            addCriterion("mtc_score <>", value, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreGreaterThan(BigDecimal value) {
            addCriterion("mtc_score >", value, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mtc_score >=", value, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreLessThan(BigDecimal value) {
            addCriterion("mtc_score <", value, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mtc_score <=", value, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreIn(List<BigDecimal> values) {
            addCriterion("mtc_score in", values, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreNotIn(List<BigDecimal> values) {
            addCriterion("mtc_score not in", values, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mtc_score between", value1, value2, "mtcScore");
            return (Criteria) this;
        }

        public Criteria andMtcScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mtc_score not between", value1, value2, "mtcScore");
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