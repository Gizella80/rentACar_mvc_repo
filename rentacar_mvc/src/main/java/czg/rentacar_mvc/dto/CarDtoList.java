package czg.rentacar_mvc.dto;

import java.util.List;

public class CarDtoList {

	private List<CarDto> carDtos;

	public CarDtoList(List<CarDto> carDtos) {
		super();
		this.carDtos = carDtos;
	}

	public List<CarDto> getCarDtos() {
		return carDtos;
	}

	public void setCarDtos(List<CarDto> carDtos) {
		this.carDtos = carDtos;
	}
	

	@Override
	public String toString() {
		return "CarDtoList [carDtos=" + carDtos + "]";
	}
	
	
}
