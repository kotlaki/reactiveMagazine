package ru.kurganov.domain.dto;

import lombok.Builder;
import lombok.Data;
import ru.kurganov.domain.Category;
import ru.kurganov.domain.ProductImage;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductDto {
    private Long id;
    private Category category;
    private String vendorCode;
    private List<ProductImage> images;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private Double price;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
