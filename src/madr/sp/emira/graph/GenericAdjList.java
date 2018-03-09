package madr.sp.emira.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericAdjList<V,W extends Comparable<W>> {
	
	private int noOfNodes;
	private boolean isDirected;
	
	Map<V, LinkedList<Edge<V, W>>> adjMap;
	
	public GenericAdjList(int noOfNodes, boolean isDirected) {
		this.isDirected = isDirected;
		this.noOfNodes = noOfNodes;
		adjMap = new HashMap<V, LinkedList<Edge<V, W>>>();
	}
	
	public void addEdge(V source, Edge<V, W> e) {
		if (adjMap.containsKey(source)) {
			(adjMap.get(source)).addFirst(e);
		} else {
			LinkedList<Edge<V, W>> list = new LinkedList<Edge<V, W>>();
			list.add(e);
			adjMap.put(source, list);
		}
	}
	
	public void addEdge(V source, V dest, W weight) {
		Edge<V, W> e = new Edge <V, W>(dest, weight);
		addEdge(source, e);
		if (!isDirected) {
			addEdge(dest, new Edge<V, W>(source, weight));
		}
	}
	
	public boolean isDirectedGraph() {
		return isDirected;
	}

	public int getNoOfNodes() {
		return noOfNodes;
	}
	
	public void print() {
		Set<Entry<V, LinkedList<Edge<V, W>>>> s = adjMap.entrySet();
		for (Entry<V, LinkedList<Edge<V, W>>> e : s) {
			System.out.println(e.getKey().toString() + " : " + e.getValue().toString());
		}
	}
	
}

class Edge <V,W extends Comparable<W>> implements Comparable<Edge<V, W>>{
	
	private V endVertexValue;
	private W edgeWeight;
	private Map<V, W> map; //this is when we need to update the value of weight in heap. for Dijkstra's
	
	public Edge(V v, W w) {
		endVertexValue = v;
		edgeWeight = w;
	}
	
	public Edge(V v, W w, Map<V, W> m) {
		endVertexValue = v;
		edgeWeight = w;
		map = m;
	}
	
	public V getDestinationVertexValue() {
		return endVertexValue;
	}
	
	public W getEdgeWeight() {
		if (map != null && map.containsKey(endVertexValue)) {
			return map.get(endVertexValue);
		}
		return edgeWeight;
	}
	
	@Override
	public boolean equals(Object obj) {
		//TODO: implement this.
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		if (edgeWeight.toString().equals("0")) {
			return "(----> " + endVertexValue.toString() + ")";
		}
		return "(--" + edgeWeight.toString() + "--> " + endVertexValue.toString() + ")";
	}

	@Override
	public int compareTo(Edge<V, W> o) {
		return getEdgeWeight().compareTo(o.getEdgeWeight());
	}
}
