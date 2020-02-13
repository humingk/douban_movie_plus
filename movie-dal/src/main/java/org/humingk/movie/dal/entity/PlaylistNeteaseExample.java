package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class PlaylistNeteaseExample {
  protected String orderByClause;

  protected boolean distinct;

  protected List<Criteria> oredCriteria;

  public PlaylistNeteaseExample() {
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

    public Criteria andTotalIsNull() {
      addCriterion("total is null");
      return (Criteria) this;
    }

    public Criteria andTotalIsNotNull() {
      addCriterion("total is not null");
      return (Criteria) this;
    }

    public Criteria andTotalEqualTo(Short value) {
      addCriterion("total =", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalNotEqualTo(Short value) {
      addCriterion("total <>", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalGreaterThan(Short value) {
      addCriterion("total >", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalGreaterThanOrEqualTo(Short value) {
      addCriterion("total >=", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalLessThan(Short value) {
      addCriterion("total <", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalLessThanOrEqualTo(Short value) {
      addCriterion("total <=", value, "total");
      return (Criteria) this;
    }

    public Criteria andTotalIn(List<Short> values) {
      addCriterion("total in", values, "total");
      return (Criteria) this;
    }

    public Criteria andTotalNotIn(List<Short> values) {
      addCriterion("total not in", values, "total");
      return (Criteria) this;
    }

    public Criteria andTotalBetween(Short value1, Short value2) {
      addCriterion("total between", value1, value2, "total");
      return (Criteria) this;
    }

    public Criteria andTotalNotBetween(Short value1, Short value2) {
      addCriterion("total not between", value1, value2, "total");
      return (Criteria) this;
    }

    public Criteria andPlayCountIsNull() {
      addCriterion("play_count is null");
      return (Criteria) this;
    }

    public Criteria andPlayCountIsNotNull() {
      addCriterion("play_count is not null");
      return (Criteria) this;
    }

    public Criteria andPlayCountEqualTo(Integer value) {
      addCriterion("play_count =", value, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountNotEqualTo(Integer value) {
      addCriterion("play_count <>", value, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountGreaterThan(Integer value) {
      addCriterion("play_count >", value, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountGreaterThanOrEqualTo(Integer value) {
      addCriterion("play_count >=", value, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountLessThan(Integer value) {
      addCriterion("play_count <", value, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountLessThanOrEqualTo(Integer value) {
      addCriterion("play_count <=", value, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountIn(List<Integer> values) {
      addCriterion("play_count in", values, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountNotIn(List<Integer> values) {
      addCriterion("play_count not in", values, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountBetween(Integer value1, Integer value2) {
      addCriterion("play_count between", value1, value2, "playCount");
      return (Criteria) this;
    }

    public Criteria andPlayCountNotBetween(Integer value1, Integer value2) {
      addCriterion("play_count not between", value1, value2, "playCount");
      return (Criteria) this;
    }

    public Criteria andUrlCoverIsNull() {
      addCriterion("url_cover is null");
      return (Criteria) this;
    }

    public Criteria andUrlCoverIsNotNull() {
      addCriterion("url_cover is not null");
      return (Criteria) this;
    }

    public Criteria andUrlCoverEqualTo(String value) {
      addCriterion("url_cover =", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverNotEqualTo(String value) {
      addCriterion("url_cover <>", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverGreaterThan(String value) {
      addCriterion("url_cover >", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverGreaterThanOrEqualTo(String value) {
      addCriterion("url_cover >=", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverLessThan(String value) {
      addCriterion("url_cover <", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverLessThanOrEqualTo(String value) {
      addCriterion("url_cover <=", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverLike(String value) {
      addCriterion("url_cover like", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverNotLike(String value) {
      addCriterion("url_cover not like", value, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverIn(List<String> values) {
      addCriterion("url_cover in", values, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverNotIn(List<String> values) {
      addCriterion("url_cover not in", values, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverBetween(String value1, String value2) {
      addCriterion("url_cover between", value1, value2, "urlCover");
      return (Criteria) this;
    }

    public Criteria andUrlCoverNotBetween(String value1, String value2) {
      addCriterion("url_cover not between", value1, value2, "urlCover");
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
