package com.rainycrying.nginxavailability.Dao;

public class DomainReliabilityHours {
    private String  Domain_Name_null="0";
    private int id;
    private String Es_index;
    private String Domain_Name;
    private Float Reliability;
    private Object Total_Throughput  =0;
    private Object Total_00Throughput =Domain_Name_null;
    private int Total_00Reliability;
    private Object Total_01Throughput =Domain_Name_null;
    private int Total_01Reliability;
    private Object Total_02Throughput =Domain_Name_null;
    private int Total_02Reliability;
    private Object Total_03Throughput =Domain_Name_null;
    private int Total_03Reliability;
    private Object Total_04Throughput =Domain_Name_null;
    private int Total_04Reliability;
    private Object Total_05Throughput =Domain_Name_null;
    private int Total_05Reliability;
    private Object Total_06Throughput =Domain_Name_null;
    private int Total_06Reliability;
    private Object Total_07Throughput =Domain_Name_null;
    private int Total_07Reliability;
    private Object Total_08Throughput =Domain_Name_null;
    private int Total_08Reliability;
    private Object Total_09Throughput =Domain_Name_null;
    private int Total_09Reliability;
    private Object Total_10Throughput =Domain_Name_null;
    private int Total_10Reliability;
    private Object Total_11Throughput =Domain_Name_null;
    private int Total_11Reliability;
    private Object Total_12Throughput =Domain_Name_null;
    private int Total_12Reliability;
    private Object Total_13Throughput =Domain_Name_null;
    private int Total_13Reliability;
    private Object Total_14Throughput =Domain_Name_null;
    private int Total_14Reliability;
    private Object Total_15Throughput =Domain_Name_null;
    private int Total_15Reliability;

