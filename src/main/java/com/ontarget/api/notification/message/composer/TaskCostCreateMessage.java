package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.ProjectTask;
import com.ontarget.util.NotificationConstant;

public class TaskCostCreateMessage extends MessageComposer {
	private ProjectTask projectTask;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		projectTask = notificationMessageDAO.getProjectTaskById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.taskId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getTaskCreateTemplate();
        messageTemplate= MessageFormat.format(messageTemplate, projectTask.getTitle());
		notificationMessage.setMessage(messageTemplate);
	}
}
