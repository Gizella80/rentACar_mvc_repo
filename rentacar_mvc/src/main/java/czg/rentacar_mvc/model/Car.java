package czg.rentacar_mvc.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
	
	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "rentfee") 
	private int rentFee;
	
	
	private List<Rental> rentals;
	
	public Car() {}


	public Car(int id, String type, String color, int rentFee, List<Rental> rentals) {
		super();
		this.id = id;
		this.type = type;
		this.color = color;
		this.rentFee = rentFee;
		this.rentals = new ArrayList<>();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public List<Rental> getRentals() {
		return rentals;
	}


	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}


	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + ", color=" + color + ", rentFee=" + rentFee + ", rentals=" + rentals
				+ "]";
	}
	
	
	
	
	
}
