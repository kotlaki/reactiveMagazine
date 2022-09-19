package ru.kurganov.domain.dto;

import lombok.Builder;
import lombok.Data;
import ru.kurganov.domain.Category;
import ru.kurganov.domain.ProductImage;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductDto implements Serializable {
    private Long id;
    private Category category;
    private String vendorCode;
//    private List<ProductImage> images;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private Double price;
}
