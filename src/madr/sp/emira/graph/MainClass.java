package madr.sp.emira.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class MainClass {
	
	class Vertex<T> {
		T data;
		boolean visited;

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private static int SIZE = 16;
	
	static Set<Character> visited;
	static Set<Integer> visitInt;
	
	static String result= "";
	
	static boolean acyclic = true;;
	
	public static void main(String[] args) {
		SIZE = 8;
		visited = new HashSet<Character>(SIZE);
		visitInt = new HashSet<Integer>(SIZE);

		GenericAdjList<Character, Integer> graph = new GenericAdjList<Character, Integer>(SIZE, false);
		getSampleDataPopulated(graph);
		graph.print();
		System.out.println(hasCycle(graph));
		
		GenericAdjList<Integer, Integer> directedGraph = new GenericAdjList<Integer, Integer>(SIZE, true);
		populateDAG(directedGraph);
		System.out.println();
		directedGraph.print();
		
		topologicalSortUtil(directedGraph);
		/*bfsQeue(graph, 'A');
		System.out.println(result);*/
		
		/*dfsRecursive(graph, 'A');
		System.out.println(result);*/
		
		/*result = "";
		visited.clear();
		System.out.println("resilt : " + result);
		
		dfsStack(graph, 'A');
		System.out.println(result);*/
	}

	private static void topologicalSortUtil(GenericAdjList<Integer, Integer> directedGraph) {
		Stack<Integer> s = new Stack<Integer>();
		/*topologicalSort(directedGraph,7,s);
		topologicalSort(directedGraph,5,s);
		topologicalSort(directedGraph,3,s);*/
		
		topologicalSort(directedGraph, 2, s);
		topologicalSort(directedGraph, 1, s);
		
		System.out.println();
		while (!s.isEmpty()) {
			System.out.print((char)(s.pop()+64)+ ", ");
		}
	}

	private static void populateDAG(GenericAdjList<Integer, Integer> dag) {
		int weight = 0;
		/*dag.addEdge(7, 11, weight);
		dag.addEdge(7, 8, weight);
		dag.addEdge(5, 11, weight);
		dag.addEdge(3, 8, weight);
		dag.addEdge(3, 10, weight);
		dag.addEdge(8, 9, weight);		
		dag.addEdge(11, 2, weight);		
		dag.addEdge(11, 9, weight);		
		dag.addEdge(11, 10, weight);*/
		
		dag.addEdge(1, 3, weight);
		dag.addEdge(2, 3, weight);
		dag.addEdge(2, 4, weight);		
		dag.addEdge(3, 5, weight);
		dag.addEdge(4, 6, weight);
		dag.addEdge(5, 6, weight);
		dag.addEdge(5, 8, weight);
		dag.addEdge(6, 7, weight);
	}

	private static void getSampleDataPopulated(GenericAdjList<Character, Integer> graph) {
		graph.addEdge('A', 'B', 0);
		graph.addEdge('B', 'H', 0);
		graph.addEdge('B', 'C', 0);
		graph.addEdge('C', 'D', 0);
		graph.addEdge('C', 'E', 0);
		//graph.addEdge('D', 'F', 0);
		graph.addEdge('E', 'F', 0);
		graph.addEdge('E', 'G', 0);
		graph.addEdge('E', 'H', 0);
		
		/*graph.addEdge('A', 'C', 0);
		graph.addEdge('A', 'B', 0);
		graph.addEdge('B', 'E', 0);
		graph.addEdge('B', 'D', 0);
		graph.addEdge('C', 'E', 0);
		graph.addEdge('D', 'F', 0);
		graph.addEdge('D', 'E', 0);
		graph.addEdge('E', 'F', 0);*/
	}
	
	/**
	 * Detects BackEdges as well.
	 * @param graph
	 * @param node
	 */
	public static void dfsRecursive(GenericAdjList<Character, Integer> graph, Character node) {
		if (visited.contains(node) || visited.size() == SIZE) {
			return;
		} else {
			visited.add(node);
			result += node;
			LinkedList<Edge<Character, Integer>> neighbours = graph.adjMap.get(node);
			for (Edge<Character, Integer> edge : neighbours) {
				dfsRecursive(graph, edge.getDestinationVertexValue());
			}
		}
	}
	
	public static void dfsStack(GenericAdjList<Character, Integer> graph, Character node) {
		Stack<Character> s = new Stack<Character>();
		s.push(node);
		visited.add(node);
		result += node;
		while (!s.isEmpty()) {
			Character c = s.peek();
			Character next = getAdjUnvisitedNode(graph, c);
			if (next != null) {
				visited.add(next);
				result += next;
				s.push(next);
			} else {
				s.pop();
			}
		}
	}

	private static Character getAdjUnvisitedNode(GenericAdjList<Character, Integer> graph, Character node) {
		for (Edge<Character, Integer> e : graph.adjMap.get(node)) {
			if (!visited.contains(e.getDestinationVertexValue())) {
				return e.getDestinationVertexValue();
			}
		}
		return null;
	}
	
	/**
	 * Level Order Traversal
	 * -Suitable for Topological Sort => Ordering of vertices in a DIRECTED ACYCLIC Graph (DAG).
	 */
	public static void bfsQeue(GenericAdjList<Character, Integer> graph, Character node) {
		Queue<Character> q = new LinkedList<Character>();
		q.add(node);
		while (!q.isEmpty()) {
			Character curr = q.poll();
			if (!visited.contains(curr)) {
				result += curr;
				visited.add(curr);
			}
			for (Edge<Character, Integer> e : graph.adjMap.get(curr)) {
				Character child = e.getDestinationVertexValue();
				if (!visited.contains(child) && !q.contains(child))
					q.add(child);
			}
		}
	}
	
	/*
	 * check if graph has backEdges, that will make it sure that it has cycle.
	 */
	public static boolean hasCycle(GenericAdjList<Character, Integer> graph) {
		dfsCheckCycle(graph,'A',null);
		return !acyclic;
	}

	private static void dfsCheckCycle(GenericAdjList<Character, Integer> graph, Character curr, Character parent) {
		if (visited.contains(curr)) {
			acyclic = false;
			return;
		}
		
		visited.add(curr);
		LinkedList<Edge<Character, Integer>> neighbours = graph.adjMap.get(curr);
		for (Edge<Character, Integer> edge : neighbours) {
			if (edge.getDestinationVertexValue().equals(parent) && visited.contains(parent)) {
				continue;
			}
			dfsCheckCycle(graph, edge.getDestinationVertexValue(),curr);
		}
	}
	
	public static void topologicalSort(GenericAdjList<Integer, Integer> graph, Integer v, Stack<Integer> s) {
		if (visitInt.contains(v))
			return;
		
		visitInt.add(v);
		LinkedList<Edge<Integer, Integer>> list = graph.adjMap.get(v);
		if (list != null) {
			for (Edge<Integer, Integer> e : list) {
				topologicalSort(graph, e.getDestinationVertexValue(), s);
			}
		}
		//when all adjacent nodes are done
		s.push(v);
	}
}
