package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class MovieImdbToCelebrityImdbExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public MovieImdbToCelebrityImdbExample() {
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

    public Criteria andIdCelebrityImdbIsNull() {
      addCriterion("id_celebrity_imdb is null");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbIsNotNull() {
      addCriterion("id_celebrity_imdb is not null");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbEqualTo(Long value) {
      addCriterion("id_celebrity_imdb =", value, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbNotEqualTo(Long value) {
      addCriterion("id_celebrity_imdb <>", value, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbGreaterThan(Long value) {
      addCriterion("id_celebrity_imdb >", value, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbGreaterThanOrEqualTo(Long value) {
      addCriterion("id_celebrity_imdb >=", value, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbLessThan(Long value) {
      addCriterion("id_celebrity_imdb <", value, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbLessThanOrEqualTo(Long value) {
      addCriterion("id_celebrity_imdb <=", value, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbIn(List<Long> values) {
      addCriterion("id_celebrity_imdb in", values, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbNotIn(List<Long> values) {
      addCriterion("id_celebrity_imdb not in", values, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbBetween(Long value1, Long value2) {
      addCriterion("id_celebrity_imdb between", value1, value2, "idCelebrityImdb");
      return (Criteria) this;
    }

    public Criteria andIdCelebrityImdbNotBetween(Long value1, Long value2) {
      addCriterion("id_celebrity_imdb not between", value1, value2, "idCelebrityImdb");
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
