package com.rainycrying.nginxavailability.Mapper;

import com.rainycrying.nginxavailability.Dao.*;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface DomainReliabilityMapper {
    @Insert("replace into xxl_job_zabbilx_hostlist (product,sysname,ip,op_manager,status) values (#{product},#{sysname},#{ip},#{op_manager},#{status})")
    int insert(DomainReliability DomainReliability);
    //查询一个Host
    @Select("select `id`,`Es_index`,`Domain_Name`,`Reliability`,`Total_Throughput`,`Total_Code_500`,`Total_Code_502`,`Total_Code_503`,`Total_Code_504`,`Total_Code_400`,`Total_Code_403`,`Total_Code_404`,`Total_Code_405`,`Total_Code_408`,`Total_Code_301`,`Total_Code_302`,`Total_Code_304`,`Total_Code_200`,`Total_Code_204`,`Total_Code_206`,`From_Hours`,`From_Daytime`,`CreateTime`,`UpdateTime`\n" +
            "from xxl_job_jt_nginx_availability where Es_index= #{Es_index} ORDER BY Total_Throughput DESC;")
    List<DomainReliability> selectByEs_index(String Esindex);

    //查询索引下的1000条数据
    @Select("select * from xxl_job_jt_nginx_availability   ORDER BY Total_Throughput DESC LIMIT 0,#{Limit_number};" )
    List<DomainReliability> select_ALL_1000(Number Limit_number);
    //查询索引下的1000条数据
    @Select("select * from xxl_job_jt_nginx_availability where Es_index In  (#{Es_index})   ORDER BY Total_Throughput DESC LIMIT 0,1000;" )
    List<DomainReliability> selectBy_Daytime_type1(String Esindex);

    @Select("select * from xxl_job_jt_nginx_availability where Es_index In  (#{Esindex})  and   Domain_Name =  #{Domain_Name}  and ((From_Hours =#{From_Hours}) or (From_Daytime =#{From_Daytime})) ORDER BY Total_Throughput DESC;" )
    List<DomainReliability> selectBy_Daytime_type2(String Esindex,String Domain_Name,String From_Hours,String From_Daytime);
    @Select("select * from xxl_job_jt_nginx_availability where Es_index In  (#{Esindex})  and   Domain_Name in  (${In_Domain})  ORDER BY Total_Throughput DESC;" )
    List<DomainReliability> selectBy_Daytime_type3(String Esindex,String In_Domain);

    @Select("select * from xxl_job_jt_nginx_availability where Es_index In  (#{Esindex})  and   Domain_Name NOT IN  (${Note_in_Domain})  ORDER BY Total_Throughput DESC;" )
    List<DomainReliability> selectBy_Daytime_type4(String Esindex,String Note_in_Domain);


    @Select("select * from xxl_job_jt_nginx_availability where Es_index In  (#{Rlue_es_index}) and   Domain_Name in  (${Rlue_domain_name})   and From_Daytime = #{From_Daytime} ORDER BY Total_Throughput DESC;")
    List<DomainReliability> selectbyInRlue(String Rlue_es_index, String Rlue_domain_name,String From_Daytime);
    @Select("select * from xxl_job_jt_nginx_availability where Es_index In  (#{Rlue_es_index})   and Domain_Name NOT IN  (${Rlue_not_domain_name}) and From_Daytime = #{From_Daytime} ORDER BY Total_Throughput DESC;")
    List<DomainReliability> selectbyNotInRlue(String Rlue_es_index, String Rlue_not_domain_name,String From_Daytime);

//    @Select("select a.Domain_Id,b.* from xxl_job_nginx_domain a,xxl_job_jt_nginx_availability b,xxl_job_nginx_rule c where a.Domain_Name=b.Domain_Name and find_in_set(a.Domain_Id,Rlue_domain_name) and Rlue_name=#{Rlue_name} and From_Daytime= #{From_Daytime} ORDER BY Total_Throughput DESC;")
    @Select("select DISTINCT b.* from xxl_job_nginx_domain a,xxl_job_jt_nginx_availability b,xxl_job_nginx_rule c where a.Domain_Name=b.Domain_Name and find_in_set(a.Domain_Id,Rlue_domain_name) and Rlue_name=#{Rlue_name} and From_Daytime= #{From_Daytime} ORDER BY Total_Throughput DESC;")
    List<DomainReliability> selectbyRlueName(String Rlue_name, String From_Daytime);

    @Select("select DISTINCT b.Domain_Name,b.Total_Throughput,b.Es_index,DATE_FORMAT(From_Hours,'%Y-%m-%d-%H') as From_Hours  from xxl_job_nginx_domain a,xxl_job_jt_nginx_availability b,xxl_job_nginx_rule c where a.Domain_Name=b.Domain_Name and find_in_set(a.Domain_Id,Rlue_domain_name) and Rlue_name=#{Rlue_name} and From_Hours like \"%${From_Daytime}%\" ORDER BY Total_Throughput DESC;")
    List<DomainReliability> selectHoursbyRlueName(String Rlue_name, String From_Daytime);

    @Select("select DISTINCT b.Domain_Name,b.Total_Throughput,b.Es_index from xxl_job_nginx_domain a,xxl_job_jt_nginx_availability b,xxl_job_nginx_rule c where a.Domain_Name=b.Domain_Name and find_in_set(a.Domain_Id,Rlue_domain_name) and Rlue_name=#{Rlue_name} and From_Daytime= #{From_Daytime} ORDER BY Total_Throughput DESC;")

    List<DomainReliability> selectHoursbyRlueName_Domain(String Rlue_name, String From_Daytime);

    @Select("select Total_Throughput,Total_Code_500 + Total_Code_502+Total_Code_503+Total_Code_504  as Code_status_5xx ,Total_Code_400+Total_Code_403+Total_Code_404+Total_Code_405+Total_Code_408 as Code_status_4xx,Total_Code_301+Total_Code_302+Total_Code_304 as Code_status_3xx,Total_Code_200+Total_Code_204+Total_Code_206 as Code_status_2xx,From_Hours,From_Daytime,DATE_FORMAT(CreateTime,'%m.%d.%H') as CreateTime from xxl_job_jt_nginx_availability where Domain_Name =#{Domain_Name} and    ${SFrom_DaytimeType} BETWEEN #{SStartTime} AND #{SEndTime} ORDER BY #{SFrom_DaytimeType} DESC limit 100;")
    List<DomainHistry> selectDomainHistry(String Domain_Name, String SFrom_DaytimeType, String SStartTime, String SEndTime);

    @Select("select DISTINCT Domain_Name from xxl_job_nginx_domain limit 1000;")
    List<DomainTip> selectDomainTip();

}
