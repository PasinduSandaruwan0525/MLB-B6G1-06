package com.cloudwing.dto;

import java.math.BigDecimal;

public class VasItemDto {
    private Long id;
    private String code;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private boolean active;

    public VasItemDto() {}

    public VasItemDto(Long id, String code, String name, String description, String category, BigDecimal price, boolean active) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
