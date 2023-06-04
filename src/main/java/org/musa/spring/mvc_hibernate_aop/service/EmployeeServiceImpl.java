package org.musa.spring.mvc_hibernate_aop.service;
import org.musa.spring.mvc_hibernate_aop.dao.EmploteeDAO;
import org.musa.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//Нам известно, что контроллер обращается к DAO а Dao уже обращается к бд. но у нас есть разные Dao для разных запросов
//на разные таблицы. и если классов DAO будет слишком много. то это будет не удобно, искать нужный. чтобы объеденить
//все эти Dao классы, существует Service к которому контроллер обращается перед тем как обратиться к DAO

//Controller -> Service -> DAO1 -> DB
//                         DAO2

@Service//Аннотация указывающая на то что это сервис. это @Component соединяющий контроллер и DAO
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmploteeDAO emploteeDAO;//создаем наш дао через который мы будем обращатсья к бд

    @Override
    @Transactional//мы в конфиге создали бин, который будет автоматически открывать и закрывать транзакции
    //теперь через эту аннотацию мы можем не париться за транзакции
    public List<Employee> getAllEmployees() {//метод получения всех работников
        return emploteeDAO.getAllEmployees();//вызываем метод в DAO для получения всех польщователей
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {//метод сохранения работника
        emploteeDAO.saveEmployee(employee);//вызываем из Dao класса метод сохранения работника
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Integer id) {

        return emploteeDAO.getEmployeeById(id);//возвращаем пользователя по id
    }

    @Override
    @Transactional
    public void deleteEmployee(Integer id) {
        emploteeDAO.deleteEmployee(id);
    }
}
