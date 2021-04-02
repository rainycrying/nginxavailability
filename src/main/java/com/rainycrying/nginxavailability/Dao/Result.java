package com.rainycrying.nginxavailability.Dao;

import net.sf.json.JSONArray;

public class Result {
    private int msg=0;
    private JSONArray data;

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }
}
