package demo.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {


        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).configure().addAnnotatedClass(Laptop.class);
        SessionFactory fac = cfg.buildSessionFactory();
        Session session = fac.openSession();
        Transaction transaction = session.beginTransaction();
        Laptop laptop=new Laptop(22,"Hp");
        Laptop laptop1=new Laptop(21,"Dell");
        session.save(laptop1);
        session.save(laptop);



        List<Laptop> laptopList=new ArrayList<>();
        laptopList.add(laptop);
        laptopList.add(laptop1);

        Student student = new Student(12, "Dhinesh", 90,laptopList);

        session.save(student);
        transaction.commit();
        fac.close();
        session.close();
    }
}
