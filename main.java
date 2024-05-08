import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


//順列全探索、参照  https://qiita.com/rskkit0/items/1184297b371d4ab182c9

class main {


  public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
    System.out.println("都市数を入力してください");
    int n = scanner.nextInt();
		
		
		int [] x = new int [n];
		int [] y = new int [n];
		
		
		Ex_1 ex_1 = new Ex_1();
		double l,l1,L;
		double L1_result = 1000000000;
		double L2_result = 1000000000;
		double L3_result = 1000000000;
		ArrayList<Integer> z;
		ArrayList<Integer> z_result = new ArrayList<Integer>();
		z_result.add(0);
		
		//都市を生成
		random.Rand_generate(x,y);
		random.display(x,y);

		

		long startTime = System.currentTimeMillis();			
		//最近隣法での最適解
		for(int i = 0; i < n; i++){
			
		
			l = ex_1.Nearest_Neighbor(i,x,y);
			z = ex_1.Nearest_Neighbor_list();			
	
			//すべてのルートにおける最短距離が出ると結果を更新
			if(l < L1_result){
				L1_result = l;
				z_result.clear();
				z_result = z;		
			}	

		}
		long endTime = System.currentTimeMillis();
		System.out.println("＜最近隣法＞");
		System.out.println("平均処理時間：" + (endTime - startTime)/n + " ミリ秒");
		System.out.println("最適解:"+z_result);
		System.out.println("総距離:"+L1_result);



		
	
		
		//2_opt法での最適解
		long startTime1 = System.currentTimeMillis();
		for(int i = 0; i < n; i++){
			
			//最近隣法を実施
			l = ex_1.Nearest_Neighbor(i,x,y);
			z = ex_1.Nearest_Neighbor_list();
			
			//2_optを実施
			l1 = ex_1.two_opt(x,y,z);
			//すべてのルートにおける最短距離が出ると結果を更新
			if(l < L2_result){
				L2_result = l1;
				z_result.clear();
				z_result = z;		
			}			
			
		}
		
		long endTime1 = System.currentTimeMillis();
		System.out.println();
		System.out.println("＜2_opt近傍法＞");
		System.out.println("平均処理時間：" + (endTime1 - startTime1)/n + " ミリ秒");
		System.out.println("最適解"+ z_result );
		System.out.println("総距離" + L2_result);
	}
	
	
    private static void permutation( ArrayList<Integer> seed, int []x, int []y) {
        int[] perm = new int[seed.size()];
        boolean[] used = new boolean[seed.size()];
        buildPerm(seed, perm, used, 0, x, y);
    }

    private static void buildPerm( ArrayList<Integer> seed, int[] perm, boolean[] used, int index, int []x, int []y) {
				ArrayList<Integer> z = new ArrayList<>();
        if (index == seed.size()) {

					for(int i = 0; i <= perm.length; i++){
						if(i != perm.length){
							z.add(perm[i]);
						}else{
							z.add(perm[0]);
						}
						
					}
					
					System.out.println(z);
					System.out.println();
					 
            return;
        }
			}
}


