package czg.rentacar_mvc.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import czg.rentacar_mvc.dto.CarDto;
import czg.rentacar_mvc.dto.CarDtoList;
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
		
		return "rent.html";
	}
	
	
	@PostMapping("/rent")
	public String getDataForFreeCars(
			Model model,
			@RequestParam("start") LocalDate rentStart,
			@RequestParam("finish") LocalDate rentFinish) {
		
		String error = "There are no avaible Cars at this time";
		String targetPage = "";
		CarDtoList carDtoList = null;
		
		carDtoList = service.getAllAvaibleCar(rentStart,rentFinish);
		
		if(carDtoList != null) {
			
			RentalDto rentalDto = new RentalDto(rentStart,rentFinish);
			model.addAttribute("rentalDto",rentalDto);
			model.addAttribute("cardtolist",carDtoList);
			targetPage ="cars.html";
			
		}else {
			
			model.addAttribute("error", error);
			targetPage = "rent.html";
			
		}
		
		
		return targetPage;
	}
	
	@PostMapping("/cars")
	public String chooseAndReserveCar(
			Model model,
			@RequestParam("start") LocalDate startTime,
			@RequestParam("finish") LocalDate finishTime,
			@RequestParam("carType") String type,
			@RequestParam("name")String name,
			@RequestParam("address") String address,
			@RequestParam("email")String email,
			@RequestParam("phone") String phone
			) {
		
		String targetPage = "";
		CarDto carDto = service.persistAndMakeReservation(startTime,finishTime,type,name,email,phone);
		
		String reserved = "Your reservation was sccessfull!!";
		String error = "Something went wrong! Try again!";
		if(carDto != null) {
			
			targetPage = "exit.html";
			model.addAttribute("carDto",carDto);
			model.addAttribute("reserved", reserved);
			
		}else {
			model.addAttribute("error", error);
			targetPage = "rent.html";
		}
	
	
		return targetPage;	
	}
	
	

}
