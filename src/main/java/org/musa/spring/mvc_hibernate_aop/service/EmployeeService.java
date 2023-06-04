package org.musa.spring.mvc_hibernate_aop.service;

import org.musa.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {//создадим интерфейс для нашего Сервиса, в котором укажем методы обращения к разным DAO
    public List<Employee> getAllEmployees();//метод получения всех работников

    public void saveEmployee(Employee employee);//метод по сохранению работника

    public Employee getEmployeeById(Integer id);//метод который берет пользователя по id

    public void deleteEmployee(Integer id);
}
