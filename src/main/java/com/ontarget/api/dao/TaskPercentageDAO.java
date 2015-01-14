package com.ontarget.api.dao;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.TaskPercentage;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/24/14.
 */
@Repository
public interface TaskPercentageDAO {


    public Map<Task, List<TaskPercentage>> getTaskPercentageCompletes(int projectId) throws Exception;

    public Map<Task, Map<TaskInterval, TaskPercentage>> getTaskPercentageCompletesByMonthYear(long projectId) throws Exception;

    public int addTaskPercentageComplete(TaskPercentage taskPercentage) throws Exception;

    public boolean updateTaskPercentageComplete(TaskPercentage cost) throws Exception;

    boolean expireTaskPercentage(int taskPercentageLogId) throws Exception;

    public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception;

    public TaskPercentage getExistingTaskPercentageForTheMonth() throws Exception;
}
