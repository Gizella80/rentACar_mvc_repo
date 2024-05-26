package czg.rentacar_mvc.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import czg.rentacar_mvc.model.Car;
import czg.rentacar_mvc.model.Rental;

@Repository
public class Database {
	

	private SessionFactory sessionFactory;
	
	public Database() {
		
		Configuration config = new Configuration();
		config.configure();
		
		sessionFactory = config.buildSessionFactory();
		
	}
	
	public List<Car> getAllCar(){
		
		List<Car> cars = null;
		 
		 
	 	Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		SelectionQuery<Car> query = session.createSelectionQuery("SELECT c FROM Car c", Car.class);
		cars = query.getResultList();
		
		
		tx.commit();
		session.close();
		 
		 
		return cars;
		
	}
	
	public List<Rental> getAllRentalsByCarId(int carId){
		
		List<Rental> rentals = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		SelectionQuery<Rental> query = session.createSelectionQuery("SELECT r FROM Rental WHERE r.CarId =? 1 ORDER By r.rentStart", Rental.class);
		query.setParameter(1, carId);
		
		rentals = query.getResultList();
		
		tx.commit();
		session.close();
		
		
		
		return rentals;
		
	}
	
	 public Car getCarByType(String type) {
		 Car car = null;
		 

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		SelectionQuery<Car> query = session.createSelectionQuery("SELECT c FROM Car WHERE c.type =?1", Car.class);
		query.setParameter(1, type) ;
		
		List<Car> cars = query.getResultList();
		
		if(cars.size()> 0) {
			car = cars.get(0);
		}
		 
		tx.commit();
		session.close();
				 
		return car;		 
	 }
	 
	 public void persistRentalObject(Rental rental) {
		 
		 
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		session.persist(rental);
		
		tx.commit();
		session.close();
	
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
