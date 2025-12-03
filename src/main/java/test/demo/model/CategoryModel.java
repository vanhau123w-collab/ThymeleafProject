package test.demo.model;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CategoryModel {

    private int id; 

    @NotEmpty(message = "Không được bỏ trống")
    @Length(min = 5, message = "Tên danh mục phải từ 5 ký tự trở lên")
    private String categoryName; 
    
    private String images;

    private Boolean isEdit = false;

    // --- Constructor mặc định ---
    public CategoryModel() {
    }

    // --- CÁC HÀM GETTER / SETTER THỦ CÔNG ---
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Boolean getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(Boolean isEdit) {
        this.isEdit = isEdit;
    }
}