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
public class ClassicDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassicDoubanExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIsNull() {
            addCriterion("happen_time is null");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIsNotNull() {
            addCriterion("happen_time is not null");
            return (Criteria) this;
        }

        public Criteria andHappenTimeEqualTo(Integer value) {
            addCriterion("happen_time =", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotEqualTo(Integer value) {
            addCriterion("happen_time <>", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeGreaterThan(Integer value) {
            addCriterion("happen_time >", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("happen_time >=", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeLessThan(Integer value) {
            addCriterion("happen_time <", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeLessThanOrEqualTo(Integer value) {
            addCriterion("happen_time <=", value, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeIn(List<Integer> values) {
            addCriterion("happen_time in", values, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotIn(List<Integer> values) {
            addCriterion("happen_time not in", values, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeBetween(Integer value1, Integer value2) {
            addCriterion("happen_time between", value1, value2, "happenTime");
            return (Criteria) this;
        }

        public Criteria andHappenTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("happen_time not between", value1, value2, "happenTime");
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