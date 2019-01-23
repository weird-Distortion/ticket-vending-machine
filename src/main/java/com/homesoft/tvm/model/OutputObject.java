package com.homesoft.tvm.model;

import java.math.BigDecimal;

public abstract class OutputObject {

    private String objType;
    private BigDecimal objCost;

    public OutputObject(String objType, String objCost) {
        this.objType = objType;
        this.objCost = new BigDecimal(objCost);
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public BigDecimal getObjCost() {
        return objCost;
    }

    public void setObjCost(BigDecimal objCost) {
        this.objCost = objCost;
    }
}
