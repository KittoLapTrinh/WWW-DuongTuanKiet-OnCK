package vn.edu.iuh.fit.wwwduongtuankietck.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "candidate")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id", nullable = false, length = 20)
    private long id;
    private String phone;
    @Column(length = 255)
    private String email;
    @Column(name = "full_name",length = 255)
    private String fullName;

    @OneToMany(mappedBy = "candidate",fetch = FetchType.LAZY)
    private List<Experience> experiences;

    public Candidate(String email, String fullName, String phone) {
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", experiences=" + experiences +
                '}';
    }
}


