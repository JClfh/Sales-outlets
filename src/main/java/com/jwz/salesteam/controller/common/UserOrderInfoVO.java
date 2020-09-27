package com.jwz.salesteam.controller.common;

import java.util.Date;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/26 16:57
 * @description：
 * @modified By：
 * @version:
 */
public class UserOrderInfoVO {

        private Integer id;

        private String orderId;

        private String empId;

        private String userId;

        private Integer takeInPrice;

        private Integer goodsAllPrice; //商品价格

        private String goodsName;

        private Integer modeOfDistibution;

        private Integer status;

        private Date createTime;

        private Date finishTime;

        private Integer isDel;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId == null ? null : orderId.trim();
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId == null ? null : empId.trim();
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId == null ? null : userId.trim();
        }

        public Integer getTakeInPrice() {
            return takeInPrice;
        }

        public void setTakeInPrice(Integer takeInPrice) {
            this.takeInPrice = takeInPrice;
        }

        public Integer getModeOfDistibution() {
            return modeOfDistibution;
        }

        public void setModeOfDistibution(Integer modeOfDistibution) {
            this.modeOfDistibution = modeOfDistibution;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(Date finishTime) {
            this.finishTime = finishTime;
        }

        public Integer getIsDel() {
            return isDel;
        }

        public void setIsDel(Integer isDel) {
            this.isDel = isDel;
        }

        public Integer getGoodsAllPrice() {
            return goodsAllPrice;
        }

        public void setGoodsAllPrice(Integer goodsAllPrice) {
            this.goodsAllPrice = goodsAllPrice;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

}
