package ru.ssau.stroimvmeste2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.ssau.stroimvmeste2.dto.ProjectFullDto;
import ru.ssau.stroimvmeste2.model.District;
import ru.ssau.stroimvmeste2.model.Project;
import ru.ssau.stroimvmeste2.service.DistrictService;
import ru.ssau.stroimvmeste2.service.ProjectService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projects")
@RequiredArgsConstructor
public class TopicJspController {
//    private final ProjectService projectService;
//    private final DistrictService districtService;
//
//    @GetMapping("/all")
//    public String viewProjects(Model model) {
//        model.addAttribute("projects", projectService.getAllProjects());
//        return "projects";
//    }
//
//    @GetMapping("/{id}")
//    public String viewProjectFullDto(Model model, @PathVariable Integer id) {
//        model.addAttribute("project", projectService.getProject(id));
//        return "project";
//    }
//
//    @GetMapping("/addProject")
//    public String addUserView(Model model) {
//        model.addAttribute("project", new Project());
//        List<District> districts = districtService.getAllDistricts();
//        model.addAttribute("districts", districts);
//        return "add-project";
//    }
//
//    @PostMapping("/addProject")
//    public RedirectView addProject(@ModelAttribute("user") Project project, RedirectAttributes redirectAttributes) {
//        final RedirectView redirectView = new RedirectView("all", true);
//        Project savedProject = projectService.addProject(project);
//        redirectAttributes.addFlashAttribute("savedProject", savedProject);
//        redirectAttributes.addFlashAttribute("addProjectSuccess", true);
//        return redirectView;
//    }
//
//    @GetMapping("/updateProject/{id}")
//    public String updateProjectView(Model model, @PathVariable Integer id) {
//        Optional<ProjectFullDto> optional = projectService.getProject(id);
//        if (optional.isEmpty()) {
//            model.addAttribute("entity", "Project");
//            return "not-found";
//        }
//        model.addAttribute("project", projectService.getProject(id));
//        List<District> districts = districtService.getAllDistricts();
//        model.addAttribute("districts", districts);
//        return "update-project";
//    }
//
//    @PostMapping("/updateProject")
//    public RedirectView updateProject(@ModelAttribute("project") Project project, RedirectAttributes redirectAttributes) {
//        final RedirectView redirectView = new RedirectView("all", true);
//        Project updatedProject = projectService.updateProject(project);
//        redirectAttributes.addFlashAttribute("updatedProject", updatedProject);
//        redirectAttributes.addFlashAttribute("updateProjectSuccess", true);
//        return redirectView;
//    }
//    @GetMapping("/deleteProject/{id}")
//    public RedirectView deleteProject(@PathVariable Integer id) {
//        projectService.deleteProject(id);
//        final RedirectView redirectDeleteView = new RedirectView("/projects/all", true);
//        return redirectDeleteView;
//    }
}
