import java.util.List;
import java.util.*;

public class Graph {
int vert;
int edges;
List<Edge>[] edge;
  @SuppressWarnings("unchecked")
public Graph(int v,int e){
	  this.vert = v;
	  this.edges = e;
	  this.edge = (List<Edge>[])new ArrayList[v];
	  for (int i =0; i<v; i++){
		  edge[i] = new ArrayList<Edge>();
	  }
  }
  public Edge addEdge(int u, int v, int w){
	  Edge e = new Edge(u, v, w);
	  edge[u-1].add(e);
	  edge[v-1].add(e);
	  return e;
  }
}
