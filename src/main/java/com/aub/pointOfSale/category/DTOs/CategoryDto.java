package com.aub.pointOfSale.category.DTOs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto
{
    private String name;
    private Long categoryId;
    private String description;
    private Integer quantity;
}
