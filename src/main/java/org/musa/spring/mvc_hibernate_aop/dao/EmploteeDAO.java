package org.musa.spring.mvc_hibernate_aop.dao;



import org.musa.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmploteeDAO {//интерфейс в котором мы пропишем возможные запросы к бд, таковы рекомендации

    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(Integer id);//метод который берет пользователя по id

    public void deleteEmployee(Integer id);//метод удаления пользователя по id

}
