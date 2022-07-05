package id.co.bfi.bfitaskallocation.activity;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.co.bfi.bfitaskallocation.service.UserCamundaService;

@Component
public class RoundRobinActivity implements JavaDelegate {

  @Autowired
  private UserCamundaService _userService;
  
  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String groupName = (String) execution.getVariable("assignToGroup");
    System.out.println("The group name is: " + groupName);
    String assignTo = _userService.getUserByRoundRobin(execution, groupName);
    execution.setVariable("assignToUser", assignTo);
  }
  
}
