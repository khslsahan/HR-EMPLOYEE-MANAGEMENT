package com.hsenid.headerfooterjsp.model;

public enum DepartmentName {
    DEV("DEV"),DELIVERY("DELIVERY"),SUPPORT("SUPPORT"),HR("HR"),
    DA("DA") ,DEV_OPP("DEV_OPP"),SALES("SALES"),EXECUTIVE("EXECUTIVE"),DESIGN("DESIGN");

    private String code;

    private DepartmentName(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
