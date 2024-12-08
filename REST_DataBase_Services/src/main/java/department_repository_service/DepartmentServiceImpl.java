package department_repository_service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Log4j2
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    @Override
    public Department saveDepartment(Department department) {
        // Saves and returns the department entity.
        log.info("DepartmentServiceImpl::saveDepartment({}) called", department);
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        // Retrieves and returns a list of all department entities.
        log.info("DepartmentServiceImpl::fetchDepartmentList() called");
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId)
    {
        log.info("DepartmentServiceImpl::updateDepartment({} {}) called", department, departmentId);
        // Finds the existing department by ID.
        Department depDB = departmentRepository.findById(departmentId).get();

        // Updates fields if they are not null or empty.
        if (Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().isEmpty()) {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().isEmpty()) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().isEmpty()) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        // Saves and returns the updated department entity.
        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        // Deletes the department entity by its ID.
        log.info("DepartmentServiceImpl::deleteDepartmentById({}) called", departmentId);
        departmentRepository.deleteById(departmentId);
    }
}