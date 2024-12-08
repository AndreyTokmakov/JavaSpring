package department_repository_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicates that this interface is a Spring Data repository.
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    /** **/
}