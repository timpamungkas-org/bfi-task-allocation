package id.co.bfi.bfitaskallocation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.bfi.bfitaskallocation.dto.CreateTaskAssignmentRequest;
import id.co.bfi.bfitaskallocation.dto.TaskAssignmentResponse;
import id.co.bfi.bfitaskallocation.service.TaskAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Tag(name = "TaskAssignment", description = "Controller for CRUD Task Assignment")
public class TaskAssignmentController {
  @Autowired
  private TaskAssignmentService taskAssignmentService;


  @PostMapping("/taskAssignment")
  @Operation(summary = "Create a new Task Assignment", operationId = "Hai")
  public TaskAssignmentResponse createTaskAssignment(
      @Valid @RequestBody CreateTaskAssignmentRequest CreateTaskAssignmentRequest
    ) {
    log.info("Invoking post on /dummy route");
    return taskAssignmentService.createTaskAssignment(CreateTaskAssignmentRequest);
  }

}
