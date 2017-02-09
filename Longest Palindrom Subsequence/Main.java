import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		if (args.length<1){
			System.out.println("please specify a file name");
		}
		File inFile = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		
		int numOfCases = Integer.parseInt(br.readLine().split("\n")[0]);
		for (int i=0; i<numOfCases; i++){
			String str = br.readLine().split("\n")[0];
			int len= str.length();
			if (len<=0){
				System.out.println("Case"+(i+1)+": ");
			}
			else{
				String arr[] = new String[len];
				arr = str.split("(?!^)");
				String out = LongestPalindromeSubsequence(arr);
		       String result = "Case "+ (i+1)+":";
		       result += out;
		       System.out.println(result);
			}
		}


	}

	private static String LongestPalindromeSubsequence(String[] arr) {
		// TODO Auto-generated method stub
		//seq is the array that contains for each i, j, the direction of subsequence to consider.
		int seq[][]= new int[arr.length][arr.length];
		int sequenceLength = LongestPalindromeSubsequenceLength(arr, seq);
		String subseq = GetSubSequence(seq,arr,0, arr.length-1,"");
		return subseq;
	}

	private static String GetSubSequence(int[][] seq, String[] arr, int i, int j, String str) {
		// TODO Auto-generated method stub
		if (i>j)
			return str;
		else if (i==j)
			return str+arr[i];
		else if (seq[i][j]==1){
			return (arr[i]+GetSubSequence(seq, arr, i+1, j-1, str)+ arr[i]);
		}
		else if (seq[i][j]== 3){
			return GetSubSequence(seq, arr, i+1, j, str);
		}
		else if (seq[i][j]== 2){
			return GetSubSequence(seq, arr, i, j-1, str);
		}
		return "";
	}

	private static int LongestPalindromeSubsequenceLength(String[] arr, int[][] seq) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int len[][]= new int[n][n];
		//int seq[][]=new int[n][n];
		for (int i=0; i<=n-2; i++){
			len[i][i]=1;
			int j =i+1;
			if (arr[j].equals(arr[i])){
				len[i][j]=2;
				seq[i][j]= 1;
			}
			else {
				len[i][j]=1;
				seq[i][j]= 3;
			}
		}
		len[n-1][n-1] =1; // because in the above loop j cannot go to n
		for (int i=n-3; i>=0; i--){
			for (int j=i+2; j<n; j++){
				if(arr[i].equals(arr[j])){
					len[i][j]= len[i+1][j-1]+2;
					seq[i][j] = 1;
				}
				else
					//len[i][j]= Math.max(len[i][j-1], len[i+1][j]);
					if (len[i][j-1]>len[i+1][j]){
						len[i][j]=len[i][j-1];
						seq[i][j]=2;
					}
					else{
						len[i][j]= len[i+1][j];
						seq[i][j]=3;
					}
			}
		}
		
		
		return len[0][n-1];
	}

}
