package id.co.bfi.bfitaskallocation.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskAssignmentRequest {

  @NotBlank
  private String transactionCode;

  @NotBlank
  private String moduleName;

  @NotBlank
  private String taskName;

  @NotBlank
  private String taskDescription;

  @NotBlank
  private String linkUrl;

  @NotBlank
  private String assignmentType;

  @NotBlank
  private String assignTo;

  @NotBlank
  private String taskStatus;
}
