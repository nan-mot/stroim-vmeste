package ru.ssau.stroimvmeste2.repository;

import org.springframework.stereotype.Controller;
import ru.ssau.stroimvmeste2.model.District;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DistrictRepository {

    private final Map<Integer, District> storage = new LinkedHashMap<>() {{
        put(1, new District(1, "District 1", "Diskription"));
        put(2, new District(2, "District 2", "Diskription"));
    }};


    public Collection<District> findAll() {
        return storage.values();
    }
}
