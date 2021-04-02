package com.rainycrying.nginxavailability.Mapper;

import com.rainycrying.nginxavailability.Dao.Host;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface HostMapper {
    //增加一个Host
//    @Insert("replace into xxl_job_zabbilx_hostlist(id,product,sysname,ip,op_manager,status)values(#{id},#{product},#{sysname},#{ip},#{op_manager},#{status})")
//    int insert(Host host);
    @Insert("replace into xxl_job_zabbilx_hostlist (product,sysname,ip,op_manager,status) values (#{product},#{sysname},#{ip},#{op_manager},#{status})")
    int insert(Host host);
    //查询一个Host
    @Select("select id,product,sysname,ip,op_manager,status from xxl_job_zabbilx_hostlist where id = #{id}")
    Host selectByPrimaryKey(Integer id);

    //查询一个Host
    @Select("select id,product,sysname,ip,op_manager,status from xxl_job_zabbilx_hostlist where ip = #{ip} LIMIT 0,1 ")
    Host selectByPersonIp(String ip);

    //查询一个Host
    @Update("UPDATE xxl_job_zabbilx_hostlist SET status =  #{status} WHERE id = #{id}")
    int updateByHostId(Integer id, String status);

    //查询所有的Host
    @Select("select * from xxl_job_zabbilx_hostlist ORDER BY product ASC")
    List<Host> selectAllHost();
    //查询所有的启用状态的Host
    @Select("select * from xxl_job_zabbilx_hostlist where status =0 ORDER BY product ASC")
    List<Host> selectAllEnableHost();
    //查询所有的禁用状态的Host
    @Select("select * from xxl_job_zabbilx_hostlist where status =1 ORDER BY product ASC")
    List<Host> selectAllDisableHost();

}