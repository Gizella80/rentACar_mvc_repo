package czg.rentacar_mvc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import czg.rentacar_mvc.dto.CarDtoList;
import czg.rentacar_mvc.dto.MessageDto;
import czg.rentacar_mvc.dto.RentalDto;
import czg.rentacar_mvc.service.AppService;

@Controller
public class AppController {
	
	
	private AppService service;
	
	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
		
	}
	
	@GetMapping("/")
	public String loadRentPage() {
		
		return "index.html";
	}
	
	
	@GetMapping("/cars")
	public String getDataForFreeCars(
			Model model,
			@RequestParam("start") LocalDate rentStart,
			@RequestParam("finish") LocalDate rentFinish) {
		
		
		CarDtoList avaiableCars = service.getAllAvaibleCar(rentStart, rentFinish);
		
		model.addAttribute("avaiablecars", avaiableCars);
		
		
		return "index.html";
	}
	@GetMapping("/cars/startreserve")
	public String chooseACar(
			Model model,
			@RequestParam("start") LocalDate rentStart,
			@RequestParam("finish") LocalDate rentFinish,
			@RequestParam("carid") int carId) {
		
		RentalDto reservationDto = service.getSelectedCarDto(rentStart,rentFinish,carId);
		
		
		 model.addAttribute("reservationdto", reservationDto);	
				
		return "reserve.html";
	}
	
	
	
	
	@PostMapping("/cars/endreserve")
	public String chooseAndReserveCar(
			Model model,
			@RequestParam("start") LocalDate startTime,
			@RequestParam("finish") LocalDate finishTime,
			@RequestParam("carid") int carId,
			@RequestParam("name")String name,
			@RequestParam("address") String address,
			@RequestParam("email")String email,
			@RequestParam("phone") String phone
			) {
		
		MessageDto messageDto = service.persistReservation(startTime,finishTime,carId,name,address,phone,email);

		model.addAttribute("messagedto", messageDto);
	
		return "reserve.html";	
	}
	
	

}
