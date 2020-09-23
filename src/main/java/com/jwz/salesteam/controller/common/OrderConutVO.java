package com.jwz.salesteam.controller.common;

/**
 * @author ：Jiang Weizan
 * @date ：Created in 2020/9/23 20:14
 * @description：订单业绩查询
 * @modified By：
 * @version:
 */
public class OrderConutVO {
    private String empId;

    private String emdName;

    private Integer empResults;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmdName() {
        return emdName;
    }

    public void setEmdName(String emdName) {
        this.emdName = emdName;
    }

    public Integer getEmpResults() {
        return empResults;
    }

    public void setEmpResults(Integer empResults) {
        this.empResults = empResults;
    }
}
