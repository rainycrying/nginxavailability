package com.rainycrying.nginxavailability.Services;


import com.rainycrying.nginxavailability.Dao.*;

import java.util.List;

public interface DomainReliabilityMailRuleService {
    //增加一个Person
    List<DomainReliabilityMailRule> insertMailRulePerson(DomainReliabilityMailRule domainReliabilityMailRule);

    //查询发送邮件规则
    List<DomainReliabilityMailRule> selectMailRulebyName(String Rlue_name);

    //查询所有邮件规则
    List<DomainReliabilityMailRule> selectALLMailRuleName();

}
