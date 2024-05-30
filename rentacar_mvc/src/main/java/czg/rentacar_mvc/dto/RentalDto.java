package czg.rentacar_mvc.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RentalDto {
	
	private CarDto selectedCar;
	private LocalDate rentStart;
	private LocalDate rentFinish;
	
	
	public RentalDto(CarDto selectedCar, LocalDate rentStart, LocalDate rentFinish) {
		super();
		this.selectedCar = selectedCar;
		this.rentStart = rentStart;
		this.rentFinish = rentFinish;
	}


	public CarDto getSelectedCar() {
		return selectedCar;
	}


	public void setSelectedCar(CarDto selectedCar) {
		this.selectedCar = selectedCar;
	}


	public LocalDate getRentStart() {
		return rentStart;
	}


	public void setRentStart(LocalDate rentStart) {
		this.rentStart = rentStart;
	}


	public LocalDate getRentFinish() {
		return rentFinish;
	}


	public void setRentFinish(LocalDate rentFinish) {
		this.rentFinish = rentFinish;
	}


	@Override
	public String toString() {
		return "RentalDto [selectedCar=" + selectedCar + ", rentStart=" + rentStart + ", rentFinish=" + rentFinish
				+ "]";
	}
	
	public long getFullFee() {
		
		long fullFee = 0;

		long days = ChronoUnit.DAYS.between(rentStart, rentFinish);
		fullFee = days * selectedCar.getRentFee();
		
		return fullFee;
	}


 
 

}
