public class Swap {

	public static void main(String args[]) {
		Animal a = new Animal("Lion");
		Animal b = new Animal("tiger");
		System.out.println("Before a: " + a.getName() + ", b: " + b.getName());
		swap(a,b);
		System.out.println("After a: " + a.getName() + ", b: " + b.getName());

		System.out.println("Swapping the values");
		int x = 100;
		int y = 200;
		System.out.println("Before x: " + x + ", y: " + y);
		swapInt(x,y);
		System.out.println("After x: " + x + ", y: " + y);
	}

	public static void swap(Animal a, Animal b){
		Animal temp = new Animal("");
		temp = a;
		a = b;
		b = temp;
	}
	
	public static void swapInt(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}

	public static void modify(Animal animal) {
		animal.setName("Tiger");
	}

}