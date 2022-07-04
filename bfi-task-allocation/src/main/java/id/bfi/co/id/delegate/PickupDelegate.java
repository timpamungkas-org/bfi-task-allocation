package id.bfi.co.id.delegate;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.bfi.co.id.service.GroupCamundaService;

@Component
public class PickupDelegate implements JavaDelegate{
  @Autowired
  private GroupCamundaService _groupService;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String groupName = (String) execution.getVariable("assignToGroup");

    if (!isBlankString(groupName)) {
        List<String> listUserName = _groupService.getListMemberGroupByGroupName(execution, groupName);
        execution.setVariable("userGroup", listUserName);
    }
    
  }

  private boolean isBlankString(String string) {
    return string == null || string.trim().isEmpty();
}
  
}
