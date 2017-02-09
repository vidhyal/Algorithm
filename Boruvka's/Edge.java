
public class Edge {
  int source;
  int destination;
  int weight;
  public Edge(int u, int v, int w){
	  this.source =u;
	  this.destination =v;
	  this.weight=w;
  }
  public int getOther( int u){
	  if (source == u)
		  return destination;
	  if (destination ==u){
		  return source;
	  }
	  return Integer.MIN_VALUE;
  }
}
