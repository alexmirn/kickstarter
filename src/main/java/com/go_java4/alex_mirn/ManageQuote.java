package com.go_java4.alex_mirn;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import com.go_java4.alex_mirn.model.entity.Quote;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ManageQuote {
    private static SessionFactory factory;
    private static ServiceRegistry serviceRegistry;
    public static void main(String[] args) {
        System.out.println("JDBC template works");
        try{
//            Configuration configuration = new Configuration();
//            configuration.configure();
//            serviceRegistry = new ServiceRegistryBuilder().applySettings(
//                    configuration.getProperties()).buildServiceRegistry();
//            factory = configuration.buildSessionFactory(serviceRegistry);
            Configuration configuration=new Configuration()
                    .configure(); // configures settings from hibernate.cfg.xml

            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

            // If you miss the below line then it will complaing about a missing dialect setting
            serviceRegistryBuilder.applySettings(configuration.getProperties());

            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            factory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageQuote ME = new ManageQuote();

      /* Add few employee records in database */
        Integer empID1 = ME.addEmployee("I love hibernate");


      /* List down all the employees */
//        ME.listEmployees();

      /* Update employee's records */
//        ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
//        ME.deleteEmployee(empID2);

      /* List down new list of the employees */
//        ME.listEmployees();
    }
    /* Method to CREATE an employee in the database */
//    public Integer addEmployee(String fname, String lname, int salary){
    public Integer addEmployee(String name){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Quote quote = new Quote(name);
            employeeID = (Integer) session.save(quote);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }
    /* Method to  READ all the employees */
//    public void listEmployees( ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            List employees = session.createQuery("FROM Employee").list();
//            for (Iterator iterator =
//                 employees.iterator(); iterator.hasNext();){
//                Employee employee = (Employee) iterator.next();
//                System.out.print("First Name: " + employee.getFirstName());
//                System.out.print("  Last Name: " + employee.getLastName());
//                System.out.println("  Salary: " + employee.getSalary());
//            }
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    /* Method to UPDATE salary for an employee */
//    public void updateEmployee(Integer EmployeeID, int salary ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Employee employee =
//                    (Employee)session.get(Employee.class, EmployeeID);
//            employee.setSalary( salary );
//            session.update(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    /* Method to DELETE an employee from the records */
//    public void deleteEmployee(Integer EmployeeID){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Employee employee =
//                    (Employee)session.get(Employee.class, EmployeeID);
//            session.delete(employee);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
}
