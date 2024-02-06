package demo;

import entity.oneToMany.Department;
import entity.oneToMany.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Demo5 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo_jpa");

    public static void main() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Department department = new Department();
        department.setDepName("Nord");
        Department department2 = new Department();
        department.setDepName("Paca");
        Department department3 = new Department();
        department.setDepName("Ile de France");

        Employee employee = new Employee();
        employee.setName("Olivia");
        employee.setDepartment(department);

        Employee employee3 = new Employee();
        employee3.setName("Clea");
        employee3.setDepartment(department);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add((employee));
        employeeList.add(employee3);

        department.setEmployeelist(employeeList);


        em.persist(department);

        em.getTransaction().commit();

        Department department1 = em.find(Department.class, 1L);

        for (Employee e : department1.getEmployeelist()) {
            System.out.println(e);
        }
        em.close();
        emf.close();


    }


}
