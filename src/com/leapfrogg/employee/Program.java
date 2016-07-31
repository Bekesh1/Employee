/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leapfrogg.employee;

import com.leapfrog.employee.employee.Employee;
import com.leapfrog.employeeDAO.EmployeeDAO;
import com.leapfrogg.employeeDAOImpl.EmployeeDAOImpl;
import java.util.Scanner;

/**
 *
 * @author bekesh
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        while(true){
        
        System.out.println("1. add employee");
        System.out.println("2. update employee");
        System.out.println("3. delete employee");
        System.out.println("4. see all employees");
        System.out.println("5. search employees by Id");
        System.out.println("6. exit");
        System.out.println(" enter your choice[1-5]");
        
        switch (sc.nextInt()) {
                       case 1:
                           System.out.println("Add Employee");
                           Employee e = new Employee();
                           System.out.println("Enter Employee Id");
                           e.setId(sc.nextInt());
                           System.out.println("Enter Employee's name");
                           e.setName(sc.next());
                           System.out.println("Enter employee's address");
                           e.setAddress(sc.next());
                           System.out.println("Enter employee's contact no.");
                           e.setContactno(sc.next());
                           System.out.println("Enter employee's Position");
                           e.setPosition(sc.next());
                           System.out.println("Enter employee's Salary");
                           e.setSalary(sc.nextDouble());

                           if (employeeDAO.insert(e)) {
                               System.out.println("Value Inserted!");
                           } else {
                               System.out.println("Cannot Insert the value.");
                           }
//                           sc.nextLine();
                           break;

                       case 2:
                           
                           break;

                       case 3:
                           System.out.print("Enter Employee id to be deleted: ");
                           if(employeeDAO.delete(sc.nextInt()))
                           {
                               System.out.println("Employee deleted.");   
                           }else
                               System.out.println("Null Employee id. Cannot be deleted. ");
                           break;

                           case 4:
                               System.out.println("Display all Employees");
                           Employee[] employeeList= employeeDAO.getAll();
                           for(int i=0;i<employeeList.length;i++)
                           {
                               if(employeeList[i]!=null)
                           {
                               System.out.println("Employee's id: "+employeeList[i].getId());
                               System.out.println("Employee's name: "+employeeList[i].getName());
                               System.out.println("Employee's Position: "+employeeList[i].getAddress());
                               System.out.println("Employee's Position.: "+employeeList[i].getPosition());
                               System.out.println("Employee's Salary: "+employeeList[i].getSalary());

//                               sc.next();
                           }
                           }
                           break;

                           case 5:
                               System.out.print("Enter Employee's ID to be searched: ");
                               System.out.println();

                           Employee employee= employeeDAO.getById(sc.nextInt());
                           if(employee != null){
                               System.out.println("Employee's id: "+employee.getId());
                               System.out.println("Employee's name: "+employee.getName());
                               System.out.println("Employee's Position: "+employee.getAddress());
                               System.out.println("Employee's Position.: "+employee.getPosition());
                               System.out.println("Employee's Salary: "+employee.getSalary());
                           }else
                               System.out.println("Employee could not be found.");
                           break;
                    
         }
        }
    }

}