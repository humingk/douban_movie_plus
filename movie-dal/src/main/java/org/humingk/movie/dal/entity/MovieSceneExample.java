package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class MovieSceneExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public MovieSceneExample() {
    oredCriteria = new ArrayList<Criteria>();
  }

  public String getOrderByClause() {
    return orderByClause;
  }

  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  public boolean isDistinct() {
    return distinct;
  }

  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
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

    public Criteria andNameEnIsNull() {
      addCriterion("name_en is null");
      return (Criteria) this;
    }

    public Criteria andNameEnIsNotNull() {
      addCriterion("name_en is not null");
      return (Criteria) this;
    }

    public Criteria andNameEnEqualTo(String value) {
      addCriterion("name_en =", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnNotEqualTo(String value) {
      addCriterion("name_en <>", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnGreaterThan(String value) {
      addCriterion("name_en >", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnGreaterThanOrEqualTo(String value) {
      addCriterion("name_en >=", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnLessThan(String value) {
      addCriterion("name_en <", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnLessThanOrEqualTo(String value) {
      addCriterion("name_en <=", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnLike(String value) {
      addCriterion("name_en like", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnNotLike(String value) {
      addCriterion("name_en not like", value, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnIn(List<String> values) {
      addCriterion("name_en in", values, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnNotIn(List<String> values) {
      addCriterion("name_en not in", values, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnBetween(String value1, String value2) {
      addCriterion("name_en between", value1, value2, "nameEn");
      return (Criteria) this;
    }

    public Criteria andNameEnNotBetween(String value1, String value2) {
      addCriterion("name_en not between", value1, value2, "nameEn");
      return (Criteria) this;
    }

    public Criteria andStartYearIsNull() {
      addCriterion("start_year is null");
      return (Criteria) this;
    }

    public Criteria andStartYearIsNotNull() {
      addCriterion("start_year is not null");
      return (Criteria) this;
    }

    public Criteria andStartYearEqualTo(Short value) {
      addCriterion("start_year =", value, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearNotEqualTo(Short value) {
      addCriterion("start_year <>", value, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearGreaterThan(Short value) {
      addCriterion("start_year >", value, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearGreaterThanOrEqualTo(Short value) {
      addCriterion("start_year >=", value, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearLessThan(Short value) {
      addCriterion("start_year <", value, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearLessThanOrEqualTo(Short value) {
      addCriterion("start_year <=", value, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearIn(List<Short> values) {
      addCriterion("start_year in", values, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearNotIn(List<Short> values) {
      addCriterion("start_year not in", values, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearBetween(Short value1, Short value2) {
      addCriterion("start_year between", value1, value2, "startYear");
      return (Criteria) this;
    }

    public Criteria andStartYearNotBetween(Short value1, Short value2) {
      addCriterion("start_year not between", value1, value2, "startYear");
      return (Criteria) this;
    }

    public Criteria andDescriptionIsNull() {
      addCriterion("description is null");
      return (Criteria) this;
    }

    public Criteria andDescriptionIsNotNull() {
      addCriterion("description is not null");
      return (Criteria) this;
    }

    public Criteria andDescriptionEqualTo(String value) {
      addCriterion("description =", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotEqualTo(String value) {
      addCriterion("description <>", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionGreaterThan(String value) {
      addCriterion("description >", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
      addCriterion("description >=", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLessThan(String value) {
      addCriterion("description <", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLessThanOrEqualTo(String value) {
      addCriterion("description <=", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionLike(String value) {
      addCriterion("description like", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotLike(String value) {
      addCriterion("description not like", value, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionIn(List<String> values) {
      addCriterion("description in", values, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotIn(List<String> values) {
      addCriterion("description not in", values, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionBetween(String value1, String value2) {
      addCriterion("description between", value1, value2, "description");
      return (Criteria) this;
    }

    public Criteria andDescriptionNotBetween(String value1, String value2) {
      addCriterion("description not between", value1, value2, "description");
      return (Criteria) this;
    }

    public Criteria andUrlMapIsNull() {
      addCriterion("url_map is null");
      return (Criteria) this;
    }

    public Criteria andUrlMapIsNotNull() {
      addCriterion("url_map is not null");
      return (Criteria) this;
    }

    public Criteria andUrlMapEqualTo(String value) {
      addCriterion("url_map =", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapNotEqualTo(String value) {
      addCriterion("url_map <>", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapGreaterThan(String value) {
      addCriterion("url_map >", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapGreaterThanOrEqualTo(String value) {
      addCriterion("url_map >=", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapLessThan(String value) {
      addCriterion("url_map <", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapLessThanOrEqualTo(String value) {
      addCriterion("url_map <=", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapLike(String value) {
      addCriterion("url_map like", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapNotLike(String value) {
      addCriterion("url_map not like", value, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapIn(List<String> values) {
      addCriterion("url_map in", values, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapNotIn(List<String> values) {
      addCriterion("url_map not in", values, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapBetween(String value1, String value2) {
      addCriterion("url_map between", value1, value2, "urlMap");
      return (Criteria) this;
    }

    public Criteria andUrlMapNotBetween(String value1, String value2) {
      addCriterion("url_map not between", value1, value2, "urlMap");
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
  }
}
