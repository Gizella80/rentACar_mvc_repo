package czg.rentacar_mvc.dto;



public class CarDto {
	private int id;
	
	private String type;
	
	private String color;
	
	private int rentFee;

	public CarDto(int id, String type, String color, int rentFee) {
		super();
		this.id = id;
		this.type = type;
		this.color = color;
		this.rentFee = rentFee;
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

	@Override
	public String toString() {
		return "CarDto [id=" + id + ", type=" + type + ", color=" + color + ", rentFee=" + rentFee + "]";
	}
	
	
	

}
