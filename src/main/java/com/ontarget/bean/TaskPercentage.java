package com.ontarget.bean;

import java.util.Date;

/**
 * Created by Owner on 11/24/14.
 */
public class TaskPercentage {

    private int id;
    private Task task;
    private Date fromDate;
    private Date toDate;
    private String taskPercentageType; //
    private Double taskPercentageComplete;
    private int month;
    private int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getTaskPercentageType() {
        return taskPercentageType;
    }

    public void setTaskPercentageType(String taskPercentageType) {
        this.taskPercentageType = taskPercentageType;
    }

    public Double getTaskPercentageComplete() {
        return taskPercentageComplete;
    }

    public void setTaskPercentageComplete(Double taskPercentageComplete) {
        this.taskPercentageComplete = taskPercentageComplete;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "TaskPercentage{" +
                "id=" + id +
                ", task=" + task +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", taskPercentageType='" + taskPercentageType + '\'' +
                ", taskPercentageComplete=" + taskPercentageComplete +
                ", month=" + month +
                ", year=" + year +
                '}';
    }


}