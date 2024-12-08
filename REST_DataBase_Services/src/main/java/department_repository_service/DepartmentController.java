package department_repository_service;

import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    public DepartmentController()
    {
        log.info("{} created!", this.getClass().getSimpleName());
    }

    /**
     * Handles POST requests to save a new department.
     * @param department the department entity to be saved
     * @return the saved department entity
     */
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("DepartmentController::saveDepartment({}) called", department);
        return departmentService.saveDepartment(department);
    }

    /**
     * Handles GET requests to fetch the list of all departments.
     * @return a list of department entities
     */
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        log.info("DepartmentController::fetchDepartmentList() called");
        return departmentService.fetchDepartmentList();
    }

    /**
     * Handles PUT requests to update an existing department.
     * @param department the department entity with updated information
     * @param departmentId the ID of the department to be updated
     * @return the updated department entity
     */
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@RequestBody Department department,
                                       @PathVariable("id") Long departmentId)
    {
        log.info("DepartmentController::updateDepartment({} {}) called", department, departmentId);
        return departmentService.updateDepartment(department, departmentId);
    }

    /**
     * Handles DELETE requests to remove a department by ID.
     * @param departmentId the ID of the department to be deleted
     * @return a success message
     */
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        log.info("DepartmentController::deleteDepartmentById({}) called", departmentId);
        departmentService.deleteDepartmentById(departmentId);
        return "Deleted Successfully";
    }
}