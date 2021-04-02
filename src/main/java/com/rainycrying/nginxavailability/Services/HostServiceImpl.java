package com.rainycrying.nginxavailability.Services;

import com.rainycrying.nginxavailability.Dao.Host;
import com.rainycrying.nginxavailability.Mapper.HostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {
    @Autowired
    private HostMapper hostMapper;
    @Override
    public int insertPerson(Host host) {
        return hostMapper.insert(host);
    }
    @Override
    public Host selectByPersonId(Integer id) {
        return hostMapper.selectByPrimaryKey(id);
    }

    @Override
    public Host selectByPersonIp(String ip) {
        return hostMapper.selectByPersonIp(ip);
    }
    @Override
    public int updateByHostId(Integer id, String status) {
        return hostMapper.updateByHostId(id,status);
    }

    @Override
    public List<Host> selectAllHost() {
        return hostMapper.selectAllHost();
    }

    @Override
    public List<Host> selectAllEnableHost() {
        return hostMapper.selectAllEnableHost();
    }
    @Override
    public List<Host> selectAllDisableHost() {
        return hostMapper.selectAllDisableHost();
    }
}