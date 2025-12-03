package test.demo.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "fullname", columnDefinition = "NVARCHAR(100)")
    private String fullname;

    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;

    // SỬA: Dùng Boolean (Lớp bao) để chấp nhận giá trị null từ DB
    @Column(name = "`admin`") 
    private Boolean admin = false;

    @Column(name = "active")
    private boolean active = true;

    // --- Constructor ---
    public User() { }

    // --- GETTERS & SETTERS ---

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    // --- SỬA QUAN TRỌNG TẠI ĐÂY ---
    // Đổi kiểu trả về thành Boolean (Object) để tránh lỗi NullPointerException
    public Boolean getAdmin() { 
        return admin; 
    }

    // Setter cũng nhận vào Boolean
    public void setAdmin(Boolean admin) { 
        this.admin = admin; 
    }

    // Hàm tiện ích: Nếu cần kiểm tra true/false an toàn (không bao giờ null)
    public boolean isAdminSafe() {
        return admin != null && admin;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}