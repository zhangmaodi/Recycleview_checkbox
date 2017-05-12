package test.bwie.com.recycleview_checkbox;

import java.io.Serializable;

/**
 * date:2017/5/12
 * author:张毛第
 * function:
 */

public class JavaBean implements Serializable {
    private String num;
    private Boolean falg;

    public Boolean getFalg() {
        return falg;
    }

    public void setFalg(Boolean falg) {
        this.falg = falg;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
