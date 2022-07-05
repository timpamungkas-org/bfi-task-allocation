package id.co.bfi.bfitaskallocation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import id.co.bfi.bfitaskallocation.service.GroupCamundaService;

public class GroupCamundaServiceImpl implements GroupCamundaService{

  @Override
  public Integer countGroupByUserName(DelegateExecution execution, String userName) {
    return execution
    .getProcessEngineServices()
    .getIdentityService()
    .createUserQuery()
    .userId(userName)
    .list()
    .size();
  }

  @Override
  public List<String> getListMemberGroupByGroupName(DelegateExecution execution, String groupName) {
    List<String> listUserName = new ArrayList<>();
    System.out.println("The group name is: " + groupName);
    var users = execution.getProcessEngineServices().getIdentityService().createUserQuery()
            .memberOfGroup(groupName).list();

    for (int i = 0; i < users.size(); i++) {
        String userName = users.get(i).getId();
        System.out.println("The username name is: " + userName);
        listUserName.add(userName);
    }
    return listUserName;
  }
  
}
