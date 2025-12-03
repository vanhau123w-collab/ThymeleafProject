package test.demo.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "videoId") // <-- SỬA: Đổi "VideoId" thành "videoId" (khớp cột có dữ liệu)
    private String videoId;

    @Column(name = "title", columnDefinition = "VARCHAR(255)") // MySQL dùng VARCHAR, SQL Server mới dùng NVARCHAR
    private String title;

    @Column(name = "poster")
    private String poster;

    @Column(name = "description", columnDefinition = "TEXT") // MySQL dùng TEXT thay cho NVARCHAR(MAX)
    private String description;

    @Column(name = "views")
    private Integer views = 0;

    @Column(name = "active")
    private Boolean active = true;

    // Quan hệ với Category
    @ManyToOne
    @JoinColumn(name = "categoryId") // <-- SỬA: Đổi "CategoryId" thành "categoryId" (khớp cột có dữ liệu)
    private Category category;

    // --- Constructor ---
    public Video() { }

    // --- Getters & Setters ---
    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getViews() { return views; }
    public void setViews(Integer views) { this.views = views; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}