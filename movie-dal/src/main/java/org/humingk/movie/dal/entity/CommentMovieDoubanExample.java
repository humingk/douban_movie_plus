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
public class CommentMovieDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentMovieDoubanExample() {
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

        public Criteria andAgreeVoteIsNull() {
            addCriterion("agree_vote is null");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteIsNotNull() {
            addCriterion("agree_vote is not null");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteEqualTo(Short value) {
            addCriterion("agree_vote =", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteNotEqualTo(Short value) {
            addCriterion("agree_vote <>", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteGreaterThan(Short value) {
            addCriterion("agree_vote >", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteGreaterThanOrEqualTo(Short value) {
            addCriterion("agree_vote >=", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteLessThan(Short value) {
            addCriterion("agree_vote <", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteLessThanOrEqualTo(Short value) {
            addCriterion("agree_vote <=", value, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteIn(List<Short> values) {
            addCriterion("agree_vote in", values, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteNotIn(List<Short> values) {
            addCriterion("agree_vote not in", values, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteBetween(Short value1, Short value2) {
            addCriterion("agree_vote between", value1, value2, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andAgreeVoteNotBetween(Short value1, Short value2) {
            addCriterion("agree_vote not between", value1, value2, "agreeVote");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Long value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Long value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Long value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Long value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Long value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Long value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Long> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Long> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Long value1, Long value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Long value1, Long value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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