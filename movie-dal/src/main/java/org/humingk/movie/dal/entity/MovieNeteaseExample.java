package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class MovieNeteaseExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public MovieNeteaseExample() {
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

    public Criteria andIdNeteaseIsNull() {
      addCriterion("id_netease is null");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseIsNotNull() {
      addCriterion("id_netease is not null");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseEqualTo(Long value) {
      addCriterion("id_netease =", value, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseNotEqualTo(Long value) {
      addCriterion("id_netease <>", value, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseGreaterThan(Long value) {
      addCriterion("id_netease >", value, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseGreaterThanOrEqualTo(Long value) {
      addCriterion("id_netease >=", value, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseLessThan(Long value) {
      addCriterion("id_netease <", value, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseLessThanOrEqualTo(Long value) {
      addCriterion("id_netease <=", value, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseIn(List<Long> values) {
      addCriterion("id_netease in", values, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseNotIn(List<Long> values) {
      addCriterion("id_netease not in", values, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseBetween(Long value1, Long value2) {
      addCriterion("id_netease between", value1, value2, "idNetease");
      return (Criteria) this;
    }

    public Criteria andIdNeteaseNotBetween(Long value1, Long value2) {
      addCriterion("id_netease not between", value1, value2, "idNetease");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeIsNull() {
      addCriterion("netease_type is null");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeIsNotNull() {
      addCriterion("netease_type is not null");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeEqualTo(Byte value) {
      addCriterion("netease_type =", value, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeNotEqualTo(Byte value) {
      addCriterion("netease_type <>", value, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeGreaterThan(Byte value) {
      addCriterion("netease_type >", value, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeGreaterThanOrEqualTo(Byte value) {
      addCriterion("netease_type >=", value, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeLessThan(Byte value) {
      addCriterion("netease_type <", value, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeLessThanOrEqualTo(Byte value) {
      addCriterion("netease_type <=", value, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeIn(List<Byte> values) {
      addCriterion("netease_type in", values, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeNotIn(List<Byte> values) {
      addCriterion("netease_type not in", values, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeBetween(Byte value1, Byte value2) {
      addCriterion("netease_type between", value1, value2, "neteaseType");
      return (Criteria) this;
    }

    public Criteria andNeteaseTypeNotBetween(Byte value1, Byte value2) {
      addCriterion("netease_type not between", value1, value2, "neteaseType");
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

    public Criteria andSortEqualTo(Byte value) {
      addCriterion("sort =", value, "sort");
      return (Criteria) this;
    }

    public Criteria andSortNotEqualTo(Byte value) {
      addCriterion("sort <>", value, "sort");
      return (Criteria) this;
    }

    public Criteria andSortGreaterThan(Byte value) {
      addCriterion("sort >", value, "sort");
      return (Criteria) this;
    }

    public Criteria andSortGreaterThanOrEqualTo(Byte value) {
      addCriterion("sort >=", value, "sort");
      return (Criteria) this;
    }

    public Criteria andSortLessThan(Byte value) {
      addCriterion("sort <", value, "sort");
      return (Criteria) this;
    }

    public Criteria andSortLessThanOrEqualTo(Byte value) {
      addCriterion("sort <=", value, "sort");
      return (Criteria) this;
    }

    public Criteria andSortIn(List<Byte> values) {
      addCriterion("sort in", values, "sort");
      return (Criteria) this;
    }

    public Criteria andSortNotIn(List<Byte> values) {
      addCriterion("sort not in", values, "sort");
      return (Criteria) this;
    }

    public Criteria andSortBetween(Byte value1, Byte value2) {
      addCriterion("sort between", value1, value2, "sort");
      return (Criteria) this;
    }

    public Criteria andSortNotBetween(Byte value1, Byte value2) {
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
