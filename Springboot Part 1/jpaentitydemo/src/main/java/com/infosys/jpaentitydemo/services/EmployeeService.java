package com.infosys.jpaentitydemo.services;

import com.infosys.jpaentitydemo.beans.Employees;
import com.infosys.jpaentitydemo.dao.EmployeeDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeService implements EmployeeDao {

    @PersistenceUnit
    EntityManagerFactory emf;

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Employees addEmployee(Employees emp) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(emp);
        entityManager.getTransaction().commit();
        entityManager.close();
        return emp;
    }

    @Override
    public void findEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter emp id to search:");
        int empid = scanner.nextInt();

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Employees e = entityManager.find(Employees.class, empid);

        if (e != null) {
            System.out.println("Employee name: " + e.getEmployeeName());
            System.out.println("Employee email: " + e.getEmployeeEmail());
        } else {
            System.out.println("Employee not found. Please check the id.");
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Employees updateEmployee(int id, String name, String email) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        Employees existingEmp = entityManager.find(Employees.class, id);

        if (existingEmp != null) {
            existingEmp.setEmployeeName(name);
            existingEmp.setEmployeeEmail(email);
            entityManager.getTransaction().commit();
            entityManager.close();
            return existingEmp;
        } else {
            entityManager.getTransaction().commit();
            entityManager.close();
            return null;
        }
    }

    @Override
    public void removeEmployee(int empId) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Employees e = entityManager.find(Employees.class, empId);
        if (e != null) {
            entityManager.remove(e);
            System.out.println("Employee is removed");
        } else {
            System.out.println("Employee not found. Please check id");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Employees> findAllEmployees() {
        String query = "Select e from Employees e";
        EntityManager entityManager = emf.createEntityManager();
        TypedQuery<Employees> empList = entityManager.createQuery(query, Employees.class);
        List<Employees> empResultList = empList.getResultList();
        entityManager.close();
        return empResultList;
    }

    @Override
    public void findByEmail(String mailId) {
        EntityManager entityManager = emf.createEntityManager();

        List<Employees> employeeList = entityManager
                .createNamedQuery("Employees.findByEmail", Employees.class)
                .setParameter("mail", mailId)
                .getResultList();

        if (!employeeList.isEmpty()) {
            employeeList.forEach(System.out::println);
        } else {
            System.out.println("No data found");
        }

        entityManager.close();
    }

    @Override
    public void validateEmployee(int empId, String empmail) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Employees emp = entityManager.find(Employees.class, empId);
        if (emp != null && emp.getEmployeeEmail().equals(empmail)) {
            System.out.println("Employee is valid");
        } else {
            System.out.println("Employee ID is not valid");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}


