/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrogg.employeeDAOImpl;

import com.leapfrog.employee.employee.Employee;
import com.leapfrog.employeeDAO.EmployeeDAO;

/**
 *
 * @author bekesh
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    private int counter = 0;
    private Employee[] employeeList = new Employee[10];

    @Override
    public boolean insert(Employee e) {
        if (counter == employeeList.length) {
            return false;
        }

        employeeList[counter] = e;
        counter++;

        return true;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < employeeList.length; i++) {
            Employee e = employeeList[i];
            {
                e = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Employee getById(int id) {
            for(int i =0;i<employeeList.length;i++)
{
        Employee e = employeeList[i];
            if(e !=null && e.getId()==id){
        return e;
        }
    }    
      return null;  
    }

    @Override
    public Employee[] getAll() {
      return employeeList;
    }
}

    
    

