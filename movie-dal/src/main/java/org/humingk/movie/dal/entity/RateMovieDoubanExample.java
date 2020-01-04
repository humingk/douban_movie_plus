package org.humingk.movie.dal.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RateMovieDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RateMovieDoubanExample() {
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andVoteIsNull() {
            addCriterion("vote is null");
            return (Criteria) this;
        }

        public Criteria andVoteIsNotNull() {
            addCriterion("vote is not null");
            return (Criteria) this;
        }

        public Criteria andVoteEqualTo(Integer value) {
            addCriterion("vote =", value, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteNotEqualTo(Integer value) {
            addCriterion("vote <>", value, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteGreaterThan(Integer value) {
            addCriterion("vote >", value, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("vote >=", value, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteLessThan(Integer value) {
            addCriterion("vote <", value, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteLessThanOrEqualTo(Integer value) {
            addCriterion("vote <=", value, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteIn(List<Integer> values) {
            addCriterion("vote in", values, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteNotIn(List<Integer> values) {
            addCriterion("vote not in", values, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteBetween(Integer value1, Integer value2) {
            addCriterion("vote between", value1, value2, "vote");
            return (Criteria) this;
        }

        public Criteria andVoteNotBetween(Integer value1, Integer value2) {
            addCriterion("vote not between", value1, value2, "vote");
            return (Criteria) this;
        }

        public Criteria andScore5IsNull() {
            addCriterion("score5 is null");
            return (Criteria) this;
        }

        public Criteria andScore5IsNotNull() {
            addCriterion("score5 is not null");
            return (Criteria) this;
        }

        public Criteria andScore5EqualTo(BigDecimal value) {
            addCriterion("score5 =", value, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5NotEqualTo(BigDecimal value) {
            addCriterion("score5 <>", value, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5GreaterThan(BigDecimal value) {
            addCriterion("score5 >", value, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score5 >=", value, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5LessThan(BigDecimal value) {
            addCriterion("score5 <", value, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("score5 <=", value, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5In(List<BigDecimal> values) {
            addCriterion("score5 in", values, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5NotIn(List<BigDecimal> values) {
            addCriterion("score5 not in", values, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("score5 between", value1, value2, "score5");
            return (Criteria) this;
        }

        public Criteria andScore5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score5 not between", value1, value2, "score5");
            return (Criteria) this;
        }

        public Criteria andScore4IsNull() {
            addCriterion("score4 is null");
            return (Criteria) this;
        }

        public Criteria andScore4IsNotNull() {
            addCriterion("score4 is not null");
            return (Criteria) this;
        }

        public Criteria andScore4EqualTo(BigDecimal value) {
            addCriterion("score4 =", value, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4NotEqualTo(BigDecimal value) {
            addCriterion("score4 <>", value, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4GreaterThan(BigDecimal value) {
            addCriterion("score4 >", value, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score4 >=", value, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4LessThan(BigDecimal value) {
            addCriterion("score4 <", value, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("score4 <=", value, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4In(List<BigDecimal> values) {
            addCriterion("score4 in", values, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4NotIn(List<BigDecimal> values) {
            addCriterion("score4 not in", values, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("score4 between", value1, value2, "score4");
            return (Criteria) this;
        }

        public Criteria andScore4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score4 not between", value1, value2, "score4");
            return (Criteria) this;
        }

        public Criteria andScore3IsNull() {
            addCriterion("score3 is null");
            return (Criteria) this;
        }

        public Criteria andScore3IsNotNull() {
            addCriterion("score3 is not null");
            return (Criteria) this;
        }

        public Criteria andScore3EqualTo(BigDecimal value) {
            addCriterion("score3 =", value, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3NotEqualTo(BigDecimal value) {
            addCriterion("score3 <>", value, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3GreaterThan(BigDecimal value) {
            addCriterion("score3 >", value, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score3 >=", value, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3LessThan(BigDecimal value) {
            addCriterion("score3 <", value, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("score3 <=", value, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3In(List<BigDecimal> values) {
            addCriterion("score3 in", values, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3NotIn(List<BigDecimal> values) {
            addCriterion("score3 not in", values, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("score3 between", value1, value2, "score3");
            return (Criteria) this;
        }

        public Criteria andScore3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score3 not between", value1, value2, "score3");
            return (Criteria) this;
        }

        public Criteria andScore2IsNull() {
            addCriterion("score2 is null");
            return (Criteria) this;
        }

        public Criteria andScore2IsNotNull() {
            addCriterion("score2 is not null");
            return (Criteria) this;
        }

        public Criteria andScore2EqualTo(BigDecimal value) {
            addCriterion("score2 =", value, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2NotEqualTo(BigDecimal value) {
            addCriterion("score2 <>", value, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2GreaterThan(BigDecimal value) {
            addCriterion("score2 >", value, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score2 >=", value, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2LessThan(BigDecimal value) {
            addCriterion("score2 <", value, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("score2 <=", value, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2In(List<BigDecimal> values) {
            addCriterion("score2 in", values, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2NotIn(List<BigDecimal> values) {
            addCriterion("score2 not in", values, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("score2 between", value1, value2, "score2");
            return (Criteria) this;
        }

        public Criteria andScore2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score2 not between", value1, value2, "score2");
            return (Criteria) this;
        }

        public Criteria andScore1IsNull() {
            addCriterion("score1 is null");
            return (Criteria) this;
        }

        public Criteria andScore1IsNotNull() {
            addCriterion("score1 is not null");
            return (Criteria) this;
        }

        public Criteria andScore1EqualTo(BigDecimal value) {
            addCriterion("score1 =", value, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1NotEqualTo(BigDecimal value) {
            addCriterion("score1 <>", value, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1GreaterThan(BigDecimal value) {
            addCriterion("score1 >", value, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score1 >=", value, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1LessThan(BigDecimal value) {
            addCriterion("score1 <", value, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("score1 <=", value, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1In(List<BigDecimal> values) {
            addCriterion("score1 in", values, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1NotIn(List<BigDecimal> values) {
            addCriterion("score1 not in", values, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("score1 between", value1, value2, "score1");
            return (Criteria) this;
        }

        public Criteria andScore1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score1 not between", value1, value2, "score1");
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