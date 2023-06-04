package org.musa.spring.mvc_hibernate_aop.controller;

import org.musa.spring.mvc_hibernate_aop.dao.EmploteeDAO;
import org.musa.spring.mvc_hibernate_aop.entity.Employee;
import org.musa.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller// компонент контролер
public class MyController {

    @Autowired//при создании этого бина, автоматически создастся бин EmployeeService
    private EmployeeService employeeService;

    @RequestMapping("/")//указываем url для вызова этого метода
    public String showAllEmployees(Model model){//создадим метод для получения всех работников, с моделью,
        // дабы view могла их всех вывести



        List<Employee> allEmployees = employeeService.getAllEmployees();//вызываем метод по отправку запроса через метод
        // Service класса, который вызовет метод нужного Dao класса на получение всех работнников

        model.addAttribute("allEmps", allEmployees);//кладем в модель, список всех наших пользователей
        return "all-employees";
    }
    @RequestMapping("/addEmployee")
    public String addEmployee(Model model){

        Employee employee = new Employee();//создаем пустого работника
        model.addAttribute("employee", employee);//добавляем его в нашу модель и передаем его нашей view
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){//получили из модели наш Employee что заполнили в форме
        System.out.println("--------------------");
        employeeService.saveEmployee(employee);

        return "redirect:/";//перенаправит, на главную страницу, где выводятся все работники
    }
    @RequestMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model){//указываем параметр из url, наш id работника чьи данные мы меняем
        Employee employee = employeeService.getEmployeeById(id);//взяли пользователя по id
        model.addAttribute("employee", employee);//добавляем в модель нашего пользователя которого мы собираемся менять
        return "employee-info";//вызываем ту же view как и при создании нового пользователя
    }

    @RequestMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id, Model model){
        employeeService.deleteEmployee(id);

        return "redirect:/";//перейдем на ту же страницу где и сейчас, а именно а главную страницу
    }

}
