package org.humingk.movie.dal.entity;

import java.util.ArrayList;
import java.util.List;

public class ArtistNeteaseToAlbumNeteaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArtistNeteaseToAlbumNeteaseExample() {
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

        public Criteria andIdArtistNeteaseIsNull() {
            addCriterion("id_artist_netease is null");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseIsNotNull() {
            addCriterion("id_artist_netease is not null");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseEqualTo(Long value) {
            addCriterion("id_artist_netease =", value, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseNotEqualTo(Long value) {
            addCriterion("id_artist_netease <>", value, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseGreaterThan(Long value) {
            addCriterion("id_artist_netease >", value, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseGreaterThanOrEqualTo(Long value) {
            addCriterion("id_artist_netease >=", value, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseLessThan(Long value) {
            addCriterion("id_artist_netease <", value, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseLessThanOrEqualTo(Long value) {
            addCriterion("id_artist_netease <=", value, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseIn(List<Long> values) {
            addCriterion("id_artist_netease in", values, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseNotIn(List<Long> values) {
            addCriterion("id_artist_netease not in", values, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseBetween(Long value1, Long value2) {
            addCriterion("id_artist_netease between", value1, value2, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdArtistNeteaseNotBetween(Long value1, Long value2) {
            addCriterion("id_artist_netease not between", value1, value2, "idArtistNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseIsNull() {
            addCriterion("id_album_netease is null");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseIsNotNull() {
            addCriterion("id_album_netease is not null");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseEqualTo(Long value) {
            addCriterion("id_album_netease =", value, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseNotEqualTo(Long value) {
            addCriterion("id_album_netease <>", value, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseGreaterThan(Long value) {
            addCriterion("id_album_netease >", value, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseGreaterThanOrEqualTo(Long value) {
            addCriterion("id_album_netease >=", value, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseLessThan(Long value) {
            addCriterion("id_album_netease <", value, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseLessThanOrEqualTo(Long value) {
            addCriterion("id_album_netease <=", value, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseIn(List<Long> values) {
            addCriterion("id_album_netease in", values, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseNotIn(List<Long> values) {
            addCriterion("id_album_netease not in", values, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseBetween(Long value1, Long value2) {
            addCriterion("id_album_netease between", value1, value2, "idAlbumNetease");
            return (Criteria) this;
        }

        public Criteria andIdAlbumNeteaseNotBetween(Long value1, Long value2) {
            addCriterion("id_album_netease not between", value1, value2, "idAlbumNetease");
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