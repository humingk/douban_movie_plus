package org.humingk.movie.entity;

import java.util.ArrayList;
import java.util.List;

public class ResourceMovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceMovieExample() {
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

        public Criteria andIdMovieImdbIsNull() {
            addCriterion("id_movie_imdb is null");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbIsNotNull() {
            addCriterion("id_movie_imdb is not null");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbEqualTo(Long value) {
            addCriterion("id_movie_imdb =", value, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbNotEqualTo(Long value) {
            addCriterion("id_movie_imdb <>", value, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbGreaterThan(Long value) {
            addCriterion("id_movie_imdb >", value, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbGreaterThanOrEqualTo(Long value) {
            addCriterion("id_movie_imdb >=", value, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbLessThan(Long value) {
            addCriterion("id_movie_imdb <", value, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbLessThanOrEqualTo(Long value) {
            addCriterion("id_movie_imdb <=", value, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbIn(List<Long> values) {
            addCriterion("id_movie_imdb in", values, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbNotIn(List<Long> values) {
            addCriterion("id_movie_imdb not in", values, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbBetween(Long value1, Long value2) {
            addCriterion("id_movie_imdb between", value1, value2, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdMovieImdbNotBetween(Long value1, Long value2) {
            addCriterion("id_movie_imdb not between", value1, value2, "idMovieImdb");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceIsNull() {
            addCriterion("id_website_resource is null");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceIsNotNull() {
            addCriterion("id_website_resource is not null");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceEqualTo(Short value) {
            addCriterion("id_website_resource =", value, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceNotEqualTo(Short value) {
            addCriterion("id_website_resource <>", value, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceGreaterThan(Short value) {
            addCriterion("id_website_resource >", value, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceGreaterThanOrEqualTo(Short value) {
            addCriterion("id_website_resource >=", value, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceLessThan(Short value) {
            addCriterion("id_website_resource <", value, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceLessThanOrEqualTo(Short value) {
            addCriterion("id_website_resource <=", value, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceIn(List<Short> values) {
            addCriterion("id_website_resource in", values, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceNotIn(List<Short> values) {
            addCriterion("id_website_resource not in", values, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceBetween(Short value1, Short value2) {
            addCriterion("id_website_resource between", value1, value2, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdWebsiteResourceNotBetween(Short value1, Short value2) {
            addCriterion("id_website_resource not between", value1, value2, "idWebsiteResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceIsNull() {
            addCriterion("id_type_resource is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceIsNotNull() {
            addCriterion("id_type_resource is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceEqualTo(Short value) {
            addCriterion("id_type_resource =", value, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceNotEqualTo(Short value) {
            addCriterion("id_type_resource <>", value, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceGreaterThan(Short value) {
            addCriterion("id_type_resource >", value, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceGreaterThanOrEqualTo(Short value) {
            addCriterion("id_type_resource >=", value, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceLessThan(Short value) {
            addCriterion("id_type_resource <", value, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceLessThanOrEqualTo(Short value) {
            addCriterion("id_type_resource <=", value, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceIn(List<Short> values) {
            addCriterion("id_type_resource in", values, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceNotIn(List<Short> values) {
            addCriterion("id_type_resource not in", values, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceBetween(Short value1, Short value2) {
            addCriterion("id_type_resource between", value1, value2, "idTypeResource");
            return (Criteria) this;
        }

        public Criteria andIdTypeResourceNotBetween(Short value1, Short value2) {
            addCriterion("id_type_resource not between", value1, value2, "idTypeResource");
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

        public Criteria andCreateYearIsNull() {
            addCriterion("create_year is null");
            return (Criteria) this;
        }

        public Criteria andCreateYearIsNotNull() {
            addCriterion("create_year is not null");
            return (Criteria) this;
        }

        public Criteria andCreateYearEqualTo(Short value) {
            addCriterion("create_year =", value, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearNotEqualTo(Short value) {
            addCriterion("create_year <>", value, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearGreaterThan(Short value) {
            addCriterion("create_year >", value, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearGreaterThanOrEqualTo(Short value) {
            addCriterion("create_year >=", value, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearLessThan(Short value) {
            addCriterion("create_year <", value, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearLessThanOrEqualTo(Short value) {
            addCriterion("create_year <=", value, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearIn(List<Short> values) {
            addCriterion("create_year in", values, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearNotIn(List<Short> values) {
            addCriterion("create_year not in", values, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearBetween(Short value1, Short value2) {
            addCriterion("create_year between", value1, value2, "createYear");
            return (Criteria) this;
        }

        public Criteria andCreateYearNotBetween(Short value1, Short value2) {
            addCriterion("create_year not between", value1, value2, "createYear");
            return (Criteria) this;
        }

        public Criteria andNameOriginIsNull() {
            addCriterion("name_origin is null");
            return (Criteria) this;
        }

        public Criteria andNameOriginIsNotNull() {
            addCriterion("name_origin is not null");
            return (Criteria) this;
        }

        public Criteria andNameOriginEqualTo(String value) {
            addCriterion("name_origin =", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginNotEqualTo(String value) {
            addCriterion("name_origin <>", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginGreaterThan(String value) {
            addCriterion("name_origin >", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginGreaterThanOrEqualTo(String value) {
            addCriterion("name_origin >=", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginLessThan(String value) {
            addCriterion("name_origin <", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginLessThanOrEqualTo(String value) {
            addCriterion("name_origin <=", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginLike(String value) {
            addCriterion("name_origin like", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginNotLike(String value) {
            addCriterion("name_origin not like", value, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginIn(List<String> values) {
            addCriterion("name_origin in", values, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginNotIn(List<String> values) {
            addCriterion("name_origin not in", values, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginBetween(String value1, String value2) {
            addCriterion("name_origin between", value1, value2, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andNameOriginNotBetween(String value1, String value2) {
            addCriterion("name_origin not between", value1, value2, "nameOrigin");
            return (Criteria) this;
        }

        public Criteria andUrlResourceIsNull() {
            addCriterion("url_resource is null");
            return (Criteria) this;
        }

        public Criteria andUrlResourceIsNotNull() {
            addCriterion("url_resource is not null");
            return (Criteria) this;
        }

        public Criteria andUrlResourceEqualTo(String value) {
            addCriterion("url_resource =", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceNotEqualTo(String value) {
            addCriterion("url_resource <>", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceGreaterThan(String value) {
            addCriterion("url_resource >", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceGreaterThanOrEqualTo(String value) {
            addCriterion("url_resource >=", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceLessThan(String value) {
            addCriterion("url_resource <", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceLessThanOrEqualTo(String value) {
            addCriterion("url_resource <=", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceLike(String value) {
            addCriterion("url_resource like", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceNotLike(String value) {
            addCriterion("url_resource not like", value, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceIn(List<String> values) {
            addCriterion("url_resource in", values, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceNotIn(List<String> values) {
            addCriterion("url_resource not in", values, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceBetween(String value1, String value2) {
            addCriterion("url_resource between", value1, value2, "urlResource");
            return (Criteria) this;
        }

        public Criteria andUrlResourceNotBetween(String value1, String value2) {
            addCriterion("url_resource not between", value1, value2, "urlResource");
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