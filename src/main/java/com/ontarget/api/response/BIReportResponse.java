package com.ontarget.api.response;

import com.ontarget.bean.TimeSaved;
import com.ontarget.bean.TreesSaved;
import com.ontarget.dto.OnTargetResponse;

/**
 * Created by Owner on 1/10/15.
 */
public class BIReportResponse extends OnTargetResponse{

    public BIReportResponse() {
    }

    private TimeSaved timeSaved;

    private TreesSaved treesSaved;

    public TimeSaved getTimeSaved() {
        return timeSaved;
    }

    public void setTimeSaved(TimeSaved timeSaved) {
        this.timeSaved = timeSaved;
    }

    public TreesSaved getTreesSaved() {
        return treesSaved;
    }

    public void setTreesSaved(TreesSaved treesSaved) {
        this.treesSaved = treesSaved;
    }
}
