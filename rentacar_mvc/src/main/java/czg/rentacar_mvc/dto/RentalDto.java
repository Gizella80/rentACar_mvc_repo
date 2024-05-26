package czg.rentacar_mvc.dto;

import java.time.LocalDate;

public class RentalDto {
	
 private LocalDate rentStart;
 private LocalDate rentFinish;
 
 
public RentalDto(LocalDate rentStart, LocalDate rentFinish) {
	super();
	this.rentStart = rentStart;
	this.rentFinish = rentFinish;
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
	return "RentalDto [rentStart=" + rentStart + ", rentFinish=" + rentFinish + "]";
}
 
 
}
