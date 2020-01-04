package org.humingk.movie.service.common.entity;

import java.util.ArrayList;
import java.util.List;

public class MovieDoubanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieDoubanExample() {
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

        public Criteria andUrlPosterEqualTo(Long value) {
            addCriterion("url_poster =", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterNotEqualTo(Long value) {
            addCriterion("url_poster <>", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterGreaterThan(Long value) {
            addCriterion("url_poster >", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterGreaterThanOrEqualTo(Long value) {
            addCriterion("url_poster >=", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterLessThan(Long value) {
            addCriterion("url_poster <", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterLessThanOrEqualTo(Long value) {
            addCriterion("url_poster <=", value, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterIn(List<Long> values) {
            addCriterion("url_poster in", values, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterNotIn(List<Long> values) {
            addCriterion("url_poster not in", values, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterBetween(Long value1, Long value2) {
            addCriterion("url_poster between", value1, value2, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andUrlPosterNotBetween(Long value1, Long value2) {
            addCriterion("url_poster not between", value1, value2, "urlPoster");
            return (Criteria) this;
        }

        public Criteria andHaveSeenIsNull() {
            addCriterion("have_seen is null");
            return (Criteria) this;
        }

        public Criteria andHaveSeenIsNotNull() {
            addCriterion("have_seen is not null");
            return (Criteria) this;
        }

        public Criteria andHaveSeenEqualTo(Integer value) {
            addCriterion("have_seen =", value, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenNotEqualTo(Integer value) {
            addCriterion("have_seen <>", value, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenGreaterThan(Integer value) {
            addCriterion("have_seen >", value, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenGreaterThanOrEqualTo(Integer value) {
            addCriterion("have_seen >=", value, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenLessThan(Integer value) {
            addCriterion("have_seen <", value, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenLessThanOrEqualTo(Integer value) {
            addCriterion("have_seen <=", value, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenIn(List<Integer> values) {
            addCriterion("have_seen in", values, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenNotIn(List<Integer> values) {
            addCriterion("have_seen not in", values, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenBetween(Integer value1, Integer value2) {
            addCriterion("have_seen between", value1, value2, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andHaveSeenNotBetween(Integer value1, Integer value2) {
            addCriterion("have_seen not between", value1, value2, "haveSeen");
            return (Criteria) this;
        }

        public Criteria andWannaSeeIsNull() {
            addCriterion("wanna_see is null");
            return (Criteria) this;
        }

        public Criteria andWannaSeeIsNotNull() {
            addCriterion("wanna_see is not null");
            return (Criteria) this;
        }

        public Criteria andWannaSeeEqualTo(Integer value) {
            addCriterion("wanna_see =", value, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeNotEqualTo(Integer value) {
            addCriterion("wanna_see <>", value, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeGreaterThan(Integer value) {
            addCriterion("wanna_see >", value, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wanna_see >=", value, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeLessThan(Integer value) {
            addCriterion("wanna_see <", value, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeLessThanOrEqualTo(Integer value) {
            addCriterion("wanna_see <=", value, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeIn(List<Integer> values) {
            addCriterion("wanna_see in", values, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeNotIn(List<Integer> values) {
            addCriterion("wanna_see not in", values, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeBetween(Integer value1, Integer value2) {
            addCriterion("wanna_see between", value1, value2, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andWannaSeeNotBetween(Integer value1, Integer value2) {
            addCriterion("wanna_see not between", value1, value2, "wannaSee");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseIsNull() {
            addCriterion("is_netease is null");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseIsNotNull() {
            addCriterion("is_netease is not null");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseEqualTo(Boolean value) {
            addCriterion("is_netease =", value, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseNotEqualTo(Boolean value) {
            addCriterion("is_netease <>", value, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseGreaterThan(Boolean value) {
            addCriterion("is_netease >", value, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_netease >=", value, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseLessThan(Boolean value) {
            addCriterion("is_netease <", value, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseLessThanOrEqualTo(Boolean value) {
            addCriterion("is_netease <=", value, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseIn(List<Boolean> values) {
            addCriterion("is_netease in", values, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseNotIn(List<Boolean> values) {
            addCriterion("is_netease not in", values, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseBetween(Boolean value1, Boolean value2) {
            addCriterion("is_netease between", value1, value2, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsNeteaseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_netease not between", value1, value2, "isNetease");
            return (Criteria) this;
        }

        public Criteria andIsZhihuIsNull() {
            addCriterion("is_zhihu is null");
            return (Criteria) this;
        }

        public Criteria andIsZhihuIsNotNull() {
            addCriterion("is_zhihu is not null");
            return (Criteria) this;
        }

        public Criteria andIsZhihuEqualTo(Boolean value) {
            addCriterion("is_zhihu =", value, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuNotEqualTo(Boolean value) {
            addCriterion("is_zhihu <>", value, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuGreaterThan(Boolean value) {
            addCriterion("is_zhihu >", value, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_zhihu >=", value, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuLessThan(Boolean value) {
            addCriterion("is_zhihu <", value, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuLessThanOrEqualTo(Boolean value) {
            addCriterion("is_zhihu <=", value, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuIn(List<Boolean> values) {
            addCriterion("is_zhihu in", values, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuNotIn(List<Boolean> values) {
            addCriterion("is_zhihu not in", values, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuBetween(Boolean value1, Boolean value2) {
            addCriterion("is_zhihu between", value1, value2, "isZhihu");
            return (Criteria) this;
        }

        public Criteria andIsZhihuNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_zhihu not between", value1, value2, "isZhihu");
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