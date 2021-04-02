package com.rainycrying.nginxavailability.Dao;

import java.util.Arrays;
import java.util.List;

public class Echarts {
    private List<String> data_piename;
    private List<Integer> data_pieall=Arrays.asList(new Integer[]{0});
    private List<Integer> data_pie5xx=Arrays.asList(new Integer[]{0});
    private List<Integer> data_pie4xx=Arrays.asList(new Integer[]{0});
    private List<Integer> data_pie3xx=Arrays.asList(new Integer[]{0});
    private List<Integer> data_pie2xx=Arrays.asList(new Integer[]{0});
    public Echarts(){

        int[][] a={{600,500,400,300,200},{1246492266,150,2174,5547059,1240942883,2021319}};
        a[2][1]=1;
        //定义转换矩阵数组
        int[][] b=new int[a[0].length][a.length];
        //给转换矩阵数组赋值
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                b[j][i]=a[i][j];
            }
        }
        //输出转换后的矩阵数组
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void setData_pieall(List<Integer> data_pieall){
        this.data_pieall = data_pieall;
    }
    public List<Integer> getData_pieall(){
        return this.data_pieall;
    }
    public void setData_pie5xx(List<Integer> data_pie5xx){
        this.data_pie5xx = data_pie5xx;
    }
    public List<Integer> getData_pie5xx(){
        return this.data_pie5xx;
    }
    public void setData_pie4xx(List<Integer> data_pie4xx){
        this.data_pie4xx = data_pie4xx;
    }
    public List<Integer> getData_pie4xx(){
        return this.data_pie4xx;
    }
    public void setData_pie3xx(List<Integer> data_pie3xx){
        this.data_pie3xx = data_pie3xx;
    }
    public List<Integer> getData_pie3xx(){
        return this.data_pie3xx;
    }
    public void setData_pie2xx(List<Integer> data_pie2xx){
        this.data_pie2xx = data_pie2xx;
    }
    public List<Integer> getData_pie2xx(){
        return this.data_pie2xx;
    }

    public List<String> getData_piename() {
        return data_piename;
    }

    public void setData_piename(List<String> data_piename) {
        this.data_piename = data_piename;
    }
}
