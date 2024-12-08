package department_repository_service;


import java.util.List;

public interface DepartmentService
{
    /**
     * Saves a department entity.
     * @param department the department to save
     * @return the saved department
     */
    Department saveDepartment(Department department);

    /**
     * Fetches the list of all department entities.
     * @return a list of departments
     */
    List<Department> fetchDepartmentList();

    /**
     * Updates an existing department entity.
     * @param department the department with updated information
     * @param departmentId the ID of the department to update
     * @return the updated department
     */
    Department updateDepartment(Department department, Long departmentId);

    /**
     * Deletes a department entity by its ID.
     * @param departmentId the ID of the department to delete
     */
    void deleteDepartmentById(Long departmentId);
}