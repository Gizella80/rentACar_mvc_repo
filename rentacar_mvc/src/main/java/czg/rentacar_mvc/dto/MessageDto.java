package czg.rentacar_mvc.dto;

public class MessageDto {

	private int reservationId;
	private RentalDto rental;
	
	private String userName;
	private String userEmail;
	private String userAddress;
	private String userPhone;
	
	
	public MessageDto(int reservationId, RentalDto rental, String userName, String userEmail, String userAddress,
			String userPhone) {
		super();
		this.reservationId = reservationId;
		this.rental = rental;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
	}


	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public RentalDto getRental() {
		return rental;
	}

	public void setRental(RentalDto rental) {
		this.rental = rental;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "MessageDto [reservationId=" + reservationId + ", rental=" + rental + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userAddress=" + userAddress + ", userPhone=" + userPhone + "]";
	}
	
	
}


