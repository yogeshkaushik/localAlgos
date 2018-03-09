package madr.sp.emira.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import madr.sp.emira.tree.bst.BinaryMinHeap;

/**
 * 1. Shortest Path from source 's' to any vertices in DAGs ==> First get topological order {@link ShortestPathAlgos#topologicalSort}, 
 * 		(works with -ve edges as well)							then iterate from left->right.{@link ShortestPathAlgos#shortestPathForTopologicalOrder}
 * 2. Shortest Path in un-weighted directed graph ==> Use BFS {@link MainClass#bfsQeue}
 * 													 refer method {@link ShortestPathAlgos#shortestPathUnweighted}
 * 3. Dijkstra's Algo (It's a greedy algo) ==> for all kind of graphs except those with -ve edges.
 * 		For any implementation of the vertex set Q, the running time is in
 * 		O (|E|*T(k) + |V|*T(m)), where T(d) and T(m) are the complexities of the {@value : decrease-key} and {@value: extract-minimum}} operations in Q,
 * 		respectively. The simplest implementation of Dijkstra's algorithm stores the vertex set Q as an ordinary linked list or array, and extract-minimum
 * 		is simply a linear search through all vertices in Q. 
 * 		In this case, the running time is O(|E| + |V|^2) = O(|V|^2);
 * 		
 * 4. Bellman-Ford Algo ====>  Richard Bellman gave the name Dynamic programming to DP. 
 * 
 * @author yogeshk
 * @since https://www.youtube.com/watch?v=2E7MmKv0Y24
 *
 */
public class ShortestPathAlgos {
	static int no = 8;
	
	public static void main(String[] args) {
		
		ShortestPathAlgos clazz = new ShortestPathAlgos();
		boolean isDirected = true;
		GenericAdjList<Character, Integer> graph = new GenericAdjList<>(no, isDirected);
		populateGraphData(graph);
		
		graph.print();
		
		
		List<Character> list = clazz.topologicalSort(graph, 'A');
		System.out.println(list);
		System.out.println(clazz.shortestPathForTopologicalOrder(graph, list, 'A'));
		
		System.out.println(clazz.dijkstrasAlgo(graph, 'A'));
		
		System.out.println(clazz.belmanFordAlgo(graph, 'A'));
		
		//Test a special case, do above without applying topological sorting
		// It fails.... but might work without -ve edges, that's Dijkstra's algo i guess.
		/*List<Character> listDup = new LinkedList<Character>();
		listDup.addAll(graph.adjMap.keySet());
		System.out.println(listDup);
		System.out.println(clazz.shortestPathForTopologicalOrder(graph, listDup, 'C'));*/
		
		
		//System.out.println(clazz.shortestPathUnweighted(graph, 'C'));//works with un-weighted graph.
		
	}

	private static void populateGraphData(GenericAdjList<Character, Integer> graph) {
		//int weight = 1;
		/*graph.addEdge('C', 'A', 2);
		graph.addEdge('C', 'F', 6);
		graph.addEdge('A', 'B', 3);
		graph.addEdge('A', 'D', 2);
		graph.addEdge('B', 'D', -2);
		graph.addEdge('B', 'E', 4);
		graph.addEdge('D', 'F', 1);
		graph.addEdge('D', 'G', 0);
		graph.addEdge('E', 'G', -6);
		graph.addEdge('G', 'F', -3);*/
		
		graph.addEdge('A', 'B', 4);
		graph.addEdge('A', 'C', 1);
		graph.addEdge('B', 'E', 3);
		graph.addEdge('C', 'B', 2);
		graph.addEdge('C', 'D', 4);
		graph.addEdge('D', 'E', 4);
		graph.addEdge('E', 'F', 1);
		graph.addEdge('F', 'B', 3);
		no = 6;
	}
	
