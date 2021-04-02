package com.rainycrying.nginxavailability.Services;

import com.rainycrying.nginxavailability.Dao.DomainHistry;
import com.rainycrying.nginxavailability.Dao.DomainReliability;
import com.rainycrying.nginxavailability.Dao.DomainTip;

import java.util.List;
public interface DomainReliabilityService {
    //增加一个Person
    int insertPerson(DomainReliability domain__reliability);
    //查询一个Person
    List<DomainReliability> selectByPersones_index(String  Es_index);

    //查询所有数据
    List<DomainReliability> select_ALL_1000(Number  Limit_number);

    //查询一个Person
    List<DomainReliability> selectBy_Daytime_type1(String Esindex);

    //查询一个Person
    List<DomainReliability> selectBy_Daytime_type2(String Esindex,String Domain_Name,String From_Hours,String From_Daytime);

    List<DomainReliability> selectBy_Daytime_type3(String Esindex,String In_Domain);
    List<DomainReliability> selectBy_Daytime_type4(String Esindex,String Note_in_Domain);
    List<DomainReliability> selectByPersonInRlue(String Rlue_es_index,String Rlue_domain_name,String From_Daytime);
    List<DomainReliability> selectByPersonNotIninRlue(String Rlue_es_index,String Rlue_not_domain_name,String From_Daytime);
    List<DomainReliability> selectByPersonRlueName(String RlueName,String From_Daytime);

    List<DomainReliability> selectHoursByPersonRlueName(String RlueName,String From_Daytime);
    List<DomainReliability> selectHoursByPersonRlueName_Domain(String RlueName,String From_Daytime);


    List<DomainHistry> selectDomainHistryByDomainName(String Domain_Name, String SFrom_Daytime_Type, String SStartTime, String SEndTime);

    List<DomainTip> selectALLDomainTip();

}
