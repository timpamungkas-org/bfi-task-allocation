package id.co.bfi.bfitaskallocation.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskAssignment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="transactioncode")
  private String transactionCode;

  @Column(name="modulename")
  private String moduleName;

  @Column(name="taskname")
  private String taskName;

  @Column(name="taskdescription")
  private String taskDescription;

  @Column(name="linkurl")
  private String linkUrl;

  @Column(name="assignmenttype")
  private String assignmentType;

  @Column(name="assignto")
  private String assignTo;

  @Column(name="taskstatus")
  private String taskStatus;

  @CreationTimestamp
  @Column(name="created_at")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name="updated_at")
  private LocalDateTime updatedAt;
}
