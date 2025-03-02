package io.todoapp.repository;

import io.todoapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Transactional
    @Modifying
    @Query("UPDATE Task SET isComplete = true WHERE id = :taskId")
    public int markTaskAsComplete(@NonNull String taskId);
    //public int markTaskAsComplete(@NonNull @Param("taskId") String taskId);

    @Transactional
    @Modifying
    @Query("""
            update Task t set t.taskHeading = :taskHeading1, t.taskDescription = :taskDescription2,
            t.status = :status3
            where id = :taskId""")
    int updateTask(@Param("taskHeading") String taskHeading,
                   @Param("taskDescription") String taskDescription,
                   @Param("status") String status,
                   @NonNull @Param("taskId") String taskId
                   );
}