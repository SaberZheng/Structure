package ecut.sort;

public class RootOfTwo {
	public static void main(String[] args) {
		double x = 0;
		double i,j,y;
		for(j=0.0;j<=12;j++){
			for(i=1.0;i<9.0;i++){
				if(Math.pow(x+(i/Math.pow(10.0, j)), 2)>2){
					x=x+((i-1)/Math.pow(10.0, j));
					break;
				}
				
			}
		}
		System.out.println(x);
		y=Math.sqrt(2.0);
		System.out.println(y);
		System.out.println(1e-7);
		
	}

}
