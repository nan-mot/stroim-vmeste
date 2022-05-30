package ru.ssau.stroimvmeste2.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.ssau.stroimvmeste2.dto.MessageDto;
import ru.ssau.stroimvmeste2.dto.ProjectFullDto;
import ru.ssau.stroimvmeste2.dto.ProjectLiteDto;
import ru.ssau.stroimvmeste2.dto.TopicFullDto;
import ru.ssau.stroimvmeste2.dto.TopicLiteDto;
import ru.ssau.stroimvmeste2.dto.UserLiteDto;
import ru.ssau.stroimvmeste2.model.Message;
import ru.ssau.stroimvmeste2.model.Topic;
import ru.ssau.stroimvmeste2.service.MessageService;
import ru.ssau.stroimvmeste2.service.ProjectService;
import ru.ssau.stroimvmeste2.service.TopicService;
import ru.ssau.stroimvmeste2.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TopicJspController {
    private final TopicService topicService;
    private final ProjectService projectService;

    private final MessageService messageService;
    private final UserService userService;
    @GetMapping("/topics/all")
    public String viewTopics(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "topics";
    }

    @GetMapping("/projects/topics/{id}")
    public String viewTopicFullDto(Model model, @PathVariable Integer id) {
        Optional<TopicFullDto> optional = topicService.getTopic(id);
        if (optional.isEmpty()) {
            model.addAttribute("entity", "Topic");
            return "not-found";
        }
        model.addAttribute("topic", optional.get());
        return "topic";
    }

    @GetMapping("/projects/topics/addTopic")
    public String addUserView(Model model) {
        model.addAttribute("topic", new Topic());
        List<ProjectLiteDto> projects = projectService.getAllProjects();
        model.addAttribute("projects", projects);
        return "add-topic";
    }

    @PostMapping("/projects/topics/addTopic")
    public RedirectView addTopic(@ModelAttribute("topic") Topic topic, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/projects/all", true);
        Topic savedTopic = topicService.addTopic(topic);
        redirectAttributes.addFlashAttribute("savedTopic", savedTopic);
        redirectAttributes.addFlashAttribute("addTopicSuccess", true);
        return redirectView;
    }
    @GetMapping("/projects/topics/updateTopic/{id}")
    public String updateTopicView(Model model, @PathVariable Integer id) {
        Optional<TopicFullDto> optional = topicService.getTopic(id);
        if (optional.isEmpty()) {
            model.addAttribute("entity", "Topic");
            return "not-found";
        }
        model.addAttribute("topic", topicService.getTopic(id));
        return "update-topic";
    }
    @PostMapping("/projects/topics/updateTopic")
    public RedirectView updateTopic(@ModelAttribute("topic") Topic topic, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/projects/all", true);
        Topic updatedTopic = topicService.updateTopic(topic);
        redirectAttributes.addFlashAttribute("updatedTopic", updatedTopic);
        redirectAttributes.addFlashAttribute("updateTopicSuccess", true);
        return redirectView;
    }

    @GetMapping("/projects/topics/addMessage")
    public String addMessageView(Model model) {
        model.addAttribute("message", new Message());
        List<UserLiteDto> users = userService.getAllUsers();
        model.addAttribute("users", users);
        List<TopicLiteDto> topics = topicService.getAllTopics();
        model.addAttribute("topics", topics);
        return "add-message";
    }

    @PostMapping("/projects/topics/addMessage")
    public RedirectView addMessage(@ModelAttribute("message") Message message, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("/projects/all", true);
        Message savedMessage = messageService.addMessage(message);
        redirectAttributes.addFlashAttribute("savedMessage", savedMessage);
        redirectAttributes.addFlashAttribute("addMessageSuccess", true);
        return redirectView;
    }
    @GetMapping("/projects/topics/{topicId}/deleteMessage/{id}")
    public RedirectView deleteMessage(@PathVariable Integer id, @PathVariable Integer topicId) {
        messageService.deleteMessage(id);
        final RedirectView redirectDeleteView = new RedirectView("/projects/topics/" + topicId, true);
        return redirectDeleteView;
    }

}
