package com.lhb.study.util.frame;

import java.io.Serializable;
import java.util.List;

/**
 * 集合结果返回类
 * @author lianghuaibin
 * @since 2017/3/21
 */
public class ListResult<T> extends AbstractResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> values;

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
