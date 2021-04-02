package com.rainycrying.nginxavailability.Dao;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class DomainHistry {
    private int Total_Throughput;
    private int Code_status_5xx;
    private int Code_status_4xx;
    private int Code_status_3xx;
    private int Code_status_2xx;
    private Date From_Hours;
    private Time From_Daytime;
    private String CreateTime;

    public int getTotal_Throughput() {
        return Total_Throughput;
    }

    public void setTotal_Throughput(int total_Throughput) {
        Total_Throughput = total_Throughput;
    }

    public int getCode_status_5xx() {
        return Code_status_5xx;
    }

    public void setCode_status_5xx(int code_status_5xx) {
        Code_status_5xx = code_status_5xx;
    }

    public int getCode_status_4xx() {
        return Code_status_4xx;
    }

    public void setCode_status_4xx(int code_status_4xx) {
        Code_status_4xx = code_status_4xx;
    }

    public int getCode_status_3xx() {
        return Code_status_3xx;
    }

    public void setCode_status_3xx(int code_status_3xx) {
        Code_status_3xx = code_status_3xx;
    }

    public int getCode_status_2xx() {
        return Code_status_2xx;
    }

    public void setCode_status_2xx(int code_status_2xx) {
        Code_status_2xx = code_status_2xx;
    }

    public Date getFrom_Hours() {
        return From_Hours;
    }

    public void setFrom_Hours(Date from_Hours) {
        From_Hours = from_Hours;
    }

    public Time getFrom_Daytime() {
        return From_Daytime;
    }

    public void setFrom_Daytime(Time from_Daytime) {
        From_Daytime = from_Daytime;
    }

    public String getCreateTime() {

        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }
}
