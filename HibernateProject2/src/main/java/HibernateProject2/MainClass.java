package HibernateProject2;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;



public class MainClass {

	public static void main(String[] args) {
		MyEntity me = new MyEntity(1, "Sajal Gupta", 98);
		MyEntity me2, me3;
		me2 = new MyEntity(2, "Shivank", 94);
		me3 = new MyEntity(3, "Pajjwal", 90);

		try {
			Session session = new Configuration().configure().buildSessionFactory().openSession();
			session.beginTransaction();
			Query l = session.createQuery("delete from MyEntity where name = :m");
			l.setParameter("m", "Pajjwal");
			System.out.println(l.executeUpdate());
			session.getTransaction().commit();
			}
			catch (Exception e) {
				System.out.println(e);
			}
	}

}
