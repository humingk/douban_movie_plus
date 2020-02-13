package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class MovieImdbExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public MovieImdbExample() {
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

    public Criteria andIdTypeVideoIsNull() {
      addCriterion("id_type_video is null");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoIsNotNull() {
      addCriterion("id_type_video is not null");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoEqualTo(Byte value) {
      addCriterion("id_type_video =", value, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoNotEqualTo(Byte value) {
      addCriterion("id_type_video <>", value, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoGreaterThan(Byte value) {
      addCriterion("id_type_video >", value, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoGreaterThanOrEqualTo(Byte value) {
      addCriterion("id_type_video >=", value, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoLessThan(Byte value) {
      addCriterion("id_type_video <", value, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoLessThanOrEqualTo(Byte value) {
      addCriterion("id_type_video <=", value, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoIn(List<Byte> values) {
      addCriterion("id_type_video in", values, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoNotIn(List<Byte> values) {
      addCriterion("id_type_video not in", values, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoBetween(Byte value1, Byte value2) {
      addCriterion("id_type_video between", value1, value2, "idTypeVideo");
      return (Criteria) this;
    }

    public Criteria andIdTypeVideoNotBetween(Byte value1, Byte value2) {
      addCriterion("id_type_video not between", value1, value2, "idTypeVideo");
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

    public Criteria andIsAdultIsNull() {
      addCriterion("is_adult is null");
      return (Criteria) this;
    }

    public Criteria andIsAdultIsNotNull() {
      addCriterion("is_adult is not null");
      return (Criteria) this;
    }

    public Criteria andIsAdultEqualTo(Boolean value) {
      addCriterion("is_adult =", value, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultNotEqualTo(Boolean value) {
      addCriterion("is_adult <>", value, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultGreaterThan(Boolean value) {
      addCriterion("is_adult >", value, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultGreaterThanOrEqualTo(Boolean value) {
      addCriterion("is_adult >=", value, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultLessThan(Boolean value) {
      addCriterion("is_adult <", value, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultLessThanOrEqualTo(Boolean value) {
      addCriterion("is_adult <=", value, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultIn(List<Boolean> values) {
      addCriterion("is_adult in", values, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultNotIn(List<Boolean> values) {
      addCriterion("is_adult not in", values, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultBetween(Boolean value1, Boolean value2) {
      addCriterion("is_adult between", value1, value2, "isAdult");
      return (Criteria) this;
    }

    public Criteria andIsAdultNotBetween(Boolean value1, Boolean value2) {
      addCriterion("is_adult not between", value1, value2, "isAdult");
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

    public Criteria andRuntimeIsNull() {
      addCriterion("runtime is null");
      return (Criteria) this;
    }

    public Criteria andRuntimeIsNotNull() {
      addCriterion("runtime is not null");
      return (Criteria) this;
    }

    public Criteria andRuntimeEqualTo(Short value) {
      addCriterion("runtime =", value, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeNotEqualTo(Short value) {
      addCriterion("runtime <>", value, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeGreaterThan(Short value) {
      addCriterion("runtime >", value, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeGreaterThanOrEqualTo(Short value) {
      addCriterion("runtime >=", value, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeLessThan(Short value) {
      addCriterion("runtime <", value, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeLessThanOrEqualTo(Short value) {
      addCriterion("runtime <=", value, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeIn(List<Short> values) {
      addCriterion("runtime in", values, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeNotIn(List<Short> values) {
      addCriterion("runtime not in", values, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeBetween(Short value1, Short value2) {
      addCriterion("runtime between", value1, value2, "runtime");
      return (Criteria) this;
    }

    public Criteria andRuntimeNotBetween(Short value1, Short value2) {
      addCriterion("runtime not between", value1, value2, "runtime");
      return (Criteria) this;
    }

    public Criteria andUrlPosterIsNull() {
      addCriterion("url_poster is null");
      return (Criteria) this;
    }

    public Criteria andUrlPosterIsNotNull() {
      addCriterion("url_poster is not null");
      return (Criteria) this;
    }

    public Criteria andUrlPosterEqualTo(String value) {
      addCriterion("url_poster =", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterNotEqualTo(String value) {
      addCriterion("url_poster <>", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterGreaterThan(String value) {
      addCriterion("url_poster >", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterGreaterThanOrEqualTo(String value) {
      addCriterion("url_poster >=", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterLessThan(String value) {
      addCriterion("url_poster <", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterLessThanOrEqualTo(String value) {
      addCriterion("url_poster <=", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterLike(String value) {
      addCriterion("url_poster like", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterNotLike(String value) {
      addCriterion("url_poster not like", value, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterIn(List<String> values) {
      addCriterion("url_poster in", values, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterNotIn(List<String> values) {
      addCriterion("url_poster not in", values, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterBetween(String value1, String value2) {
      addCriterion("url_poster between", value1, value2, "urlPoster");
      return (Criteria) this;
    }

    public Criteria andUrlPosterNotBetween(String value1, String value2) {
      addCriterion("url_poster not between", value1, value2, "urlPoster");
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