	public <V> Map<V, Integer> dijkstrasAlgo(GenericAdjList<V, Integer> graph, V source) {
		Map<V, Integer> distance = new HashMap<V, Integer>();
		Map<V, V> parent = new HashMap<V, V>();
		parent.put(source, null);
		BinaryMinHeap<Edge<V, Integer>> heap = initializePriorityQueue(source, distance);
		boolean heapify = false;
		while (!heap.isEmpty()) {
			Edge<V, Integer> edge = heap.deleteMin();
			V minVertex = edge.getDestinationVertexValue();
			LinkedList<Edge<V, Integer>> neighbours = graph.adjMap.get(minVertex);
			if (neighbours != null) {
				for (Edge<V, Integer> e : neighbours) {
					int sum = distance.get(minVertex) + e.getEdgeWeight(); // sometimes it can go -ve
																		   // when you add 1 to maxInt, it gives unsigned int which is -ve
					if (sum > 0 && sum < distance.get(e.getDestinationVertexValue())) {
						distance.put(e.getDestinationVertexValue(), sum);
						parent.put(e.getDestinationVertexValue(), minVertex);
						heapify = true;
					}
				}
			}
			/*see if we can selectively heapify particular index. like {@link BinaryMinHeap#percolateDown}*/
			if (heapify) {
				heap.createHeapBottomUp();
				heapify = false;
			}
		}
		return distance;
	}
	
	public <V> Map<V, Integer> belmanFordAlgo(GenericAdjList<V, Integer> graph, V source) {
		Map<V, Integer> distance = new HashMap<V, Integer>();
		distance.put(source, 0);
		// our edge implementation does not contain both the vertex
		//List<Edge<V, Integer>> allEdges = getAllEdges(graph);
		int i = 1;
		// iterate (Vertex -1) times
		for (;i<=no-1;i++) {
			//iterate over all the edges
			// this might look 3 'for' loops one inside another giving more complexity but it is not.
			relaxAllEdges(graph, distance);
		}
		
		//boolean isNegativeCycle = isNegativeCycleExist(graph,distance);
		return distance;
	}

	/**
	 * 
	 * @param graph
	 * @param distance
	 * @return boolean if distance table gets updated;
	 */
	private <V> void relaxAllEdges(GenericAdjList<V, Integer> graph, Map<V, Integer> distance) {
		//iterate over all the edges
		// this might look 2 'for' loops one inside another giving more complexity but it is not.
		for(Map.Entry<V, LinkedList<Edge<V, Integer>>> e : graph.adjMap.entrySet()) {
			V localSource = e.getKey();
			LinkedList<Edge<V, Integer>> adjList = e.getValue();
			for (Edge<V, Integer> edge : adjList) {
				V localDestination = edge.getDestinationVertexValue();
				if (distance.get(localSource) == null) {
					continue;
				} else {
					int newDist = distance.get(localSource) + edge.getEdgeWeight();
					if (distance.containsKey(localDestination)) {
						distance.put(localDestination, 
								distance.get(localDestination) > newDist ? 
										newDist : 
											distance.get(localDestination));
					} else {
						distance.put(localDestination, newDist);
					}
				}
			}
		}
	}

	private <V> List<Edge<V, Integer>> getAllEdges(GenericAdjList<V, Integer> graph) {
		List<Edge<V,Integer>> list = new LinkedList<Edge<V, Integer>>();
		for (LinkedList<Edge<V, Integer>> ll : graph.adjMap.values()) {
			list.addAll(ll);
		}
		return list;
	}

	private <V> BinaryMinHeap<Edge<V, Integer>> initializePriorityQueue(V v, Map<V, Integer> map) {
		BinaryMinHeap<Edge<V, Integer>> heap = new BinaryMinHeap<Edge<V, Integer>>();
		int w = Integer.MAX_VALUE;
		
		Edge<V, Integer> edge = new Edge('A', 0, map);
		map.put(edge.getDestinationVertexValue(), 0);
		heap.insertNode(edge);
		
		edge = new Edge('B', w, map);
		map.put(edge.getDestinationVertexValue(), w);
		heap.insertNode(edge);
		
		edge = new Edge('C', w, map);
		map.put(edge.getDestinationVertexValue(), w);
		heap.insertNode(edge);
		
		edge = new Edge('D', w, map);
		map.put(edge.getDestinationVertexValue(), w);
		heap.insertNode(edge);
		
		edge = new Edge('E', w, map);
		map.put(edge.getDestinationVertexValue(), w);
		heap.insertNode(edge);
		
		edge = new Edge('F', w, map);
		map.put(edge.getDestinationVertexValue(), w);
		heap.insertNode(edge);
		return heap;
	}
	
