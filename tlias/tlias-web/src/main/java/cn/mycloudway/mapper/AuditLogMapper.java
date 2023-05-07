package cn.mycloudway.mapper;

import cn.mycloudway.pojo.AuditLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuditLogMapper {
    public void add(AuditLog auditLog);
}
