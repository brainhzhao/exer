package priv.zh;

import org.activiti.engine.*;

import org.activiti.engine.identity.Group;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ActivitiTest {

    ProcessEngine processEngine;
    RepositoryService repositoryService;
    IdentityService identityService;
    RuntimeService runtimeService;
    TaskService taskService;
    DynamicBpmnService dynamicBpmnService;
    HistoryService historyService;
    ManagementService managementService;

    @Before
    public void initProcessEngine() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        processEngine = processEngineConfiguration.buildProcessEngine();
        repositoryService = processEngine.getRepositoryService();
        identityService = processEngine.getIdentityService();
        runtimeService = processEngine.getRuntimeService();
        taskService = processEngine.getTaskService();
        dynamicBpmnService = processEngine.getDynamicBpmnService();
        historyService = processEngine.getHistoryService();
        managementService = processEngine.getManagementService();
    }

    @Test
    public void createTable() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration
                .setJdbcUrl("jdbc:mysql://localhost:3306/activitidemo?useUnicode=true&characterEncoding=utf8");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("123456");
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        processEngine.getRepositoryService();
        System.out.println("create table success");

    }

    @Test
    public void createProcessEngineByConfiguration() {

        /*
         * ProcessEngineConfiguration processEngineConfiguration =
         * ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(
         * "activiti.cfg.xml"); ProcessEngine processEngine =
         * processEngineConfiguration.buildProcessEngine();
         * System.out.println(processEngine.getName());
         */
        // ProcessEngines.init();
        // ProcessEngine processEngine = ProcessEngines.getProcessEngine("default");
        // System.out.println(processEngine.getName());
        // System.out.println(processEngine.get);
    }

    @Test
    public void createGroup() {
        IdentityService identityService = processEngine.getIdentityService();
        Group group = identityService.newGroup(UUID.randomUUID().toString());

        group.setName("总行组");
        group.setType("headOffice");
        identityService.saveGroup(group);
        System.out.println("save success,group counts is " + identityService.createGroupQuery().count());
        Group searchGroup = identityService.createGroupQuery().singleResult();
        System.out.println(
                "group:" + searchGroup.getId() + ",name:" + searchGroup.getName() + ",type:" + searchGroup.getType());
    }

    @Test
    public void createUser() {

        // identityService.createGroupQuery().groupId("122").list();
        Map<String, Object> keyValues = new HashMap<>();
        // keyValues.put()
        System.out.println();
    }
}