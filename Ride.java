/*
 * A class that represents a ride in an amusement park
 * It maintains the requirements for riding
 */


public class Ride {

	private int ageReq;
	private int ticketReq;
	private double heightReq;
	
	
	//Default constructor that should use the park minimums to determine requirements:
	// Park minimum age: 3
	// Park minimum height: 30
	// Park minimum ticket price: 3
	public Ride() {
		//TODO call the specifying constructor with the default values
		this.ageReq = 3;
		this.ticketReq = 3;
		this.heightReq = 30;
	}
	
	//Specifying constructor 
	public Ride(double heightReq, int ageReq ,int ticketReq) {
		//TODO implement the specifying constructor
		this.heightReq = heightReq;
		this.ageReq = ageReq;
		this.ticketReq = ticketReq;
	}

	/**
	 * getter for age requirement
	 * @return the age requirement of this ride
	 */
	public int getAgeReq() {
		//TODO return the correct value
		return ageReq;
	
	}

	/**
	 * Set the age requirement for this ride. Set to the minimum
	 * if a value below the minimum is given.
	 * @param ageReq lowest age requirement should be 3.
	 */
	public void setAgeReq(int ageReq) {
		//TODO finish this method
		if (ageReq < 3) {
			ageReq = 3;
			this.ageReq = ageReq;
		}
		else
			this.ageReq = ageReq;
	}

	/**
	 * getter for ticket requirement
	 * @return the ticket requirement of this ride
	 */
	public int getTicketReq() {
		//TODO return the correct value
		return ticketReq;
	}

	
	/**
	 * 
	 * Set the ticket requirement for this ride. Set to the minimum
	 * if a value below the minimum is given.
	 * @param ticketReq lowest ticket requirement should be 3.
	 */
	public void setTicketReq(int ticketReq) {
		//TODO finish this method
		if (ticketReq < 3) {
			ticketReq = 3;
			this.ticketReq = ticketReq;
			
		}
		this.ticketReq = ticketReq;
	}

	/**
	 * getter for height requirement
	 * @return the height requirement of this ride
	 */
	public double getHeightReq() {
		//TODO return the correct value
		
		return heightReq;
	}

	/**
	 * 
	 * Set the height requirement for this ride. Set to the minimum
	 * if a value below the minimum is given.
	 * @param heightReq lowest height requirement should be 30
	 */
	public void setHeightReq(double heightReq) {
		//TODO finish this method
		if (heightReq < 30) {
			heightReq = 30;
			this.heightReq = heightReq;
		}
		else
			this.heightReq = heightReq;
	}
	
	
	
	
}
