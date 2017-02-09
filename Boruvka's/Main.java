import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length<1){
			System.out.println("please specify a file name");
			return;
		}
		File inFile = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		
		int numOfCases = Integer.parseInt(br.readLine().split("\n")[0]);
		for (int i=0; i<numOfCases; i++){
		    int vert = Integer.parseInt(br.readLine().split("\n")[0]);
		    int edges = Integer.parseInt(br.readLine().split("\n")[0]);
		    Graph graph = new Graph(vert, edges);
		    HashMap<Integer, Edge > EdgeList = new HashMap<Integer, Edge>();
		    HashMap<Edge, Integer > EdgeList2 = new HashMap<Edge, Integer>();
		    Edge[] edgeArray= new Edge[edges];
		    for (int j =1; j<=edges; j++){
		    	String edgeInfo[] = br.readLine().split(" ");
		    	int src = Integer.parseInt(edgeInfo[0]);
		    	int dest = Integer.parseInt(edgeInfo[1]);
		    	int weight = Integer.parseInt(edgeInfo[2]);
		    	edgeArray[j-1] = graph.addEdge(src, dest, weight);
		    	EdgeList.put(j, edgeArray[j-1]);
		    	EdgeList2.put(edgeArray[j-1], j);
		    }
		    
			if (vert<=0 || edges <=0){
				System.out.println("Case"+(i+1)+": ");
			}
			else{
				Forest forest =BoruvkaMST(graph,edgeArray);
				int edgeNums[] = new int[forest.edgecount];
				String out = "";
				for (int j=0; j<forest.edgecount; j++){
					Edge edge = forest.edges.get(j);
					edgeNums[j] = EdgeList2.get(edge);
					
				}
				Sorter.MergeSort(edgeNums);
				for (int j=0; j<edgeNums.length; j++)
					out += edgeNums[j]+" ";
		       String result = "Case "+ (i+1)+":";
		       result += out;
		       System.out.println(result);
			}
		

	}
	}

	private static Forest BoruvkaMST(Graph graph, Edge[] edgeArray) {
		// TODO Auto-generated method stub
		int v = graph.vert;
		Forest forest = new Forest(v);
		Sorter.MergeSortEdge(edgeArray);
		while(forest.count >1)
		MTSRec(graph, edgeArray, forest);
		return forest;
	}

	
	private static void MTSRec(Graph graph, Edge[] edgeArray, Forest forest) {
		
		forest.Label();
		if (forest.count ==1)
			return;
		Edge[] S = new Edge[forest.count];
		for (int i=0; i<forest.count; i++){
			S[i] = new Edge(0,0,Integer.MAX_VALUE);
		}
		for (int i=0; i<edgeArray.length; i++){
			Edge edge = edgeArray[i];
			int s = edge.source-1;
			int d = edge.destination-1;
			int labelS = forest.labels[s];
			int labelD = forest.labels[d];
			if (forest.labels[s] == forest.labels[d])
				continue;
			if (S[labelS].weight > edge.weight){
				S[labelS]= edge;
			}
			if (S[labelD].weight>edge.weight){
				S[labelD]=edge;
			}
			
		}
		forest.addEdges(S);
		
	}
	

	

	
}
