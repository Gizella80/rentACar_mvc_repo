package czg.rentacar_mvc.db;

import java.time.LocalDate;
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
	
	public List<Car> getAllCars(){
		
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
		
		SelectionQuery<Rental> query = session.createSelectionQuery("SELECT r FROM Rental r WHERE r.carId =? 1 ORDER By rentStart", Rental.class);
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

	public List<Rental> getReservationsBetweenDates(LocalDate startTime, LocalDate finishTime) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		
		SelectionQuery<Rental> selectionQuery = 
				session.createSelectionQuery(
							"SELECT r FROM Reservation r WHERE "
							+ "(r.rentStart <= ?1 AND r.rentFinish <= ?2 AND r.rentFinish >= ?1)		OR"
							+ "(r.rentStart <= ?2 AND r.rentStart >= ?1 AND r.rentFinish >= ?2) 	OR"
							+ "(r.rentStart >= ?1 AND r.rentFinish <= ?2) 							OR"
							+ "(r.rentStart <= ?1 AND r.rentFinish >= ?2)", 
						
							Rental.class);
		
		selectionQuery.setParameter(1, startTime);
		selectionQuery.setParameter(2, finishTime);
		List<Rental> reservations = selectionQuery.getResultList();
		for (int i =0 ;i<reservations.size();i++) {
			System.out.println(reservations.get(i));
		}
		
		tx.commit();
		session.close();
		
		return reservations;
		
	}

	public Car getCarById(int carId) {
		Car car = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		 car = session.get(Car.class,carId);
		 
		tx.commit();
		session.close();
				 
		return car;
	}

	public Rental getRentalByCarIdAndTime(int carId, LocalDate startTime, LocalDate finishTime) {
		Rental rental = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		
		SelectionQuery<Rental> selectionQuery = 
				session.createSelectionQuery(
							"SELECT r FROM Rental r WHERE r.rentStart=?1 AND r.rentFinish=?2 and r.carId=?3",
							
						
							Rental.class);
		
		selectionQuery.setParameter(1, startTime);
		selectionQuery.setParameter(2, finishTime);
		selectionQuery.setParameter(3, carId);
		
		List<Rental> rentals = selectionQuery.getResultList();
		
		if(rentals.size() > 0) {
			rental = rentals.get(0);
		}
		
		
		
		tx.commit();
		session.close();
		
		
		return rental;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