	/*private <V, W extends Comparable<W>> Map<V,Integer> shortestPathForTopologicalOrder(GenericAdjList<V, W> graph, List<V> list, V fromSource) {
		Map<V, Integer> dist = new HashMap<V, Integer>(); //no need of visited boolean as it takes care of it.
		dist.put(fromSource, 0);
		for (V v : list) {
			LinkedList<Edge<V, W>> neighbours = graph.adjMap.get(v);
			if (neighbours != null) {
				for (Edge<V, W> e : neighbours) {
					V temp = e.getDestinationVertexValue();
					if (dist.get(temp) == null || (dist.get(temp).compareTo(dist.get(v) + (int)e.getEdgeWeight())) > 0) {
						dist.put(temp, dist.get(v).intValue() + (int)e.getEdgeWeight());
					}
				}
			}
		}
		return dist;		
	}*/
	
	private <V> Map<V,Integer> shortestPathForTopologicalOrder(GenericAdjList<V, Integer> graph, List<V> list, V fromSource) {
		Map<V, Integer> dist = new HashMap<V, Integer>(); //no need of visited boolean as it takes care of it.
		dist.put(fromSource, 0);
		for (V v : list) {
			LinkedList<Edge<V, Integer>> neighbours = graph.adjMap.get(v);
			if (neighbours != null) {
				for (Edge<V, Integer> e : neighbours) {
					V temp = e.getDestinationVertexValue();
					if (dist.get(temp) == null || (dist.get(temp).compareTo(dist.get(v) + e.getEdgeWeight())) > 0) {
						dist.put(temp, dist.get(v) + e.getEdgeWeight());
					}
				}
			}
		}
		return dist;		
	}

	public <V, W extends Comparable<W>> Map<V,Integer> shortestPathUnweighted(GenericAdjList<V, W> graph, V fromSource) {
		Map<V, Integer> dist = new HashMap<V, Integer>(); //no need of visited boolean as it takes care of it.
		dist.put(fromSource, 0);
		Queue<V> q = new LinkedList<V>();
		q.add(fromSource);
		while (!q.isEmpty()) {
			V temp = q.poll();
			LinkedList<Edge<V,W>> neighbours = graph.adjMap.get(temp);
			if (neighbours == null) {
				continue;
			}
			for (Edge<V, W> e : neighbours) {
				V dest = e.getDestinationVertexValue();
				if (dist.get(dest) == null) {
					dist.put(dest, dist.get(temp) + 1);
					q.add(dest);
				}
			}
		}		
		return dist;
	}
	
	public <V, W extends Comparable<W>> List<V> topologicalSort(GenericAdjList<V, W> graph, V v) {
		LinkedList<V> list = new LinkedList<V>();
		Set<V> visited = new HashSet<V>();
		if (v == null) {
			//Run For all
			for (V e : graph.adjMap.keySet()) {
				topologicalSortUtil(graph, e, list, visited);
			}
		} else {
			topologicalSortUtil(graph, v, list, visited);// run for specific node. and will cover all nodes, 
														 // only if all nodes are reachable from source.
		}
		
		return list;
	}
	
	/**
	 * Uses {@link MainClass#dfsStack} DFS
	 * 
	 * @param graph
	 * @param v
	 * @param s
	 * @param visited
	 */
	private <V, W extends Comparable<W>> void topologicalSortUtil(GenericAdjList<V, W> graph, V v, LinkedList<V> s, Set<V> visited) {
		if (visited.contains(v))
			return;
		
		visited.add(v);
		LinkedList<Edge<V, W>> list = graph.adjMap.get(v);
		if (list != null) {
			for (Edge<V, W> e : list) {
				topologicalSortUtil(graph, e.getDestinationVertexValue(), s, visited);
			}
		}
		//when all adjacent nodes are done
		//s.push(v); // in case we use stack;
		s.addFirst(v);
	}

}
