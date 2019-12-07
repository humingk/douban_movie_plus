package org.humingk.movie.entity;

import java.util.ArrayList;
import java.util.List;

public class SongNeteaseToPlaylistNeteaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongNeteaseToPlaylistNeteaseExample() {
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

        public Criteria andIdSongNeteaseIsNull() {
            addCriterion("id_song_netease is null");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseIsNotNull() {
            addCriterion("id_song_netease is not null");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseEqualTo(Long value) {
            addCriterion("id_song_netease =", value, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseNotEqualTo(Long value) {
            addCriterion("id_song_netease <>", value, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseGreaterThan(Long value) {
            addCriterion("id_song_netease >", value, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseGreaterThanOrEqualTo(Long value) {
            addCriterion("id_song_netease >=", value, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseLessThan(Long value) {
            addCriterion("id_song_netease <", value, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseLessThanOrEqualTo(Long value) {
            addCriterion("id_song_netease <=", value, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseIn(List<Long> values) {
            addCriterion("id_song_netease in", values, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseNotIn(List<Long> values) {
            addCriterion("id_song_netease not in", values, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseBetween(Long value1, Long value2) {
            addCriterion("id_song_netease between", value1, value2, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdSongNeteaseNotBetween(Long value1, Long value2) {
            addCriterion("id_song_netease not between", value1, value2, "idSongNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseIsNull() {
            addCriterion("id_playlist_netease is null");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseIsNotNull() {
            addCriterion("id_playlist_netease is not null");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseEqualTo(Long value) {
            addCriterion("id_playlist_netease =", value, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseNotEqualTo(Long value) {
            addCriterion("id_playlist_netease <>", value, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseGreaterThan(Long value) {
            addCriterion("id_playlist_netease >", value, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseGreaterThanOrEqualTo(Long value) {
            addCriterion("id_playlist_netease >=", value, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseLessThan(Long value) {
            addCriterion("id_playlist_netease <", value, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseLessThanOrEqualTo(Long value) {
            addCriterion("id_playlist_netease <=", value, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseIn(List<Long> values) {
            addCriterion("id_playlist_netease in", values, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseNotIn(List<Long> values) {
            addCriterion("id_playlist_netease not in", values, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseBetween(Long value1, Long value2) {
            addCriterion("id_playlist_netease between", value1, value2, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andIdPlaylistNeteaseNotBetween(Long value1, Long value2) {
            addCriterion("id_playlist_netease not between", value1, value2, "idPlaylistNetease");
            return (Criteria) this;
        }

        public Criteria andSongPopIsNull() {
            addCriterion("song_pop is null");
            return (Criteria) this;
        }

        public Criteria andSongPopIsNotNull() {
            addCriterion("song_pop is not null");
            return (Criteria) this;
        }

        public Criteria andSongPopEqualTo(Byte value) {
            addCriterion("song_pop =", value, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopNotEqualTo(Byte value) {
            addCriterion("song_pop <>", value, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopGreaterThan(Byte value) {
            addCriterion("song_pop >", value, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopGreaterThanOrEqualTo(Byte value) {
            addCriterion("song_pop >=", value, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopLessThan(Byte value) {
            addCriterion("song_pop <", value, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopLessThanOrEqualTo(Byte value) {
            addCriterion("song_pop <=", value, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopIn(List<Byte> values) {
            addCriterion("song_pop in", values, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopNotIn(List<Byte> values) {
            addCriterion("song_pop not in", values, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopBetween(Byte value1, Byte value2) {
            addCriterion("song_pop between", value1, value2, "songPop");
            return (Criteria) this;
        }

        public Criteria andSongPopNotBetween(Byte value1, Byte value2) {
            addCriterion("song_pop not between", value1, value2, "songPop");
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