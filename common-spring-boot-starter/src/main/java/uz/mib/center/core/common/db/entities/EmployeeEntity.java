package uz.mib.center.core.common.db.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.mib.center.core.common.db.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements BaseEntity {

    private Long id;
    private String fio;
}
