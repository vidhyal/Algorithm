import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		if (args.length<1){
			System.out.println("please specify a file name");
		}
		File inFile = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		
		int numOfCases = Integer.parseInt(br.readLine().split("\n")[0]);
		for (int i=0; i<numOfCases; i++){
			int n = Integer.parseInt(br.readLine().split("\n")[0]);
			if (n<=0){
				System.out.println("Case"+(i+1)+": ");
			}
			else{
				int arr[] = new int[n];
				String line[] = (br.readLine()).split(" ");
		    	for (int j=0; j<n; j++){
		    		arr[j] = Integer.parseInt(line[j]);                   
		    	}
		    	int res[] = new int[n];
		    	res = P_Scan_3(arr);
		       String result = "Case "+ (i+1)+":";
		       for (int j=0; j<n; j++){
		    	   result += " "+res[j];
		       }
		       System.out.println(result);
			}
		}

	}

	private static int[] P_Scan_3(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int y[] = new int[n];
		int t[] = new int[n];
		y[0] = arr[0];
		if (n>1){
			P_Scan_Up(arr,t,1,n-1);
			P_Scan_Down(arr[0],arr,t,y,1,n-1);
		}
		return y;
		
	}

	private static int P_Scan_Up(int[] arr, int[] t, int i, int j) {
		// TODO Auto-generated method stub
		if (i==j)
			return arr[i];
		else{
			int k = (int) Math.floor((i+j)/2); 
			t[k]= P_Scan_Up(arr, t, i, k);
			int right = P_Scan_Up(arr, t, k+1, j);
			return t[k]+right;
		}
		
		
	}

	private static void P_Scan_Down(int v,int[] x, int[] t, int[] y, int i, int j) {
		// TODO Auto-generated method stub
		if (i==j){
			y[i] =  v+ x[i];
		}
		else{
			int k = (int) Math.floor((i+j)/2);
			P_Scan_Down(v, x, t, y,i, k);
			P_Scan_Down(v+t[k],x,t,y,k+1,j);
		}
		
		
	}

}
