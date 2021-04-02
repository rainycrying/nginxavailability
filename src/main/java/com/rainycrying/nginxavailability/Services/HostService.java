package com.rainycrying.nginxavailability.Services;

import com.rainycrying.nginxavailability.Dao.Host;

import java.util.List;

public interface HostService {
    //增加一个Person
    int insertPerson(Host host);
    //查询一个Person
    Host selectByPersonId(Integer id);
    //查询一个Person
    Host selectByPersonIp(String ip);
    //查询一个Person
    int updateByHostId(Integer id, String status);
    //查询所有的Person
    List<Host> selectAllHost();
    //查询所有的启用状态的Hots
    List<Host> selectAllEnableHost();
    //查询所有的禁用状态的Hots
    List<Host> selectAllDisableHost();
}