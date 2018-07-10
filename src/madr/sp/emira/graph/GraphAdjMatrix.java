package madr.sp.emira.graph;

public class GraphAdjMatrix {
	
	private int v; //No of Nodes
	private Integer[][] matrix;
	
	public GraphAdjMatrix(int noOfNodes, int initializeWith) {
		v = noOfNodes;
		matrix = new Integer[v][v];
		
		for (int i=0; i<v; i++)
			for (int j=0; j<v; j++)
				matrix[i][j] = initializeWith;
	}
	
	public void addEdge(Integer weight, int i, int j) {
		if (isValid(i, j)) {
			matrix[i][j] = weight;
		}
	}
	
	public void addUndirectedEdge(Integer weight, int i, int j) {
		if (isValid(i, j)) {
			matrix[i][j] = weight;
			matrix[j][i] = weight;
		}
	}
	
	public Integer getWeight(int i, int j) {
		if (isValid(i, j)) {
			return matrix[i][j];
		} else {
			throw new IllegalArgumentException("Please give valid vertex");
		}
	}

	private boolean isValid(int i, int j) {
		return i>=0 && j>=0 && i<v && j<v;
	}

	public Integer[][] getMatrix() {
		return matrix;
	}
	
	public void printGraph() {
		int i=0,j=0;
		char c = 'A';
		System.out.print("#");
		for (int k=0; k<v; k++)
			System.out.print("  " + c++);
		System.out.println();
		System.out.println();
		c = 'A';
		for(;i<v;i++) {
			System.out.print(c);
			for(;j<v;j++) {
				System.out.print("  "+matrix[i][j]);
			}
			j=0;
			System.out.println();
			System.out.println();
			c++;
		}
	}
	
	public static void main(String[] args) {
		GraphAdjMatrix graph = new GraphAdjMatrix(7, 0);
		//int weight = 1; // as of now without weight
		graph.addUndirectedEdge(7, 0, 2);
		graph.addUndirectedEdge(5, 0, 3);
		graph.addUndirectedEdge(8, 1, 2);
		graph.addUndirectedEdge(5, 1, 4);
		graph.addUndirectedEdge(9, 2, 3);
		graph.addUndirectedEdge(7, 2, 4);
		graph.addUndirectedEdge(15, 3, 4);
		graph.addUndirectedEdge(6, 3, 5);
		graph.addUndirectedEdge(8, 4, 5);
		graph.addUndirectedEdge(9, 4, 6);
		graph.addUndirectedEdge(11, 5, 6);
		
		graph.printGraph();
	}
}
