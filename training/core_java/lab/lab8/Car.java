class Car {
	String model;
	String make;
	static String[] availableColors = { "red", "brown", "orange", "white", "blue" };
	String color;
	int numOfGears;
	boolean isAutoTransmission;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumOfGears() {
		return numOfGears;
	}

	public void setNumOfGears(int numOfGears) {
		this.numOfGears = numOfGears;
	}

	public boolean isAutoTransmission() {
		return isAutoTransmission;
	}

	public void setAutoTransmission(boolean isAutoTransmission) {
		this.isAutoTransmission = isAutoTransmission;
	}
	
	public static void main(String argsp[]){
		//Create an object of i10 car
		Car i10 = new Car();
		i10.setMake("Hyundai");
		i10.setModel("i10");
		i10.setColor(availableColors[0]);
		i10.setAutoTransmission(false);
		
		
		//Create an object of Maruti 800 car
		Car maruti800 = new Car();
		maruti800.setMake("Maruti Suzuki");
		maruti800.setModel("Maruti 800");
		maruti800.setColor(availableColors[3]);
		maruti800.setAutoTransmission(false);
		
		System.out.println("The color of the maruti car is " + maruti800.getColor());
		System.out.println("The color of the i10 car is " + i10.getColor());
	}
}