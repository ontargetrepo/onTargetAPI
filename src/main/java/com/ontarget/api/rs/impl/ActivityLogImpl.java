package com.ontarget.api.rs.impl;

import com.ontarget.api.service.ActivityLogService;
import com.ontarget.bean.ActivityLog;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.ActivityLogResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
@Component
@Path("/activityLog")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ActivityLogImpl implements com.ontarget.api.rs.ActivityLog {

    private Logger logger = Logger.getLogger(ActivityLogImpl.class);

    @Autowired
    private ActivityLogService activityLogService;

    @Override
    @GET
    @Path("/getLog")
    public ActivityLogResponse getActivityLog(@QueryParam("recentId") long recentId) {
//        System.out.println("activity log called with recentId " + recentId);
        ActivityLogResponse response = new ActivityLogResponse();
        try {
            List<ActivityLog> activityLogs = activityLogService.getActivityLog(recentId);
            if (activityLogs == null || activityLogs.isEmpty()) {
//                System.out.println("empty log returned");
                response.setLogs(new LinkedList<ActivityLog>());
                response.setRecentActivityId(recentId);
            } else {
//                System.out.println("non empty log returned");
                response.setLogs(activityLogs);
                response.setRecentActivityId(activityLogs.get(activityLogs.size() - 1).getId());
            }
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Activity log read");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Authentication error", e);
            response.setReturnMessage("Authentication Error");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }
}