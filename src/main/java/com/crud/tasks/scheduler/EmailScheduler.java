package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(fixedDelay = 10000)
    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + messageSize(size) + "",""));
    }

    private String messageSize (long size) {
        if (size <= 1)
            return size + "task";
        else
            return size + "tasks";
    }
}
