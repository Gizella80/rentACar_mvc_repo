package czg.rentacar_mvc.dto;

import java.time.LocalDate;
import java.util.List;

public class CarDto {
	
	private String type;
	
	private String color;
	
	private int rentFee;
	
	private List<RentalDto> rentalsDtos;

	public CarDto(String type, String color, int rentFee, List<RentalDto> rentalsDtos) {
		super();
		this.type = type;
		this.color = color;
		this.rentFee = rentFee;
		this.rentalsDtos = rentalsDtos;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRentFee() {
		return rentFee;
	}

	public void setRentFee(int rentFee) {
		this.rentFee = rentFee;
	}

	public List<RentalDto> getRentalsDtos() {
		return rentalsDtos;
	}

	public void setRentalsDtos(List<RentalDto> rentalsDtos) {
		this.rentalsDtos = rentalsDtos;
	}

	@Override
	public String toString() {
		return "CarDto [type=" + type + ", color=" + color + ", rentFee=" + rentFee + ", rentalsDtos=" + rentalsDtos
				+ "]";
	}
	
	public boolean isAvailable(LocalDate start,LocalDate finish) {
		boolean isFree = false;
		if(rentalsDtos.size() < 1) {
			isFree = true;
		}else if(rentalsDtos.size() == 1) {
			RentalDto rentalDto = rentalsDtos.get(0);
			if(rentalDto.getRentStart().isAfter(finish) || rentalDto.getRentFinish().isBefore(start)) {
				isFree = true;
			}
		}else if(rentalsDtos.size() > 1) {
			for(int index = 0; index < this.rentalsDtos.size()-1; index++) {
				RentalDto currentRentalDto = rentalsDtos.get(index);
				RentalDto nextRentalDto = rentalsDtos.get(index+1);
				if(currentRentalDto.getRentFinish().isBefore(start) && nextRentalDto.getRentStart().isAfter(finish)) {
					isFree = true;
					break;
				}
			}
		}
		
		
		
		return isFree;
	}
	

}
