package com.cloudwing.service;

import com.cloudwing.dto.VasItemDto;
import java.util.List;

public interface VasService {
    List<VasItemDto> getAllServices();
    VasItemDto getServiceById(Long id);
    VasItemDto createService(VasItemDto dto);
    VasItemDto updateService(Long id, VasItemDto dto);
    void deleteService(Long id);
}
