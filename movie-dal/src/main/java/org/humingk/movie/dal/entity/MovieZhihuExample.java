package org.humingk.movie.dal.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MovieZhihuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieZhihuExample() {
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

        public Criteria andIdMovieDoubanIsNull() {
            addCriterion("id_movie_douban is null");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanIsNotNull() {
            addCriterion("id_movie_douban is not null");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanEqualTo(Long value) {
            addCriterion("id_movie_douban =", value, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanNotEqualTo(Long value) {
            addCriterion("id_movie_douban <>", value, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanGreaterThan(Long value) {
            addCriterion("id_movie_douban >", value, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanGreaterThanOrEqualTo(Long value) {
            addCriterion("id_movie_douban >=", value, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanLessThan(Long value) {
            addCriterion("id_movie_douban <", value, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanLessThanOrEqualTo(Long value) {
            addCriterion("id_movie_douban <=", value, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanIn(List<Long> values) {
            addCriterion("id_movie_douban in", values, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanNotIn(List<Long> values) {
            addCriterion("id_movie_douban not in", values, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanBetween(Long value1, Long value2) {
            addCriterion("id_movie_douban between", value1, value2, "idMovieDouban");
            return (Criteria) this;
        }

        public Criteria andIdMovieDoubanNotBetween(Long value1, Long value2) {
            addCriterion("id_movie_douban not between", value1, value2, "idMovieDouban");
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

        public Criteria andZhihuScoreIsNull() {
            addCriterion("zhihu_score is null");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreIsNotNull() {
            addCriterion("zhihu_score is not null");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreEqualTo(BigDecimal value) {
            addCriterion("zhihu_score =", value, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreNotEqualTo(BigDecimal value) {
            addCriterion("zhihu_score <>", value, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreGreaterThan(BigDecimal value) {
            addCriterion("zhihu_score >", value, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("zhihu_score >=", value, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreLessThan(BigDecimal value) {
            addCriterion("zhihu_score <", value, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("zhihu_score <=", value, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreIn(List<BigDecimal> values) {
            addCriterion("zhihu_score in", values, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreNotIn(List<BigDecimal> values) {
            addCriterion("zhihu_score not in", values, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhihu_score between", value1, value2, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("zhihu_score not between", value1, value2, "zhihuScore");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteIsNull() {
            addCriterion("zhihu_vote is null");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteIsNotNull() {
            addCriterion("zhihu_vote is not null");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteEqualTo(Integer value) {
            addCriterion("zhihu_vote =", value, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteNotEqualTo(Integer value) {
            addCriterion("zhihu_vote <>", value, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteGreaterThan(Integer value) {
            addCriterion("zhihu_vote >", value, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("zhihu_vote >=", value, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteLessThan(Integer value) {
            addCriterion("zhihu_vote <", value, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteLessThanOrEqualTo(Integer value) {
            addCriterion("zhihu_vote <=", value, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteIn(List<Integer> values) {
            addCriterion("zhihu_vote in", values, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteNotIn(List<Integer> values) {
            addCriterion("zhihu_vote not in", values, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteBetween(Integer value1, Integer value2) {
            addCriterion("zhihu_vote between", value1, value2, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andZhihuVoteNotBetween(Integer value1, Integer value2) {
            addCriterion("zhihu_vote not between", value1, value2, "zhihuVote");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreIsNull() {
            addCriterion("maoyan_score is null");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreIsNotNull() {
            addCriterion("maoyan_score is not null");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreEqualTo(BigDecimal value) {
            addCriterion("maoyan_score =", value, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreNotEqualTo(BigDecimal value) {
            addCriterion("maoyan_score <>", value, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreGreaterThan(BigDecimal value) {
            addCriterion("maoyan_score >", value, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("maoyan_score >=", value, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreLessThan(BigDecimal value) {
            addCriterion("maoyan_score <", value, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("maoyan_score <=", value, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreIn(List<BigDecimal> values) {
            addCriterion("maoyan_score in", values, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreNotIn(List<BigDecimal> values) {
            addCriterion("maoyan_score not in", values, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maoyan_score between", value1, value2, "maoyanScore");
            return (Criteria) this;
        }

        public Criteria andMaoyanScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("maoyan_score not between", value1, value2, "maoyanScore");
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