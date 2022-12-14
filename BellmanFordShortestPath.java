
 
import java.util.HashMap;
import java.util.Map;

public class BellmanFordShortestPath {

private static int INFINITY = 10000000;

class NegativeWeightCycleException extends RuntimeException {
}

public Map<Vertex<Integer>, Integer> getShortestPath(Graph<Integer> graph,
Vertex<Integer> sourceVertex) {

Map<Vertex<Integer>, Integer> distance = new HashMap<>();
Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

//set distance of every vertex to be infinity initially
for(Vertex<Integer> v : graph.getAllVertex()) {
distance.put(v, INFINITY);
parent.put(v, null);
}

distance.put(sourceVertex, 0);

int V = graph.getAllVertex().size();

//relax edges repeatedly V - 1 times
for (int i = 0; i < V - 1 ; i++) {
for (Edge<Integer> edge : graph.getAllEdges()) {
Vertex<Integer> u = edge.getVertex1();
Vertex<Integer> v = edge.getVertex2();
//relax the edge
//if we get better distance to v via u then use this distance
//and set u as parent of v.
if (distance.get(u) + edge.getWeight() < distance.get(v)) {
distance.put(v, distance.get(u) + edge.getWeight());
parent.put(v, u);
}
}
}

//relax all edges again. If we still get lesser distance it means
//there is negative weight cycle in the graph. Throw exception in that
//case
for (Edge<Integer> edge : graph.getAllEdges()) {
Vertex<Integer> u = edge.getVertex1();
Vertex<Integer> v = edge.getVertex2();
if (distance.get(u) + edge.getWeight() < distance.get(v)) {
throw new NegativeWeightCycleException();
}
}
return distance;
}

public static void main(String args[]){

Graph<Integer> graph = new Graph<>(false);
graph.addEdge(0, 3, 8);
graph.addEdge(0, 1, 4);
graph.addEdge(0, 2, 5);
graph.addEdge(1, 2, -3);
graph.addEdge(2, 4, 4);
graph.addEdge(3, 4, 2);
graph.addEdge(4, 3, 1);

BellmanFordShortestPath shortestPath = new BellmanFordShortestPath();
Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
Map<Vertex<Integer>,Integer> distance = shortestPath.getShortestPath(graph, startVertex);
System.out.println(distance);
}

}
 

 

 