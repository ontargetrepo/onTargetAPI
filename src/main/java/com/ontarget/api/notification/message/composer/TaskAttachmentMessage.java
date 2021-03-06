package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;

public class TaskAttachmentMessage extends MessageComposer {
	private User user;
	private ProjectTask projectTask;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		projectTask = notificationMessageDAO.getProjectTaskById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.taskId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getTaskAttachmentTemplate();
        messageTemplate= MessageFormat.format(messageTemplate, user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName(), projectTask.getTitle());
		notificationMessage.setMessage(messageTemplate);
	}

}
