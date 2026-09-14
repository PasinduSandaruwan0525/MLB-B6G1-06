package com.cloudwing.service.impl;

import com.cloudwing.dto.VasItemDto;
import com.cloudwing.entity.VasItem;
import com.cloudwing.exception.ResourceNotFoundException;
import com.cloudwing.repository.VasItemRepository;
import com.cloudwing.service.VasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VasServiceImpl implements VasService {

    private final VasItemRepository vasRepository;

    public VasServiceImpl(VasItemRepository vasRepository) {
        this.vasRepository = vasRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VasItemDto> getAllServices() {
        return vasRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public VasItemDto getServiceById(Long id) {
        VasItem item = vasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VAS item not found with id " + id));
        return mapToDto(item);
    }

    @Override
    @Transactional
    public VasItemDto createService(VasItemDto dto) {
        VasItem item = new VasItem(
                dto.getCode(),
                dto.getName(),
                dto.getDescription(),
                dto.getCategory(),
                dto.getPrice(),
                dto.isActive()
        );
        return mapToDto(vasRepository.save(item));
    }

    @Override
    @Transactional
    public VasItemDto updateService(Long id, VasItemDto dto) {
        VasItem item = vasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VAS item not found with id " + id));
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setCategory(dto.getCategory());
        item.setPrice(dto.getPrice());
        item.setActive(dto.isActive());
        return mapToDto(vasRepository.save(item));
    }

    @Override
    @Transactional
    public void deleteService(Long id) {
        VasItem item = vasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VAS item not found with id " + id));
        vasRepository.delete(item);
    }

    private VasItemDto mapToDto(VasItem item) {
        return new VasItemDto(
                item.getId(),
                item.getCode(),
                item.getName(),
                item.getDescription(),
                item.getCategory(),
                item.getPrice(),
                item.isActive()
        );
    }
}
