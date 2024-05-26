package czg.rentacar_mvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import czg.rentacar_mvc.db.Database;
import czg.rentacar_mvc.dto.CarDto;
import czg.rentacar_mvc.dto.CarDtoList;
import czg.rentacar_mvc.dto.RentalDto;
import czg.rentacar_mvc.model.Car;
import czg.rentacar_mvc.model.Rental;

@Service
public class AppService {
	
	private Database db;
	
	@Autowired
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public CarDtoList getAllAvaibleCar(LocalDate rentStart, LocalDate rentFinish) {
		
		CarDtoList carDtoList = null;
		List<Car> cars = new ArrayList<>();
		List<CarDto> allCarDtos = new ArrayList<>();
		List<CarDto> freeCarDtos = new ArrayList<>();
		
		// lekérem és összehozom az összes CarDto-t
		cars = db.getAllCar();
		for(int index = 0; index < cars.size();index++) {
			
			Car currentCar = cars.get(index);
			List<Rental> rentals = db.getAllRentalsByCarId(currentCar.getId());
			List<RentalDto> rentalDtos = new ArrayList<>();
			for (int index_rentals = 0 ;index_rentals < rentals.size();index_rentals++) {
				Rental currentRental = rentals.get(index_rentals);
				RentalDto rentalDto = new RentalDto(currentRental.getRentStart(),currentRental.getRentFinish());
				rentalDtos.add(rentalDto);
				
			}
			CarDto currCarDto = new CarDto(currentCar.getType(),currentCar.getColor(),currentCar.getRentFee(),rentalDtos);
			allCarDtos.add(currCarDto);
		}
		// ki választom azokat a CarDto-kat amik szabadok abban az időben
		for(int index_allCarDto = 0; index_allCarDto  < allCarDtos.size(); index_allCarDto++) {
			
			CarDto currentCarDto = allCarDtos.get(index_allCarDto);
			if(currentCarDto.isAvailable(rentStart, rentFinish) == true) {
				freeCarDtos.add(currentCarDto);
			}
		}
		//
		if(freeCarDtos!=null) {
			carDtoList = new CarDtoList(freeCarDtos);
		}
			
		
		
		return carDtoList;
	}

	public CarDto persistAndMakeReservation(LocalDate startTime, LocalDate finishTime, String type, String name,
			String email, String phone) {
		CarDto carDto = null;
	
		if(type!= null && name != null && email != null && phone != null) {
			Car car = db.getCarByType(type);
			
			Rental rental = new Rental(0,car.getId(),startTime,finishTime);
			db.persistRentalObject(rental);
			List<Rental> rentals = db.getAllRentalsByCarId(car.getId());
			List<RentalDto> rentalDtos = new ArrayList<>();
			for (int index_rentals = 0 ;index_rentals < rentals.size();index_rentals++) {
				Rental currentRental = rentals.get(index_rentals);
				RentalDto rentalDto = new RentalDto(currentRental.getRentStart(),currentRental.getRentFinish());
				rentalDtos.add(rentalDto);
				
			}
			
			 carDto= new CarDto(car.getType(),car.getColor(),car.getRentFee(),rentalDtos);
			
		}
		return carDto;
	}
	
	
}
