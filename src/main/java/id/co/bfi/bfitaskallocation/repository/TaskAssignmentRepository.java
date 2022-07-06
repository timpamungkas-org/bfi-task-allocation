package id.co.bfi.bfitaskallocation.repository;

import id.co.bfi.bfitaskallocation.entity.TaskAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {}
