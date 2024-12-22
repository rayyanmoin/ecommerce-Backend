package com.rayyan.ecommerce.ecommerceObjects;



import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
public class ProductCategoryId implements Serializable {

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "category_id")
    private Long categoryId;

    // Default constructor
    public ProductCategoryId() {}

    public ProductCategoryId(Long productId, Long categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    // Getters and Setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    // hashCode and equals based on productId and categoryId
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryId that = (ProductCategoryId) o;
        return productId.equals(that.productId) && categoryId.equals(that.categoryId);
    }

    @Override
    public int hashCode() {
        return productId.hashCode() + categoryId.hashCode();
    }
}
