package com.rainycrying.nginxavailability.Dao;

public class Host {
    private int id ;
    private String product;
    private String sysname;
    private String ip;
    private String op_manager;
    private int status;
    public Host() {
    }
    public Host(int id, String product, String sysname, String ip, String op_manager, int status) {
        this.id = id;
        this.product = product;
        this.sysname = sysname;
        this.ip = ip;
        this.op_manager = op_manager;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOp_manager() {
        return op_manager;
    }

    public void setOp_manager(String op_manager) {
        this.op_manager = op_manager;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    //getter和setter方法
    //toString方法
}
