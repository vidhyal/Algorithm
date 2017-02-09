This program implements the Boruvka's Minimum Spanning Tree Algorithm using Union-Find sets, for a connected graph.

It takes an input file in the format:
. First line contains a number C>= 0 of test cases in the file.
. Then comes C test cases, each describing a weighted connected graph and consisting of:
	- Line containing the number V>=2 of vertices.
	- Line containing the numbe rof edges E.
	- For each edge i: 1<= i <= E, a line describing edge ei by three space separated numbers v1 v2 w where v1 and v2 are the vertex numbers of the edge's endpoints, with 1 <= v1 <= v2 < V and w is an integer edge weight.