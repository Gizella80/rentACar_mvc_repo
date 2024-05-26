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
	
	@Column(name="carid")
	private int carId;
	
	@Column(name="rentstart")
	private LocalDate rentStart;
	
	@Column(name="rentfinish")
	private LocalDate rentFinish;

	public Rental(int id, int carId, LocalDate rentStart, LocalDate rentFinish) {
		super();
		this.id = id;
		this.carId = carId;
		this.rentStart = rentStart;
		this.rentFinish = rentFinish;
	}
	
	public Rental() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
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
		return "Rental [id=" + id + ", carId=" + carId + ", rentStart=" + rentStart + ", rentFinish=" + rentFinish
				+ "]";
	}
	
	
	
}
