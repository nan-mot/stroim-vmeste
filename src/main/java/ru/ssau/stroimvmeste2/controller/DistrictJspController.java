package ru.ssau.stroimvmeste2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.ssau.stroimvmeste2.model.District;
import ru.ssau.stroimvmeste2.service.DistrictService;

@Controller
@RequestMapping("/districts")
@RequiredArgsConstructor
public class DistrictJspController {

    private final DistrictService districtService;

    @GetMapping("/all")
    public String viewDistricts(Model model) {
        model.addAttribute("districts", districtService.getAllDistricts());
        return "districts";
    }

    @GetMapping("/addDistrict")
    public String addDistrictView(Model model) {
        model.addAttribute("district", new District());
        return "add-district";
    }

    @PostMapping("/addDistrict")
    public RedirectView addDistrict(@ModelAttribute("district") District district, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("all", true);
        District savedDistrict = districtService.addDistrict(district);
        redirectAttributes.addFlashAttribute("savedDistrict", savedDistrict);
        redirectAttributes.addFlashAttribute("addDistrictSuccess", true);
        return redirectView;
    }

    @GetMapping("/updateDistrict/{id}")
    public String updateDistrictView(Model model, @PathVariable Integer id) {
        model.addAttribute("district", districtService.getDistrict(id));
        return "update-district";
    }

    @PostMapping("/updateDistrict")
    public RedirectView updateDistrict(@ModelAttribute("district") District district, RedirectAttributes redirectAttributes) {
        final RedirectView redirectView = new RedirectView("all", true);
        District updatedDistrict = districtService.updateDistrict(district);
        redirectAttributes.addFlashAttribute("updatedDistrict", updatedDistrict);
        redirectAttributes.addFlashAttribute("updateDistrictSuccess", true);
        return redirectView;
    }

    @GetMapping("/deleteDistrict/{id}")
    public RedirectView deleteDistrict(Model model, @PathVariable Integer id) {
        districtService.deleteDistrict(id);
        final RedirectView redirectView = new RedirectView("/districts/all", true);
        return redirectView;
    }
}
