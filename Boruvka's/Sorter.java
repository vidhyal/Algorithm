
public class Sorter {
	static void MergeSortEdge(Edge[] arr) {
		// TODO Auto-generated method stub
		SortEdge(arr,0,arr.length-1);
	}

	private static void SortEdge(Edge[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if (l<r){
			int m = (l+r)/2;
			SortEdge(arr,l,m);
			SortEdge (arr, m+1, r);
			MergeEdge(arr,l,m,r);
		}
		
	}

	private static void MergeEdge(Edge[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int len1 = m-l+1;
		int len2 = r-m;
		
		Edge left[] = new Edge[len1];
		Edge right[] = new Edge[len2];
		
		for (int i=0; i<len1; i++){
			left[i] = arr[l+i];
		}
		for (int i=0; i<len2; i++){
			right[i]= arr[m+1+i];
		}
		
		int i=0, j=0, k=l;
		while(i<len1 && j<len2){
			if (left[i].weight <right[j].weight){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k]= right[j];
				j++;
			}
			k++;
		}
		while (i<len1){
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j<len2){
			arr[k] = right[j];
			j++;
			k++;
		}
		
	}

	static void MergeSort(int[] arr) {
		// TODO Auto-generated method stub
		Sort(arr,0,arr.length-1);
	}

	private static void Sort(int[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if (l<r){
			int m = (l+r)/2;
			Sort(arr,l,m);
			Sort (arr, m+1, r);
			Merge(arr,l,m,r);
		}
		
	}

	private static void Merge(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int len1 = m-l+1;
		int len2 = r-m;
		
		int left[] = new int[len1];
		int right[] = new int[len2];
		
		for (int i=0; i<len1; i++){
			left[i] = arr[l+i];
		}
		for (int i=0; i<len2; i++){
			right[i]= arr[m+1+i];
		}
		
		int i=0, j=0, k=l;
		while(i<len1 && j<len2){
			if (left[i] <right[j]){
				arr[k] = left[i];
				i++;
			}
			else{
				arr[k]= right[j];
				j++;
			}
			k++;
		}
		while (i<len1){
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j<len2){
			arr[k] = right[j];
			j++;
			k++;
		}

				
	}

}
