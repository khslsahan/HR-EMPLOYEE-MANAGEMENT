package com.hsenid.headerfooterjsp.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department implements Comparable<Department> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private  long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    @NonNull
    private DepartmentName name;

//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;
//
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public DepartmentName getName() {
        return name;
    }

    public void setName(DepartmentName name) {
        this.name = name;
    }

    public Department() {
    }

    public Department(long id, DepartmentName name) {
        this.id = id;
        this.name = name;
    }

//    public Department(long id, DepartmentName name, List<Employee> employees) {
//        this.id = id;
//        this.name = name;
//        this.employees = employees;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Department department) {
        return Long.compare(this.id, department.getId());
    }
}
