package com.cloudwing.controller;

import com.cloudwing.dto.ApiResponse;
import com.cloudwing.dto.VasItemDto;
import com.cloudwing.service.VasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class VasController {

    private final VasService vasService;

    public VasController(VasService vasService) {
        this.vasService = vasService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VasItemDto>>> getAllServices() {
        List<VasItemDto> services = vasService.getAllServices();
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched value-added services", services));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VasItemDto>> getServiceById(@PathVariable Long id) {
        VasItemDto service = vasService.getServiceById(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched service details", service));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<ApiResponse<VasItemDto>> createService(@RequestBody VasItemDto dto) {
        VasItemDto created = vasService.createService(dto);
        return new ResponseEntity<>(new ApiResponse<>(true, "Service created successfully", created), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<ApiResponse<VasItemDto>> updateService(@PathVariable Long id, @RequestBody VasItemDto dto) {
        VasItemDto updated = vasService.updateService(id, dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Service updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    public ResponseEntity<ApiResponse<Void>> deleteService(@PathVariable Long id) {
        vasService.deleteService(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Service deleted successfully", null));
    }
}
