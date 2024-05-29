package czg.rentacar_mvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import czg.rentacar_mvc.db.Database;
import czg.rentacar_mvc.dto.CarDto;
import czg.rentacar_mvc.dto.CarDtoList;
import czg.rentacar_mvc.dto.MessageDto;
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
		List<CarDto> availableCarDtos = new ArrayList<>();
		
		List<Rental> reservationList = db.getReservationsBetweenDates(rentStart, rentFinish);
		List<Car> allCars = db.getAllCars();
		
		
		for(int index = 0; index < reservationList.size(); index++) {
			
			Rental currentReservation = reservationList.get(index);
			int reservedCarId = currentReservation.getCarId();
			
			
			for(int carIndex = 0; carIndex < allCars.size(); carIndex++) {
				
				Car currentCar = allCars.get(carIndex);
				if(currentCar.getId() == reservedCarId) {
					
					allCars.remove(carIndex);
					break;
				}
			}
		}
		if(allCars.size()> 0) {
			for(int index_allCar = 0; index_allCar < allCars.size(); index_allCar++) {
				
				Car currentCar = allCars.get(index_allCar);
				CarDto currentCarDto = new CarDto(
						currentCar.getId(),
						currentCar.getType(),
						currentCar.getColor(),
						currentCar.getRentFee());
				
				
				availableCarDtos.add(currentCarDto);
			}
			carDtoList = new CarDtoList(availableCarDtos,rentStart,rentFinish);
		
			
		}else {
			
			 carDtoList = null;
		} 
		
		
		return carDtoList;
	}

	

	public RentalDto getSelectedCarDto(LocalDate rentStart, LocalDate rentFinish, int carId) {
		
		RentalDto rentalDto = null;
		
		Car car = db.getCarById(carId);
		
		CarDto carDto = new CarDto( car.getId(),car.getType(),car.getColor(),car.getRentFee());
		
		rentalDto = new RentalDto(carDto,rentStart,rentFinish);
		
		
		return rentalDto;
	}

	public MessageDto persistReservation(LocalDate startTime, LocalDate finishTime, int carId, String name, String address,
			String phone, String email) {
		MessageDto messageDto = null;
		
		Rental rental = new Rental (0,name,email,phone,address,startTime,finishTime,carId);
		db.persistRentalObject(rental);
		
		Rental savedRental = db.getRentalByCarIdAndTime(carId,startTime,finishTime);
		
		Car car = db.getCarById(carId);
		
		CarDto carDto = new CarDto( car.getId(),car.getType(),car.getColor(),car.getRentFee());
		RentalDto rentalDto = new RentalDto(carDto,savedRental.getRentStart(),savedRental.getRentFinish());
		
		messageDto = new MessageDto(
				savedRental.getId(),
				rentalDto,savedRental.getUser_name(),
				savedRental.getUser_address(),
				savedRental.getUser_email(),
				savedRental.getUser_phone());
		
		
		return messageDto;
	}
	
	
}