    private Object Total_16Throughput =Domain_Name_null;
    private int Total_16Reliability;
    private Object Total_17Throughput =Domain_Name_null;
    private int Total_17Reliability;
    private Object Total_18Throughput =Domain_Name_null;
    private int Total_18Reliability;
    private Object Total_19Throughput =Domain_Name_null;
    private int Total_19Reliability;
    private Object Total_20Throughput =Domain_Name_null;
    private int Total_20Reliability;
    private Object Total_21Throughput =Domain_Name_null;
    private int Total_21Reliability;
    private Object Total_22Throughput =Domain_Name_null;
    private int Total_22Reliability;
    private Object Total_23Throughput =Domain_Name_null;
    private int Total_23Reliability;
    private Object Set_All_DomainReliabilityHours;
    public void Set_All_ThroughputHours(String Hours, Object total_Tmp_Throughput){
        switch (Hours){
            case "00":
                this.setTotal_00Throughput(total_Tmp_Throughput);
                break;
            case "01":
                this.setTotal_01Throughput(total_Tmp_Throughput);
                break;
            case "02":
                this.setTotal_02Throughput(total_Tmp_Throughput);
                break;
            case "03":
                this.setTotal_03Throughput(total_Tmp_Throughput);
                break;
            case "04":
                this.setTotal_04Throughput(total_Tmp_Throughput);
                break;
            case "05":
                this.setTotal_05Throughput(total_Tmp_Throughput);
                break;
            case "06":
                this.setTotal_06Throughput(total_Tmp_Throughput);
                break;
            case "07":
                this.setTotal_07Throughput(total_Tmp_Throughput);
                break;
            case "08":
                this.setTotal_08Throughput(total_Tmp_Throughput);
                break;
            case "09":
                this.setTotal_09Throughput(total_Tmp_Throughput);
                break;
            case "10":
                this.setTotal_10Throughput(total_Tmp_Throughput);
                break;
            case "11":
                this.setTotal_11Throughput(total_Tmp_Throughput);
                break;
            case "12":
                this.setTotal_12Throughput(total_Tmp_Throughput);
                break;
            case "13":
                this.setTotal_13Throughput(total_Tmp_Throughput);
                break;
            case "14":
                this.setTotal_14Throughput(total_Tmp_Throughput);
                break;
            case "15":
                this.setTotal_15Throughput(total_Tmp_Throughput);
                break;
            case "16":
                this.setTotal_16Throughput(total_Tmp_Throughput);
                break;
            case "17":
                this.setTotal_17Throughput(total_Tmp_Throughput);
                break;
            case "18":
                this.setTotal_18Throughput(total_Tmp_Throughput);
                break;
            case "19":
                this.setTotal_19Throughput(total_Tmp_Throughput);
                break;
            case "20":
                this.setTotal_20Throughput(total_Tmp_Throughput);
                break;
            case "21":
                this.setTotal_21Throughput(total_Tmp_Throughput);
                break;
            case "22":
                this.setTotal_22Throughput(total_Tmp_Throughput);
                break;
            case "23":
                this.setTotal_23Throughput(total_Tmp_Throughput);
                break;
        }
    }
    public DomainReliabilityHours(){

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

    public Object getTotal_Throughput() {
        int Total_Throughput1 = Integer.parseInt((String) Total_00Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_01Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_02Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_03Throughput.toString().replace(Domain_Name_null, "0"));
        int Total_Throughput2 = Integer.parseInt((String) Total_04Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_05Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_06Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_07Throughput.toString().replace(Domain_Name_null, "0"));
        int Total_Throughput3 = Integer.parseInt((String) Total_08Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_09Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_10Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_11Throughput.toString().replace(Domain_Name_null, "0"));
        int Total_Throughput4 = Integer.parseInt((String) Total_12Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_13Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_14Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_15Throughput.toString().replace(Domain_Name_null, "0"));
        int Total_Throughput5 = Integer.parseInt((String) Total_16Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_17Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_18Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_19Throughput.toString().replace(Domain_Name_null, "0"));
        int Total_Throughput6 = Integer.parseInt((String) Total_20Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_21Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_22Throughput.toString().replace(Domain_Name_null, "0"))+Integer.parseInt((String) Total_23Throughput.toString().replace(Domain_Name_null, "0"));
        Total_Throughput=Total_Throughput1+Total_Throughput2+Total_Throughput3+Total_Throughput4+Total_Throughput5+Total_Throughput6;
        return Total_Throughput;
    }

    public void setTotal_Throughput(Object total_Throughput) {

    }

    public Object getTotal_00Throughput() {
        return Total_00Throughput;
    }

    public void setTotal_00Throughput(Object total_00Throughput) {
        if (total_00Throughput==null){
            Total_00Throughput = Domain_Name_null;
        }else {
            Total_00Throughput = total_00Throughput;
        }
    }

    public Object getTotal_01Throughput() {
        return Total_01Throughput;
    }

    public void setTotal_01Throughput(Object total_01Throughput) {
        if (total_01Throughput==null){
            Total_01Throughput = Domain_Name_null;
        }else {
            Total_01Throughput = total_01Throughput;
        }
    }

    public Object getTotal_02Throughput() {
        return Total_02Throughput;
    }

    public void setTotal_02Throughput(Object total_02Throughput) {
        if (total_02Throughput==null){
            Total_02Throughput = Domain_Name_null;
        }else {
            Total_02Throughput = total_02Throughput;
        }
    }

    public Object getTotal_03Throughput() {
        return Total_03Throughput;
    }

    public void setTotal_03Throughput(Object total_03Throughput) {
        if (total_03Throughput==null){
            Total_03Throughput = Domain_Name_null;
        }else {
            Total_03Throughput = total_03Throughput;
        }
    }

    public Object getTotal_04Throughput() {
        return Total_04Throughput;
    }

    public void setTotal_04Throughput(Object total_04Throughput) {
        if (total_04Throughput==null){
            Total_04Throughput = Domain_Name_null;
        }else {
            Total_04Throughput = total_04Throughput;
        }
    }

    public Object getTotal_05Throughput() {
        return Total_05Throughput;
    }

    public void setTotal_05Throughput(Object total_05Throughput) {
        if (total_05Throughput==null){
            Total_05Throughput = Domain_Name_null;
        }else {
            Total_05Throughput = total_05Throughput;
        }
    }

    public Object getTotal_06Throughput() {
        return Total_06Throughput;
    }

    public void setTotal_06Throughput(Object total_06Throughput) {
        if (total_06Throughput==null){
            Total_06Throughput = Domain_Name_null;
        }else {
            Total_06Throughput = total_06Throughput;
        }
    }

    public Object getTotal_07Throughput() {
        return Total_07Throughput;
    }

    public void setTotal_07Throughput(Object total_07Throughput) {
        if (total_07Throughput==null){
            Total_07Throughput = Domain_Name_null;
        }else {
            Total_07Throughput = total_07Throughput;
        }
    }

    public Object getTotal_08Throughput() {
        return Total_08Throughput;
    }

    public void setTotal_08Throughput(Object total_08Throughput) {
        if (total_08Throughput==null){
            Total_08Throughput = Domain_Name_null;
        }else {
            Total_08Throughput = total_08Throughput;
        }
    }

    public Object getTotal_09Throughput() {
        return Total_09Throughput;
    }

    public void setTotal_09Throughput(Object total_09Throughput) {
        if (total_09Throughput==null){
            Total_09Throughput = Domain_Name_null;
        }else {
            Total_09Throughput = total_09Throughput;
        }
    }

    public Object getTotal_10Throughput() {
        return Total_10Throughput;
    }

    public void setTotal_10Throughput(Object total_10Throughput) {
        if (total_10Throughput==null){
            Total_10Throughput = Domain_Name_null;
        }else {
            Total_10Throughput = total_10Throughput;
        }
    }

    public Object getTotal_11Throughput() {
        return Total_11Throughput;
    }

    public void setTotal_11Throughput(Object total_11Throughput) {
        if (total_11Throughput==null){
            Total_11Throughput = Domain_Name_null;
        }else {
            Total_11Throughput = total_11Throughput;
        }
    }

    public Object getTotal_12Throughput() {
        return Total_12Throughput;
    }

    public void setTotal_12Throughput(Object total_12Throughput) {
        if (total_12Throughput==null){
            Total_12Throughput = Domain_Name_null;
        }else {
            Total_12Throughput = total_12Throughput;
        }
    }

    public Object getTotal_13Throughput() {
        return Total_13Throughput;
    }

    public void setTotal_13Throughput(Object total_13Throughput) {
        if (total_13Throughput==null){
            Total_13Throughput = Domain_Name_null;
        }else {
            Total_13Throughput = total_13Throughput;
        }
    }

    public Object getTotal_14Throughput() {
        return Total_14Throughput;
    }

    public void setTotal_14Throughput(Object total_14Throughput) {
        if (total_14Throughput==null){
            Total_14Throughput = Domain_Name_null;
        }else {
            Total_14Throughput = total_14Throughput;
        }
    }

    public Object getTotal_15Throughput() {
        return Total_15Throughput;
    }

    public void setTotal_15Throughput(Object total_15Throughput) {
        if (total_15Throughput==null){
            Total_15Throughput = Domain_Name_null;
        }else {
            Total_15Throughput = total_15Throughput;
        }
    }

    public Object getTotal_16Throughput() {
        return Total_16Throughput;
    }

    public void setTotal_16Throughput(Object total_16Throughput) {
        if (total_16Throughput==null){
            Total_16Throughput = Domain_Name_null;
        }else {
            Total_16Throughput = total_16Throughput;
        }
    }

    public Object getTotal_17Throughput() {
        return Total_17Throughput;
    }

    public void setTotal_17Throughput(Object total_17Throughput) {
        if (total_17Throughput==null){
            Total_17Throughput = Domain_Name_null;
        }else {
            Total_17Throughput = total_17Throughput;
        }
    }

    public Object getTotal_18Throughput() {
        return Total_18Throughput;
    }

    public void setTotal_18Throughput(Object total_18Throughput) {
        if (total_18Throughput==null){
            Total_18Throughput = Domain_Name_null;
        }else {
            Total_18Throughput = total_18Throughput;
        }
    }

    public Object getTotal_19Throughput() {
        return Total_19Throughput;
    }

    public void setTotal_19Throughput(Object total_19Throughput) {
        if (total_19Throughput==null){
            Total_19Throughput = Domain_Name_null;
        }else {
            Total_19Throughput = total_19Throughput;
        }
    }

    public Object getTotal_20Throughput() {
        return Total_20Throughput;
    }

    public void setTotal_20Throughput(Object total_20Throughput) {
        if (total_20Throughput==null){
            Total_20Throughput = Domain_Name_null;
        }else {
            Total_20Throughput = total_20Throughput;
        }
    }

    public Object getTotal_21Throughput() {
        return Total_21Throughput;
    }

    public void setTotal_21Throughput(Object total_21Throughput) {
        if (total_21Throughput==null){
            Total_21Throughput = Domain_Name_null;
        }else {
            Total_21Throughput = total_21Throughput;
        }
    }

    public Object getTotal_22Throughput() {
        return Total_22Throughput;
    }

    public void setTotal_22Throughput(Object total_22Throughput) {
        if (total_22Throughput==null){
            Total_22Throughput = Domain_Name_null;
        }else {
            Total_22Throughput = total_22Throughput;
        }
    }

    public Object getTotal_23Throughput() {
        return Total_23Throughput;
    }

    public void setTotal_23Throughput(Object total_23Throughput) {
        if (total_23Throughput==null){
            Total_23Throughput = Domain_Name_null;
        }else {
            Total_23Throughput = total_23Throughput;
        }
    }

}
