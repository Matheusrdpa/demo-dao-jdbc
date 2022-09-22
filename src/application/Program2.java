package application;

import entities.Department;


import model.dao.DaoFactory;
import model.dao.DepartmentDao;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: Department FindById ===");
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: Department FindAll ===");
        List<Department> list = departmentDao.findAll();

        for (Department obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Department Update ===");
        dep = departmentDao.findById(6);
        dep.setName("Cellphones");
        departmentDao.update(dep);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 4: Department Insert ===");
        Department newDepartment = new Department(null, "Food");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! new id = " + newDepartment.getId());

        System.out.println("\n=== TEST 5: Department Delete ===");
        System.out.println("Enter id for Delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Completed");
        sc.close();

    }
}
