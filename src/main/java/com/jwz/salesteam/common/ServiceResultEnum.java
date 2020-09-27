
package com.jwz.salesteam.common;

public enum ServiceResultEnum {
    ERROR("error"),

    SUCCESS("success"),

    DATA_NOT_EXIST("未查询到记录！"),

    EMP_ID_NULL("登录职工ID为空"),

    EMP_PWD_NULL("登录密码为空"),

    EMP_TYPE_NULL("职工类型未选"),

    SAME_EMPINFO_EXIST("该职员已经存在"),

    SAME_SUPPLIERINFO_EXIST("该供应商已存在"),

    SAME_USERINFO_EXIST("该客户已经存在"),

    SAME_GOODSINFO_EXIST("该商品已经存在"),

    LOGIN_EMP_LOCKED("该用户被锁"),

    LOGIN_ERROR("登录失败"),

    OLD_EMP_PWD_ERROR("原密码输入错误"),

    UPLOAD_ERROR("上传文件失败"),

    UPLOAD_SUCCESS("上传文件成功"),

    DB_ERROR("database error");


    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
