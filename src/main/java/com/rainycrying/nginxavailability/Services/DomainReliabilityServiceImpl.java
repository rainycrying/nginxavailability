package com.rainycrying.nginxavailability.Services;

import com.rainycrying.nginxavailability.Dao.DomainHistry;
import com.rainycrying.nginxavailability.Dao.DomainReliability;
import com.rainycrying.nginxavailability.Dao.DomainReliabilityMailRule;
import com.rainycrying.nginxavailability.Dao.DomainTip;
import com.rainycrying.nginxavailability.Mapper.DomainReliabilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainReliabilityServiceImpl implements DomainReliabilityService {
    @Autowired
    private DomainReliabilityMapper domainReliabilityMapper;
    @Override
    public int insertPerson(DomainReliability domainReliability) {
        return domainReliabilityMapper.insert(domainReliability);
    }

    @Override
    public List<DomainReliability> select_ALL_1000(Number  Limit_number) {
        return domainReliabilityMapper.select_ALL_1000(Limit_number);
    }

    @Override
    public List<DomainReliability> selectByPersones_index(String  Es_index) {
        return domainReliabilityMapper.selectByEs_index(Es_index);
    }

    @Override
    public List<DomainReliability> selectBy_Daytime_type1(String Esindex) {
        return domainReliabilityMapper.selectBy_Daytime_type1(Esindex);
    }
    @Override
    public List<DomainReliability> selectBy_Daytime_type2(String Esindex,String Domain_Name,String From_Hours,String From_Daytime) {
        return domainReliabilityMapper.selectBy_Daytime_type2(Esindex,Domain_Name,From_Hours,From_Daytime);
    }
    @Override
    public List<DomainReliability> selectBy_Daytime_type3(String Esindex,String In_Domain) {
        return domainReliabilityMapper.selectBy_Daytime_type3(Esindex,In_Domain);
    }

    @Override
    public List<DomainReliability> selectBy_Daytime_type4(String Esindex,String Note_in_Domain) {
        return domainReliabilityMapper.selectBy_Daytime_type4(Esindex,Note_in_Domain);
    }

    @Override
    public List<DomainReliability> selectByPersonInRlue(String Rlue_es_index, String Rlue_domain_name,String From_Daytime) {
        return domainReliabilityMapper.selectbyInRlue(Rlue_es_index,Rlue_domain_name,From_Daytime);
    }

    @Override
    public List<DomainReliability> selectByPersonNotIninRlue(String Rlue_es_index, String Rlue_not_domain_name, String From_Daytime) {
        return domainReliabilityMapper.selectbyNotInRlue(Rlue_es_index,Rlue_not_domain_name,From_Daytime);
    }

    @Override
    public List<DomainReliability> selectByPersonRlueName(String RlueName, String From_Daytime) {
        return domainReliabilityMapper.selectbyRlueName(RlueName,From_Daytime);
    }

    @Override
    public List<DomainReliability> selectHoursByPersonRlueName(String RlueName, String From_Daytime) {
        return domainReliabilityMapper.selectHoursbyRlueName(RlueName,From_Daytime);
    }

    @Override
    public List<DomainReliability> selectHoursByPersonRlueName_Domain(String RlueName, String From_Daytime) {
        return domainReliabilityMapper.selectHoursbyRlueName_Domain(RlueName,From_Daytime);
    }

    @Override
    public List<DomainHistry> selectDomainHistryByDomainName(String Domain_Name, String SFrom_DaytimeType, String SStartTime, String SEndTime) {
            return domainReliabilityMapper.selectDomainHistry(Domain_Name, SFrom_DaytimeType, SStartTime, SEndTime);
    }

    @Override
    public List<DomainTip> selectALLDomainTip() {
        return domainReliabilityMapper.selectDomainTip();
    }
}
