package vn.edu.iuh.fit.wwwduongtuankietck.backend.models;

import vn.edu.iuh.fit.wwwduongtuankietck.backend.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", nullable = false, length = 20)
    private long id;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "work_desc", length = 400)
    private String workDescription;
    @Enumerated(EnumType.STRING)
    private Roles role;
    @Column(name = "company", length = 120)
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Override
    public String toString() {
        return "Experience{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", workDescription='" + workDescription + '\'' +
                ", role=" + role +
                ", company='" + company + '\'' +
                ", candidate=" + candidate +
                '}';
    }



    public Experience(String workDescription, Roles role, LocalDate fromDate, LocalDate toDate, Candidate candidate, String company) {
        this.workDescription = workDescription;
        this.role = role;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.candidate = candidate;
        this.company = company;
    }

    public Experience(String workDescription, Roles role, LocalDate fromDate, LocalDate toDate, Candidate candidate) {
        this.workDescription = workDescription;
        this.role = role;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.candidate = candidate;
    }

}
