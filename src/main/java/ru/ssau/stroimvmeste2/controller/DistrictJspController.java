package ru.ssau.stroimvmeste2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ssau.stroimvmeste2.repository.DistrictRepository;

@Controller
@RequestMapping("/district")
@RequiredArgsConstructor
public class DistrictJspController {

    private final DistrictRepository districtRepository;

    @GetMapping("/all")
    public String viewDistricts(Model model) {
        model.addAttribute("districts", districtRepository.findAll());
        return "districts";
    }


}
