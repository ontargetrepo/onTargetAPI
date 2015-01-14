package com.ontarget.api.dao;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetDAO {

    public Map<String, Object> getMinStartMaxEndDate(long projectId, String costType) throws Exception;


    public Map<Task,List<TaskEstimatedCost>> getTaskToCostMap(long projectId,String costType) throws Exception;


    Map<Task, Map<TaskInterval,TaskEstimatedCost>> getTaskToCostMapByMonthYear(long projectId, String costType) throws Exception;

    Map<Task, Map<TaskInterval, List<TaskEstimatedCost>>> getTaskCostMapByTask(int projectTaskId) throws Exception;

    Task getTaskCostByTask(Task task) throws Exception;

    Map<TaskInterval, List<TaskEstimatedCost>> getTaskCostByTaskMonthYear(int projectTaskId) throws Exception;
}
