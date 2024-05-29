package czg.rentacar_mvc.dto;

import java.time.LocalDate;
import java.util.List;

public class CarDtoList {

	private List<CarDto> avaibleCars;
	private LocalDate rentStart;
	private LocalDate rentFinish;
	
	
	public CarDtoList(List<CarDto> avaibleCars, LocalDate rentStart, LocalDate rentFinish) {
		super();
		this.avaibleCars = avaibleCars;
		this.rentStart = rentStart;
		this.rentFinish = rentFinish;
	}
	
	public List<CarDto> getAvaibleCars() {
		return avaibleCars;
	}
	
	public void setAvaibleCars(List<CarDto> avaibleCars) {
		this.avaibleCars = avaibleCars;
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
		return "CarDtoList [avaibleCars=" + avaibleCars + ", rentStart=" + rentStart + ", rentFinish=" + rentFinish
				+ "]";
	}

	
	
}
