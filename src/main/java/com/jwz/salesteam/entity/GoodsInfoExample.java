package com.jwz.salesteam.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GoodsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceIsNull() {
            addCriterion("goods_selling_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceIsNotNull() {
            addCriterion("goods_selling_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceEqualTo(Integer value) {
            addCriterion("goods_selling_price =", value, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceNotEqualTo(Integer value) {
            addCriterion("goods_selling_price <>", value, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceGreaterThan(Integer value) {
            addCriterion("goods_selling_price >", value, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_selling_price >=", value, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceLessThan(Integer value) {
            addCriterion("goods_selling_price <", value, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_selling_price <=", value, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceIn(List<Integer> values) {
            addCriterion("goods_selling_price in", values, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceNotIn(List<Integer> values) {
            addCriterion("goods_selling_price not in", values, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_selling_price between", value1, value2, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSellingPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_selling_price not between", value1, value2, "goodsSellingPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgIsNull() {
            addCriterion("goods_cover_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgIsNotNull() {
            addCriterion("goods_cover_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgEqualTo(String value) {
            addCriterion("goods_cover_img =", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgNotEqualTo(String value) {
            addCriterion("goods_cover_img <>", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgGreaterThan(String value) {
            addCriterion("goods_cover_img >", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_cover_img >=", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgLessThan(String value) {
            addCriterion("goods_cover_img <", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgLessThanOrEqualTo(String value) {
            addCriterion("goods_cover_img <=", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgLike(String value) {
            addCriterion("goods_cover_img like", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgNotLike(String value) {
            addCriterion("goods_cover_img not like", value, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgIn(List<String> values) {
            addCriterion("goods_cover_img in", values, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgNotIn(List<String> values) {
            addCriterion("goods_cover_img not in", values, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgBetween(String value1, String value2) {
            addCriterion("goods_cover_img between", value1, value2, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsCoverImgNotBetween(String value1, String value2) {
            addCriterion("goods_cover_img not between", value1, value2, "goodsCoverImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentIsNull() {
            addCriterion("goods_detail_content is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentIsNotNull() {
            addCriterion("goods_detail_content is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentEqualTo(String value) {
            addCriterion("goods_detail_content =", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentNotEqualTo(String value) {
            addCriterion("goods_detail_content <>", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentGreaterThan(String value) {
            addCriterion("goods_detail_content >", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentGreaterThanOrEqualTo(String value) {
            addCriterion("goods_detail_content >=", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentLessThan(String value) {
            addCriterion("goods_detail_content <", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentLessThanOrEqualTo(String value) {
            addCriterion("goods_detail_content <=", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentLike(String value) {
            addCriterion("goods_detail_content like", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentNotLike(String value) {
            addCriterion("goods_detail_content not like", value, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentIn(List<String> values) {
            addCriterion("goods_detail_content in", values, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentNotIn(List<String> values) {
            addCriterion("goods_detail_content not in", values, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentBetween(String value1, String value2) {
            addCriterion("goods_detail_content between", value1, value2, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailContentNotBetween(String value1, String value2) {
            addCriterion("goods_detail_content not between", value1, value2, "goodsDetailContent");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroIsNull() {
            addCriterion("goods_intro is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroIsNotNull() {
            addCriterion("goods_intro is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroEqualTo(String value) {
            addCriterion("goods_intro =", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroNotEqualTo(String value) {
            addCriterion("goods_intro <>", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroGreaterThan(String value) {
            addCriterion("goods_intro >", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroGreaterThanOrEqualTo(String value) {
            addCriterion("goods_intro >=", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroLessThan(String value) {
            addCriterion("goods_intro <", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroLessThanOrEqualTo(String value) {
            addCriterion("goods_intro <=", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroLike(String value) {
            addCriterion("goods_intro like", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroNotLike(String value) {
            addCriterion("goods_intro not like", value, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroIn(List<String> values) {
            addCriterion("goods_intro in", values, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroNotIn(List<String> values) {
            addCriterion("goods_intro not in", values, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroBetween(String value1, String value2) {
            addCriterion("goods_intro between", value1, value2, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andGoodsIntroNotBetween(String value1, String value2) {
            addCriterion("goods_intro not between", value1, value2, "goodsIntro");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterionForJDBCDate("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
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