package uz.mib.center.core.common.db.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import uz.mib.center.core.common.db.BaseMapper;
import uz.mib.center.core.common.db.entities.EmployeeEntity;
import uz.mib.center.core.common.db.entities.EmployeeRoleEntity;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseMapper {

    List<EmployeeEntity> findAll();

    EmployeeEntity findById(Long id);

    List<EmployeeRoleEntity> findRolesByEmployeeId(@Param("employeeId") Long employeeId);

}
