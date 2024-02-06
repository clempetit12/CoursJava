package entity.oneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departement")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
  private List<Employee>  employeelist;
    @Column(name = "departement_nom")
    private String depName;
    public Department() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Employee> getEmployeelist() {
        return employeelist;
    }

    public void setEmployeelist(List<Employee> employeelist) {
        this.employeelist = employeelist;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", employeelist=" + employeelist +
                ", depName='" + depName + '\'' +
                '}';
    }
}
