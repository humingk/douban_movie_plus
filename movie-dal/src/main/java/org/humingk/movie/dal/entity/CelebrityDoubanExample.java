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
public class CelebrityDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CelebrityDoubanExample() {
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNull() {
            addCriterion("birth_date is null");
            return (Criteria) this;
        }

        public Criteria andBirthDateIsNotNull() {
            addCriterion("birth_date is not null");
            return (Criteria) this;
        }

        public Criteria andBirthDateEqualTo(Long value) {
            addCriterion("birth_date =", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotEqualTo(Long value) {
            addCriterion("birth_date <>", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThan(Long value) {
            addCriterion("birth_date >", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateGreaterThanOrEqualTo(Long value) {
            addCriterion("birth_date >=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThan(Long value) {
            addCriterion("birth_date <", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateLessThanOrEqualTo(Long value) {
            addCriterion("birth_date <=", value, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateIn(List<Long> values) {
            addCriterion("birth_date in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotIn(List<Long> values) {
            addCriterion("birth_date not in", values, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateBetween(Long value1, Long value2) {
            addCriterion("birth_date between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andBirthDateNotBetween(Long value1, Long value2) {
            addCriterion("birth_date not between", value1, value2, "birthDate");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitIsNull() {
            addCriterion("url_portrait is null");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitIsNotNull() {
            addCriterion("url_portrait is not null");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitEqualTo(Long value) {
            addCriterion("url_portrait =", value, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitNotEqualTo(Long value) {
            addCriterion("url_portrait <>", value, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitGreaterThan(Long value) {
            addCriterion("url_portrait >", value, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitGreaterThanOrEqualTo(Long value) {
            addCriterion("url_portrait >=", value, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitLessThan(Long value) {
            addCriterion("url_portrait <", value, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitLessThanOrEqualTo(Long value) {
            addCriterion("url_portrait <=", value, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitIn(List<Long> values) {
            addCriterion("url_portrait in", values, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitNotIn(List<Long> values) {
            addCriterion("url_portrait not in", values, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitBetween(Long value1, Long value2) {
            addCriterion("url_portrait between", value1, value2, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andUrlPortraitNotBetween(Long value1, Long value2) {
            addCriterion("url_portrait not between", value1, value2, "urlPortrait");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
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