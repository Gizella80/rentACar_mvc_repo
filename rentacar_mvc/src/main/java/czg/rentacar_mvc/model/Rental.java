package czg.rentacar_mvc.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rentals")
public class Rental {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="user_emal")
	private String user_email;
	
	@Column(name="user_phone")
	private String user_phone;
	
	@Column(name="user_address")
	private String user_address;
	
	@Column(name="rentstart")
	private LocalDate rentStart;
	
	@Column(name="rentfinish")
	private LocalDate rentFinish;
	
	@Column(name="carid")
	private int carId;
	
	public Rental() {}
	

	public Rental(int id, String user_name, String user_email, String user_phone, String user_address,
			LocalDate rentStart, LocalDate rentFinish, int carId) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.rentStart = rentStart;
		this.rentFinish = rentFinish;
		this.carId = carId;
	}


	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
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

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	
	
	
}
