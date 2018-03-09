package madr.sp.emira.graph;

import java.util.LinkedList;

public class GraphAdjList {
	
	private int noOfNodes;
	private boolean isDirected;
	
	LinkedList<Edge<Integer, Integer>>[] nodeArray;
	
	public GraphAdjList(int noOfNodes, boolean isDirected) {
		this.isDirected = isDirected;
		this.noOfNodes = noOfNodes;
		nodeArray = (LinkedList<Edge<Integer, Integer>>[]) new LinkedList[noOfNodes];
		
		for (int i=0; i<noOfNodes; i++)
			nodeArray[i] = new LinkedList<Edge<Integer, Integer>>();
	}
	
	public void addEdge(Integer source, Edge<Integer, Integer> e) {
		if (source < noOfNodes && source > -1) {
			nodeArray[source].addFirst(e);
			if (!isDirected) {
				nodeArray[(int) e.getDestinationVertexValue()].addFirst(new Edge<Integer, Integer>(source, e.getEdgeWeight()));
			}
		}
	}
	
	public void addEdge(Integer source, Integer dest, Integer weight) {
		if (isValid(source.intValue(), dest.intValue())) {
			Edge<Integer, Integer> e = new Edge<Integer, Integer>(dest, weight);
			addEdge(source, e);
		}
	}
	
	private boolean isValid(int i, int j) {
		return i>=0 && j>=0 && i<noOfNodes && j<noOfNodes;
	}

	public int getNoOfNodes() {
		return noOfNodes;
	}
	
	public void print() {
		for (int i=0; i<noOfNodes; i++) {
			System.out.println(i + "=====>" + nodeArray[i]);			
		}
	}
	
	private class Edge <V,W> {
		
		private V endVertexValue;
		private W edgeWeight;
		
		public Edge(V v, W w) {
			endVertexValue = v;
			edgeWeight = w;
		}
		
		public V getDestinationVertexValue() {
			return endVertexValue;
		}
		
		public W getEdgeWeight() {
			return edgeWeight;
		}
		
		@Override
		public String toString() {
			return "(--" + edgeWeight.toString() + "--> " + endVertexValue.toString() + ")";
		}
	}
	
	public static void main(String[] args) {
		GraphAdjList graph = new GraphAdjList(4, true);
		int weight = 1;
		
		graph.addEdge(0, 1, weight);
		graph.addEdge(0, 3, weight);
		graph.addEdge(1, 2, weight);
		graph.addEdge(2, 0, weight);
		graph.addEdge(2, 3, weight);
		
		graph.print();
	}
}
