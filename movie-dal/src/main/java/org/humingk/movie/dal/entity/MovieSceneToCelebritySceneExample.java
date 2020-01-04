package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class MovieSceneToCelebritySceneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieSceneToCelebritySceneExample() {
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

        public Criteria andIdMovieSceneIsNull() {
            addCriterion("id_movie_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneIsNotNull() {
            addCriterion("id_movie_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneEqualTo(Long value) {
            addCriterion("id_movie_scene =", value, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneNotEqualTo(Long value) {
            addCriterion("id_movie_scene <>", value, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneGreaterThan(Long value) {
            addCriterion("id_movie_scene >", value, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneGreaterThanOrEqualTo(Long value) {
            addCriterion("id_movie_scene >=", value, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneLessThan(Long value) {
            addCriterion("id_movie_scene <", value, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneLessThanOrEqualTo(Long value) {
            addCriterion("id_movie_scene <=", value, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneIn(List<Long> values) {
            addCriterion("id_movie_scene in", values, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneNotIn(List<Long> values) {
            addCriterion("id_movie_scene not in", values, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneBetween(Long value1, Long value2) {
            addCriterion("id_movie_scene between", value1, value2, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdMovieSceneNotBetween(Long value1, Long value2) {
            addCriterion("id_movie_scene not between", value1, value2, "idMovieScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneIsNull() {
            addCriterion("id_celebrity_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneIsNotNull() {
            addCriterion("id_celebrity_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneEqualTo(Long value) {
            addCriterion("id_celebrity_scene =", value, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneNotEqualTo(Long value) {
            addCriterion("id_celebrity_scene <>", value, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneGreaterThan(Long value) {
            addCriterion("id_celebrity_scene >", value, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneGreaterThanOrEqualTo(Long value) {
            addCriterion("id_celebrity_scene >=", value, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneLessThan(Long value) {
            addCriterion("id_celebrity_scene <", value, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneLessThanOrEqualTo(Long value) {
            addCriterion("id_celebrity_scene <=", value, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneIn(List<Long> values) {
            addCriterion("id_celebrity_scene in", values, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneNotIn(List<Long> values) {
            addCriterion("id_celebrity_scene not in", values, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneBetween(Long value1, Long value2) {
            addCriterion("id_celebrity_scene between", value1, value2, "idCelebrityScene");
            return (Criteria) this;
        }

        public Criteria andIdCelebritySceneNotBetween(Long value1, Long value2) {
            addCriterion("id_celebrity_scene not between", value1, value2, "idCelebrityScene");
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