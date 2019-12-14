package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private TrelloClient trelloClient;

    public String buildTrelloCardEmail (String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Dziękuje, miłego dnia!");
        context.setVariable("companyName", adminConfig.getCompanyName());
        context.setVariable("preview_message", "Trello board update info");
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildSecondMail (String message) {
        Context context = new Context();
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye_message", "Dziękuje, miłego dnia!");
        context.setVariable("companyName", adminConfig.getCompanyName());
        context.setVariable("preview_message", "Trello board update info");
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("daily_update", trelloClient.getTrelloBoards().size());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
