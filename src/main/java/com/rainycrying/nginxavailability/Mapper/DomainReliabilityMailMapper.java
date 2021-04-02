package com.rainycrying.nginxavailability.Mapper;

import com.rainycrying.nginxavailability.Dao.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DomainReliabilityMailMapper {
    //查询一个Host
    @Select("select * from xxl_job_jt_nginx_availability where Es_index= #{Es_index};")
    List<DomainReliabilityMailRule> insertMailRulePerson(DomainReliabilityMailRule Esindex);

    //查询一个Host
    @Select("select * from xxl_job_nginx_rule where Rlue_name=#{Rlue_name} ;")
    List<DomainReliabilityMailRule> selectRlue_name(String Rlue_name);


    //查询所有规则
    @Select("select * from xxl_job_nginx_rule;")
    List<DomainReliabilityMailRule> selectALLRlue_name();
}
