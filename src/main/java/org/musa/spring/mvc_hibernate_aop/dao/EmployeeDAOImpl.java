package org.musa.spring.mvc_hibernate_aop.dao;

//DAO - это доп сервис, через который мы будем обращаться к бд, можно и на прямую через контроллер
//но это плохая практика
//Controller -> DAO -> DataBase

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.musa.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository//Это аннотация для того чтобы сканер нашел @Component, который отвечает за DAO
public class EmployeeDAOImpl implements EmploteeDAO{//наш класс Dao который имплеменнтирует интерфейс что мы создали

    @Autowired//МЫ СОЗДАЛИ В КОНФИГУРАЦИИ БИН, ПО СОЗДАНИЮ СЕССИИ ФАБРИКИ. И ТЕПЕРЬ, СОЗДАВ ОБЪЕКТ МЫ ПРОПИСЫВАЕМ
    // ЗАВИСИМОСТЬ, ЧТОБЫ ПРИ СОЗДАНИИ ОБЪЕКТА ЭТОМУ ОБЪЕКТУ БЫЛ АВТОМАТИЧЕСКИ СОЗДАНА ФАБРИКА СЕССИЙ ЧЕРЕЗ ПУЛ
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();//берем сессию из завода сессий что мы создали выше

        //один из способов создания запроса
        //List<Employee> allEmployee = session.createQuery("from Employee", Employee.class).getResultList();

        //второй способ

        Query<Employee> query = session.createQuery("from Employee", Employee.class);//создаем
        //запрос, где берем всех работников из таблицы employee но в запросе указываем имя класса а не таблицы.

        List<Employee> allEmployee = query.getResultList();//выполняем этот запрос а результат кладем в лист

        return allEmployee;
    }

    @Override
    public void saveEmployee(Employee employee) {//метод сохранения работника

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);//если id=0 то создаст нового, если не нулю, то изменит уже сущесвующего

    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);//берем пользователя по id
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:empId");//пишем :empId чтобы потом заполнить этот параметр
        query.setParameter("empId", id);//вставляем вместо empId наш id
        query.executeUpdate();//для delete Или update мы вызываем executeUpdate()
    }


}
