package com.jwz.salesteam.controller.common;

import io.swagger.models.auth.In;

import java.util.Date;
import java.util.Map;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/22 21:17
 * @description：业绩
 * @modified By：
 * @version:
 */
public class EmpInfoVO {

        private Integer id;

        private String empId;

        private String empPwd;

        private String empName;

        private Integer empSex;

        private String empTel;

        private String empAddress;

        private Integer empType;

        private Date createTime;

        private Date updateTime;

        private Integer isLock;

        private Integer isDel;

        private Map<String, Long> empCountList;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId == null ? null : empId.trim();
        }

        public String getEmpPwd() {
            return empPwd;
        }

        public void setEmpPwd(String empPwd) {
            this.empPwd = empPwd == null ? null : empPwd.trim();
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName == null ? null : empName.trim();
        }

        public Integer getEmpSex() {
            return empSex;
        }

        public void setEmpSex(Integer empSex) {
            this.empSex = empSex;
        }

        public String getEmpTel() {
            return empTel;
        }

        public void setEmpTel(String empTel) {
            this.empTel = empTel == null ? null : empTel.trim();
        }

        public String getEmpAddress() {
            return empAddress;
        }

        public void setEmpAddress(String empAddress) {
            this.empAddress = empAddress == null ? null : empAddress.trim();
        }

        public Integer getEmpType() {
            return empType;
        }

        public void setEmpType(Integer empType) {
            this.empType = empType;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public Integer getIsLock() {
            return isLock;
        }

        public void setIsLock(Integer isLock) {
            this.isLock = isLock;
        }

        public Integer getIsDel() {
            return isDel;
        }

        public void setIsDel(Integer isDel) {
            this.isDel = isDel;
        }

    public Map<String, Long> getEmpCountList() {
        return empCountList;
    }

    public void setEmpCountList(Map<String, Long> empCountList) {
        this.empCountList = empCountList;
    }

    @Override
    public String toString() {
        return "EmpInfoVO{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", empPwd='" + empPwd + '\'' +
                ", empName='" + empName + '\'' +
                ", empSex=" + empSex +
                ", empTel='" + empTel + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empType=" + empType +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isLock=" + isLock +
                ", isDel=" + isDel +
                ", empCountList=" + empCountList +
                '}';
    }

    public EmpInfoVO() {
    }

}
