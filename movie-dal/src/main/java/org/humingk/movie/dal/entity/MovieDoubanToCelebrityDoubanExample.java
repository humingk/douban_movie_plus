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
public class MovieDoubanToCelebrityDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieDoubanToCelebrityDoubanExample() {
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

        public Criteria andIdProfessionIsNull() {
            addCriterion("id_profession is null");
            return (Criteria) this;
        }

        public Criteria andIdProfessionIsNotNull() {
            addCriterion("id_profession is not null");
            return (Criteria) this;
        }

        public Criteria andIdProfessionEqualTo(Byte value) {
            addCriterion("id_profession =", value, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionNotEqualTo(Byte value) {
            addCriterion("id_profession <>", value, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionGreaterThan(Byte value) {
            addCriterion("id_profession >", value, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionGreaterThanOrEqualTo(Byte value) {
            addCriterion("id_profession >=", value, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionLessThan(Byte value) {
            addCriterion("id_profession <", value, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionLessThanOrEqualTo(Byte value) {
            addCriterion("id_profession <=", value, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionIn(List<Byte> values) {
            addCriterion("id_profession in", values, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionNotIn(List<Byte> values) {
            addCriterion("id_profession not in", values, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionBetween(Byte value1, Byte value2) {
            addCriterion("id_profession between", value1, value2, "idProfession");
            return (Criteria) this;
        }

        public Criteria andIdProfessionNotBetween(Byte value1, Byte value2) {
            addCriterion("id_profession not between", value1, value2, "idProfession");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Short value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Short value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Short value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Short value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Short value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Short value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Short> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Short> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Short value1, Short value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Short value1, Short value2) {
            addCriterion("sort not between", value1, value2, "sort");
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