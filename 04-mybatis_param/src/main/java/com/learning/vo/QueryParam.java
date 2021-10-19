package com.learning.vo;

public class QueryParam {
    private String paramName;
    private int paramage;

    public QueryParam(String paramName, int paramage) {
        this.paramName = paramName;
        this.paramage = paramage;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public int getParamage() {
        return paramage;
    }

    public void setParamage(int paramage) {
        this.paramage = paramage;
    }
}
