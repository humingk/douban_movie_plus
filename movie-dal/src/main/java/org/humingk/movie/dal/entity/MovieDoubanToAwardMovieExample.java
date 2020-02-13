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
public class MovieDoubanToAwardMovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieDoubanToAwardMovieExample() {
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
        clear();
        return createCriteriaInternal();
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

        public Criteria andIdAwardMovieIsNull() {
            addCriterion("id_award_movie is null");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieIsNotNull() {
            addCriterion("id_award_movie is not null");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieEqualTo(String value) {
            addCriterion("id_award_movie =", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieNotEqualTo(String value) {
            addCriterion("id_award_movie <>", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieGreaterThan(String value) {
            addCriterion("id_award_movie >", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieGreaterThanOrEqualTo(String value) {
            addCriterion("id_award_movie >=", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieLessThan(String value) {
            addCriterion("id_award_movie <", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieLessThanOrEqualTo(String value) {
            addCriterion("id_award_movie <=", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieLike(String value) {
            addCriterion("id_award_movie like", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieNotLike(String value) {
            addCriterion("id_award_movie not like", value, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieIn(List<String> values) {
            addCriterion("id_award_movie in", values, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieNotIn(List<String> values) {
            addCriterion("id_award_movie not in", values, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieBetween(String value1, String value2) {
            addCriterion("id_award_movie between", value1, value2, "idAwardMovie");
            return (Criteria) this;
        }

        public Criteria andIdAwardMovieNotBetween(String value1, String value2) {
            addCriterion("id_award_movie not between", value1, value2, "idAwardMovie");
            return (Criteria) this;
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

        public Criteria andTypeAwardIsNull() {
            addCriterion("type_award is null");
            return (Criteria) this;
        }

        public Criteria andTypeAwardIsNotNull() {
            addCriterion("type_award is not null");
            return (Criteria) this;
        }

        public Criteria andTypeAwardEqualTo(String value) {
            addCriterion("type_award =", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardNotEqualTo(String value) {
            addCriterion("type_award <>", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardGreaterThan(String value) {
            addCriterion("type_award >", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardGreaterThanOrEqualTo(String value) {
            addCriterion("type_award >=", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardLessThan(String value) {
            addCriterion("type_award <", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardLessThanOrEqualTo(String value) {
            addCriterion("type_award <=", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardLike(String value) {
            addCriterion("type_award like", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardNotLike(String value) {
            addCriterion("type_award not like", value, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardIn(List<String> values) {
            addCriterion("type_award in", values, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardNotIn(List<String> values) {
            addCriterion("type_award not in", values, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardBetween(String value1, String value2) {
            addCriterion("type_award between", value1, value2, "typeAward");
            return (Criteria) this;
        }

        public Criteria andTypeAwardNotBetween(String value1, String value2) {
            addCriterion("type_award not between", value1, value2, "typeAward");
            return (Criteria) this;
        }

        public Criteria andAwardThIsNull() {
            addCriterion("award_th is null");
            return (Criteria) this;
        }

        public Criteria andAwardThIsNotNull() {
            addCriterion("award_th is not null");
            return (Criteria) this;
        }

        public Criteria andAwardThEqualTo(Short value) {
            addCriterion("award_th =", value, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThNotEqualTo(Short value) {
            addCriterion("award_th <>", value, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThGreaterThan(Short value) {
            addCriterion("award_th >", value, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThGreaterThanOrEqualTo(Short value) {
            addCriterion("award_th >=", value, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThLessThan(Short value) {
            addCriterion("award_th <", value, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThLessThanOrEqualTo(Short value) {
            addCriterion("award_th <=", value, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThIn(List<Short> values) {
            addCriterion("award_th in", values, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThNotIn(List<Short> values) {
            addCriterion("award_th not in", values, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThBetween(Short value1, Short value2) {
            addCriterion("award_th between", value1, value2, "awardTh");
            return (Criteria) this;
        }

        public Criteria andAwardThNotBetween(Short value1, Short value2) {
            addCriterion("award_th not between", value1, value2, "awardTh");
            return (Criteria) this;
        }

        public Criteria andIsNominatedIsNull() {
            addCriterion("is_nominated is null");
            return (Criteria) this;
        }

        public Criteria andIsNominatedIsNotNull() {
            addCriterion("is_nominated is not null");
            return (Criteria) this;
        }

        public Criteria andIsNominatedEqualTo(Boolean value) {
            addCriterion("is_nominated =", value, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedNotEqualTo(Boolean value) {
            addCriterion("is_nominated <>", value, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedGreaterThan(Boolean value) {
            addCriterion("is_nominated >", value, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_nominated >=", value, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedLessThan(Boolean value) {
            addCriterion("is_nominated <", value, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_nominated <=", value, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedIn(List<Boolean> values) {
            addCriterion("is_nominated in", values, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedNotIn(List<Boolean> values) {
            addCriterion("is_nominated not in", values, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_nominated between", value1, value2, "isNominated");
            return (Criteria) this;
        }

        public Criteria andIsNominatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_nominated not between", value1, value2, "isNominated");
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