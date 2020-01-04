package org.humingk.movie.service.common.entity;

import java.util.ArrayList;
import java.util.List;

public class SceneExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SceneExample() {
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

        public Criteria andIdPlaceSceneIsNull() {
            addCriterion("id_place_scene is null");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneIsNotNull() {
            addCriterion("id_place_scene is not null");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneEqualTo(Long value) {
            addCriterion("id_place_scene =", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneNotEqualTo(Long value) {
            addCriterion("id_place_scene <>", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneGreaterThan(Long value) {
            addCriterion("id_place_scene >", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneGreaterThanOrEqualTo(Long value) {
            addCriterion("id_place_scene >=", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneLessThan(Long value) {
            addCriterion("id_place_scene <", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneLessThanOrEqualTo(Long value) {
            addCriterion("id_place_scene <=", value, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneIn(List<Long> values) {
            addCriterion("id_place_scene in", values, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneNotIn(List<Long> values) {
            addCriterion("id_place_scene not in", values, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneBetween(Long value1, Long value2) {
            addCriterion("id_place_scene between", value1, value2, "idPlaceScene");
            return (Criteria) this;
        }

        public Criteria andIdPlaceSceneNotBetween(Long value1, Long value2) {
            addCriterion("id_place_scene not between", value1, value2, "idPlaceScene");
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