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

    private String empName;

    private Integer empResults;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpResults() {
        return empResults;
    }

    public void setEmpResults(Integer empResults) {
        this.empResults = empResults;
    }
}
