package com.hsenid.headerfooterjsp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee  implements Comparable<Employee>{
    @EmbeddedId
    private EmployeeId id;

    @ManyToOne
    @JoinColumn(name = "department_id",insertable = false, updatable = false)
    private Department department;

    private String firstName;

    private String lastName;

    private String nic;

    private String email;

    private String mobilePhone;

    @DateTimeFormat(pattern = "yyyy")
    private Date joinedYear;

    public Employee() {
    }

    public Employee(EmployeeId id, Department department, String firstName, String lastName, String nic, String email, String mobilePhone, Date joinedYear) {
        this.id = id;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.joinedYear = joinedYear;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Date getJoinedYear() {
        return joinedYear;
    }

    public void setJoinedYear(Date joinedYear) {
        this.joinedYear = joinedYear;
    }

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastNAme) {
        this.lastName = lastNAme;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department=" + department +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nic='" + nic + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", joinedYear=" + joinedYear +
                '}';
    }

    @Override
    public int compareTo(Employee  employee) {
        return Long.compare(this.id.getId(), employee.getId().getId());
    }
}
