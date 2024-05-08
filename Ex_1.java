import java.util.ArrayList;

public class Ex_1{
	int [] x ;
	int [] y ;
	ArrayList<Integer> z;
	

	//最近隣法で距離の合計値を算出
	public double Nearest_Neighbor(int start, int []x,int []y){
		double L = 10000000;
		int num = 0;
		double l;
		double l_sum = 0;
		z =  new ArrayList<>();
		z.add(start);
		
		for(int m = 0; m < x.length - 1; m++){
			L = 10000000;
			for(int i = 0; i < x.length; i++){
				if(z.contains(i)){continue;}
				else{
					l = Math.pow(x[z.get(0)] - x[i],2) + Math.pow(y[z.get(0)] - y[i],2);
					l_sum += Math.sqrt(l);
				}
				if(L > l){
					L = l;
					num = i;
				}
			}
			z.add(num);
		}
		
		z.add(start);
		l_sum += Math.sqrt(Math.pow(x[z.get(0)] - x[z.get( x.length - 1)],2) + Math.pow(y[z.get(0)] - y[ x.length - 1],2));
		
		return l_sum;
	}
	
	
	//経路を入れたArrayListを返す
	public ArrayList<Integer>  Nearest_Neighbor_list(){
		return z;
	}
	
	//2_opt法
	public double two_opt(int []x,int []y, ArrayList<Integer> z) {

		double l = 0;
		while(true){
			double max=0.0;//その時点での短縮された距離の最大値
			int i_=0,j_=0;//その時点で枝の入れ替えによってもっとも移動距離短縮となる位置を記憶する
	
			for(int i=0;i<z.size()-1;i++){
				for(int j=0;j<z.size()-1;j++){
					double r1 = Math.sqrt(Math.pow(x[z.get(i)] - x[z.get(i+1)],2) + Math.pow(y[z.get(i)] -y[z.get(i+1)],2))+Math.sqrt(Math.pow(x[z.get(j)] - x[z.get(j+1)],2) + Math.pow(y[z.get(j)] - y[z.get(j+1)],2));

					double r2 = Math.sqrt(Math.pow(x[z.get(i)] - x[z.get(j)],2) + Math.pow(y[z.get(i)] - y[z.get(j)],2))+Math.sqrt(Math.pow(x[z.get(i+1)] - x[z.get(j+1)],2) + Math.pow(y[z.get(i+1)] - y[z.get(j+1)],2));
		
//r1は付け替える前の枝2本の長さの和、r2は付け替えた後の枝2本の長さの和

					if(i!=j && i!=j+1 && (i+1)!=j && (i+1)!=(j+1) && r2>r1){
						if((r2-r1)>max){
							max=r2-r1;
							i_=i;
							j_=j;
						}	
					}//選んだ4つの点がすべて違うときのみ(r2-r1)とmaxを比較
				}
			}//for文終了、付け替えたときに短縮距離が最大となる点の位置が決定された

			
			if(i_==0 && j_==0){break;}//もし入れ替えが発生していなければwhile文からbreak

			if(i_==z.size()-2||j_==0){
				int t=z.get(i_);
				z.set(i_,z.get(j_+1));
				z.set(j_+1,t);
			}else{
				int t=z.get(i_+1);
				z.set(i_+1,z.get(j_));
				z.set(j_,t);
			}//枝の付け替え
		
		}

	for(int i = 0; i < z.size()-1; i++){
		l += Math.sqrt(Math.pow(x[z.get(i)] - x[z.get(i + 1)], 2) + Math.pow(y[z.get(i)] - y[z.get(i + 1)], 2));
	}
	return l;
	}

	
}