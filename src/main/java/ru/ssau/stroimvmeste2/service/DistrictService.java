package ru.ssau.stroimvmeste2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ssau.stroimvmeste2.model.District;
import ru.ssau.stroimvmeste2.model.Project;
import ru.ssau.stroimvmeste2.repository.DistrictRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DistrictService {

    public final DistrictRepository districtRepository;

    public List<District> getAllDistricts() {
        List<District> districts = new ArrayList<>();
        districtRepository.findAll().forEach(districts::add);
        return districts;
    }

    public Optional<District> getDistrict(Integer id) {
        return districtRepository.findById(id);
    }

    public District addDistrict(District district) {
        return districtRepository.save(district);
    }

    public District updateDistrict(District district) {
        Optional<District> districtOptional = districtRepository.findById(district.getId());
        if (districtOptional.isPresent()) {
            districtOptional.get().setDistrictName(district.getDistrictName());
            districtOptional.get().setDistrictDescription(district.getDistrictDescription());
            return districtRepository.save(districtOptional.get());
        } else {
            return null;
        }
    }


    public void deleteDistrict(Integer id) {
        districtRepository.deleteById(id);
    }
}
