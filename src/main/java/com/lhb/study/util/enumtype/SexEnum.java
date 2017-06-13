package com.lhb.study.util.enumtype;

/**
 * @author lianghuaibin
 * @since 2017/6/13
 */
public enum SexEnum {
    VALID("1","男"),
    FAIL("0","女");

    private SexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String desc;
    private String code;

    public String getDesc() {
        return desc;
    }

    public String getCode() {
        return code;
    }

    public String toString(){
        return code+","+desc;
    }

    /**
     * 通过key 查找描述 方法
     * @param key
     * @return string 返回对应名称.
     */
    public static String getValueByKey(String key) {
        for (SexEnum pm : SexEnum.values()) {
            if (pm.getCode().equals(key)) {
                return pm.getDesc();
            }
        }
        return null;
    }
}
