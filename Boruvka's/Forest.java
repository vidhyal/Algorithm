import java.util.ArrayList;
import java.util.List;

public class Forest {

	List<Edge> edges ;
	int[] labels;
	int count;
	int edgecount;
	List<Edge>[] AdjEdge;
	@SuppressWarnings("unchecked")
	public Forest(int n){
		count = n;
		edgecount=0;
		labels= new int[n];
		for (int i=0; i< n; i++){
			labels[i]= i;
		}
		edges= new ArrayList<Edge>();
		
		AdjEdge = (List<Edge>[])new ArrayList[n];
		  for (int i =0; i<n; i++){
			  AdjEdge[i] = new ArrayList<Edge>();
		  }
	}
	
	public void addEdge(Edge e){
		edges.add(e);
		int s =e.source;
		int d = e.destination;
		if (labels[s-1]<labels[d-1])
			labels[d-1]=labels[s-1];
		else
			labels[s-1]= labels[d-1];
		//count--;
		AdjEdge[s-1].add(e);
		AdjEdge[d-1].add(e);
		edgecount++;
	}
	public void Label() {
		// TODO Auto-generated method stub
		int n= labels.length;
		int lab2[] = new int[labels.length];
		int CompCount=0;
		int check[] = new int[n];
		
		for (int i=0; i<n ; i++){
			int p =checkBFS(check, lab2, CompCount, i);
			CompCount =p;
		}
		for (int i=0; i<count; i++)
			labels[i]=lab2[i];
		count = CompCount;
	}
	private int checkBFS(int[] check, int[] lab2, int CompCount, int i) {
		// TODO Auto-generated method stub
		if (check[i]==0){
			lab2[i]=CompCount;
			check[i]=1;
			for(Edge e: AdjEdge[i]){
				int j = e.getOther(i+1)-1;
				checkBFS(check, lab2, CompCount, j);
			}
			CompCount++;}
		return CompCount;
		
	}

	public void addEdges(Edge[] S) {
		for (int i=0; i<S.length; i++){
			Edge e = S[i];
			if (labels[e.source-1] != labels[e.destination-1])
				this.addEdge(e);
		}

	}
	
	
	
	
	
}
