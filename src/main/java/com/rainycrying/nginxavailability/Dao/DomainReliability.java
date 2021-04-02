package com.rainycrying.nginxavailability.Dao;

import java.sql.Date;
import java.sql.Time;

public class DomainReliability {
    private int id;
    private String Es_index;
    private String Domain_Name;
    private Float Reliability;
    private int Total_Throughput;
    private int Total_Code_500;
    private int Total_Code_502;
    private int Total_Code_503;
    private int Total_Code_504;
    private int Total_Code_400;
    private int Total_Code_403;
    private int Total_Code_404;
    private int Total_Code_405;
    private int Total_Code_408;
    private int Total_Code_301;
    private int Total_Code_302;
    private int Total_Code_304;
    private int Total_Code_200;
    private int Total_Code_204;
    private int Total_Code_206;
    private String From_Hours;
    private String From_Daytime;
    public DomainReliability(){

    }
    public DomainReliability(int id, String Es_index, String Domain_Name, Float Reliability, int Total_Throughput, int Total_Code_500, int Total_Code_502, int Total_Code_503, int Total_Code_504, int Total_Code_400, int Total_Code_403, int Total_Code_404, int Total_Code_405, int Total_Code_408, int Total_Code_301, int Total_Code_302, int Total_Code_304, int Total_Code_200, int Total_Code_204, int Total_Code_206, String From_Hours, String From_Daytime) {
        this.id = id;
        this.Es_index = Es_index;
        this.Domain_Name = Domain_Name;
        this.Reliability = Reliability;
        this.Total_Throughput = Total_Throughput;
        this.Total_Code_500 = Total_Code_500;
        this.Total_Code_502= Total_Code_502;
        this.Total_Code_503= Total_Code_503;
        this.Total_Code_504= Total_Code_504;
        this.Total_Code_400= Total_Code_400;
        this.Total_Code_403= Total_Code_403;
        this.Total_Code_404= Total_Code_404;
        this.Total_Code_405= Total_Code_405;
        this.Total_Code_408= Total_Code_408;
        this.Total_Code_301= Total_Code_301;
        this.Total_Code_302= Total_Code_302;
        this.Total_Code_304= Total_Code_304;
        this.Total_Code_200= Total_Code_200;
        this.Total_Code_204= Total_Code_204;
        this.Total_Code_206= Total_Code_206;
        this.From_Hours= From_Hours;
        this.From_Daytime= From_Daytime;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEs_index() {
        return Es_index;
    }

    public void setEs_index(String es_index) {
        Es_index = es_index;
    }

    public String getDomain_Name() {
        return Domain_Name;
    }

    public void setDomain_Name(String domain_Name) {
        Domain_Name = domain_Name;
    }

    public Float getReliability() {
        return Reliability;
    }

    public void setReliability(Float reliability) {
        Reliability = reliability;
    }

    public int getTotal_Throughput() {
        return Total_Throughput;
    }

    public void setTotal_Throughput(int total_Throughput) {
        Total_Throughput = total_Throughput;
    }

    public int getTotal_Code_500() {
        return Total_Code_500;
    }

    public void setTotal_Code_500(int total_Code_500) {
        Total_Code_500 = total_Code_500;
    }

    public int getTotal_Code_502() {
        return Total_Code_502;
    }

    public void setTotal_Code_502(int total_Code_502) {
        Total_Code_502 = total_Code_502;
    }

    public int getTotal_Code_503() {
        return Total_Code_503;
    }

    public void setTotal_Code_503(int total_Code_503) {
        Total_Code_503 = total_Code_503;
    }

    public int getTotal_Code_504() {
        return Total_Code_504;
    }

    public void setTotal_Code_504(int total_Code_504) {
        Total_Code_504 = total_Code_504;
    }

    public int getTotal_Code_400() {
        return Total_Code_400;
    }

    public void setTotal_Code_400(int total_Code_400) {
        Total_Code_400 = total_Code_400;
    }

    public int getTotal_Code_403() {
        return Total_Code_403;
    }

    public void setTotal_Code_403(int total_Code_403) {
        Total_Code_403 = total_Code_403;
    }

    public int getTotal_Code_404() {
        return Total_Code_404;
    }

    public void setTotal_Code_404(int total_Code_404) {
        Total_Code_404 = total_Code_404;
    }

    public int getTotal_Code_405() {
        return Total_Code_405;
    }

    public void setTotal_Code_405(int total_Code_405) {
        Total_Code_405 = total_Code_405;
    }

    public int getTotal_Code_408() {
        return Total_Code_408;
    }

    public void setTotal_Code_408(int total_Code_408) {
        Total_Code_408 = total_Code_408;
    }

    public int getTotal_Code_301() {
        return Total_Code_301;
    }

    public void setTotal_Code_301(int total_Code_301) {
        Total_Code_301 = total_Code_301;
    }

    public int getTotal_Code_302() {
        return Total_Code_302;
    }

    public void setTotal_Code_302(int total_Code_302) {
        Total_Code_302 = total_Code_302;
    }

    public int getTotal_Code_304() {
        return Total_Code_304;
    }

    public void setTotal_Code_304(int total_Code_304) {
        Total_Code_304 = total_Code_304;
    }

    public int getTotal_Code_200() {
        return Total_Code_200;
    }

    public void setTotal_Code_200(int total_Code_200) {
        Total_Code_200 = total_Code_200;
    }

    public int getTotal_Code_204() {
        return Total_Code_204;
    }

    public void setTotal_Code_204(int total_Code_204) {
        Total_Code_204 = total_Code_204;
    }

    public int getTotal_Code_206() {
        return Total_Code_206;
    }

    public void setTotal_Code_206(int total_Code_206) {
        Total_Code_206 = total_Code_206;
    }

    public String getFrom_Hours() {
        return From_Hours;
    }

    public void setFrom_Hours(String from_Hours) {
        From_Hours = from_Hours;
    }

    public String getFrom_Daytime() {
        return From_Daytime;
    }

    public void setFrom_Daytime(String from_Daytime) {
        From_Daytime = from_Daytime;
    }
}
