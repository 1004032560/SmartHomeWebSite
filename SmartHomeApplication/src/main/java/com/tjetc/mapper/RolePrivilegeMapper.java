package com.tjetc.mapper;

import com.tjetc.domain.RolePrivilegeExample;
import com.tjetc.domain.RolePrivilegeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePrivilegeMapper {
    long countByExample(RolePrivilegeExample example);

    int deleteByExample(RolePrivilegeExample example);

    int deleteByPrimaryKey(RolePrivilegeKey key);

    int insert(RolePrivilegeKey record);

    int insertSelective(RolePrivilegeKey record);

    List<RolePrivilegeKey> selectByExample(RolePrivilegeExample example);

    int updateByExampleSelective(@Param("record") RolePrivilegeKey record, @Param("example") RolePrivilegeExample example);

    int updateByExample(@Param("record") RolePrivilegeKey record, @Param("example") RolePrivilegeExample example);
}