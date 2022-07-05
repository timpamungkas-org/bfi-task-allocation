package id.co.bfi.bfitaskallocation.activity;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import id.co.bfi.bfitaskallocation.service.GroupCamundaService;

@Component
public class PickupActivity implements JavaDelegate{
  @Autowired
  private GroupCamundaService groupService;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    String groupName = (String) execution.getVariable("assignToGroup");

    if (StringUtils.isNotBlank(groupName)) {
        List<String> listUserName = groupService.getListMemberGroupByGroupName(execution, groupName);
        execution.setVariable("userGroup", listUserName);
    }
    
  }
}
