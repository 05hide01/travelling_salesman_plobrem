import java.util.Random;

public class random{
	
	public static void Rand_generate(int []x, int []y){
		Random rand = new Random();
		
		for(int i = 0; i < x.length ;i++){
			x[i] = rand.nextInt(1000);
			y[i] = rand.nextInt(1000);
		}				
	}

	public static void display(int []x, int []y){
		System.out.println("x[i]:y[i],x[i]の座標:y[i]の座標");
		
		for(int i = 0; i < x.length; i++){
			System.out.println("x[" + i + "],y[" + i + "]: "+ x[i]+ " : "+ y[i]);
		}
		System.out.println();		
	}
}