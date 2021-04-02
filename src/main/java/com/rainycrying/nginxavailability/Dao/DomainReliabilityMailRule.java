package com.rainycrying.nginxavailability.Dao;

public class DomainReliabilityMailRule {
    private int Rlue_id;
    private String Rlue_name;
    private String Rlue_user;
    private String Rlue_group;
    private String Rlue_es_index;
    private String Rlue_domain_name;
    private String Rlue_not_domain_name;
    public DomainReliabilityMailRule(){

    }
    public int getRlue_id() {
        return Rlue_id;
    }

    public void setRlue_id(int rlue_id) {
        Rlue_id = rlue_id;
    }

    public String getRlue_name() {
        return Rlue_name;
    }

    public void setRlue_name(String rlue_name) {
        Rlue_name = rlue_name;
    }

    public String getRlue_user() {
        return Rlue_user;
    }

    public void setRlue_user(String rlue_user) {
        Rlue_user = rlue_user;
    }

    public String getRlue_group() {
        return Rlue_group;
    }

    public void setRlue_group(String rlue_group) {
        Rlue_group = rlue_group;
    }

    public String getRlue_es_index() {
        return Rlue_es_index;
    }

    public void setRlue_es_index(String rlue_es_index) {
        Rlue_es_index = rlue_es_index;
    }

    public String getRlue_domain_name() {
        return Rlue_domain_name;
    }

    public void setRlue_domain_name(String rlue_domain_name) {
        Rlue_domain_name = rlue_domain_name;
    }

    public String getRlue_not_domain_name() {
        return Rlue_not_domain_name;
    }

    public void setRlue_not_domain_name(String rlue_not_domain_name) {
        Rlue_not_domain_name = rlue_not_domain_name;
    }
}
