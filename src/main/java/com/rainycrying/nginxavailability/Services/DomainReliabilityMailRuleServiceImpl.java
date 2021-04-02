package com.rainycrying.nginxavailability.Services;

import com.rainycrying.nginxavailability.Dao.DomainReliabilityMailRule;
import com.rainycrying.nginxavailability.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomainReliabilityMailRuleServiceImpl implements DomainReliabilityMailRuleService {
    @Autowired
    private DomainReliabilityMailMapper domainReliabilityMailMapper;
    @Override
    public List<DomainReliabilityMailRule> insertMailRulePerson(DomainReliabilityMailRule domainReliabilityMailRule) {
        return domainReliabilityMailMapper.insertMailRulePerson(domainReliabilityMailRule);
    }

    @Override
    public List<DomainReliabilityMailRule> selectMailRulebyName(String Rlue_name) {
        return domainReliabilityMailMapper.selectRlue_name(Rlue_name);
    }

    @Override
    public List<DomainReliabilityMailRule> selectALLMailRuleName() {
        return domainReliabilityMailMapper.selectALLRlue_name();
    }
}
