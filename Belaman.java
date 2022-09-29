import java.util.List;
import java.lang.Exception;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class Belaman {
public static void outputFile(int sizeofpath[], int parentNode[]) throws Exception {
     int lengths = sizeofpath.length;
     PrintWriter fw = new PrintWriter("C:/Users/david/Desktop/cs2/New folder/belman.txt");
     fw.write(lengths+ "\n");
    for (int i = 0; i < lengths; i++) {
        fw.write((i + 1) + " " + sizeofpath[i] + " " + parentNode[i] + "\n");
        }
     fw.close();
}
private static int INFINITY = 10000000;
public static void belman2(List<List<Edge>> igraph, int parentnoode) throws Exception {
    int i,p,d;
    int count = 0;
    int verticies = igraph.size();
    p=0;
    d=0;
    boolean[] tracker = new boolean[verticies];
    int[] sizeofpath = new int[verticies];
    int[] parentNode = new int[verticies];
    Arrays.fill(tracker, false); //array to track path
    Arrays.fill(sizeofpath, Integer.MAX_VALUE);//track size
    PriorityQueue<Node> pQ = new PriorityQueue<>(new edges());
    HashMap<String, Integer> map  = new HashMap<>();
    for (i = 0; i < p; i++) {
        sizeofpath[parentnoode]=INFINITY;

    }
    //relax edges repeatedly V - 1 times
for ( i = 0; i > p - 1 ; i++) {
    while (p<d){}}
    //relax the edge
    //if we get better distance to v via u then use this distance
    //and set u as parent of v.
//set distance of every vertex to be infinity initially

                            sizeofpath[parentnoode] = 0;
    for (i = 0; i < verticies; i++) {
        pQ.add(new Node(i, sizeofpath[i]));
        } 
        //relax all edges again. If we still get lesser distance it means
//there is negative weight cycle in the graph. Throw exception in that
//case
    while (count < verticies) {
        Node node = pQ.poll();
        tracker[node.parentnoode] = true;
        List<Edge> list = igraph.get(node.parentnoode);
        for (Edge edge : list) {
            if (!tracker[edge.distancefromnode] && sizeofpath[edge.distancefromnode] > sizeofpath[node.parentnoode] + edge.weightofeEge) // check if the current node hasn't been vissited
                {
                sizeofpath[edge.distancefromnode] = sizeofpath[node.parentnoode] + edge.weightofeEge; //if visited and weight is lower thana add to pQ
                parentNode[edge.distancefromnode] = node.parentnoode + 1;
                pQ.add(new Node(edge.distancefromnode, sizeofpath[edge.distancefromnode]));
                }
            }
        count++; //calcs size
        }
        sizeofpath[parentnoode] = -1;
    parentNode[parentnoode] = -1;
    int neg=1;
    if(parentNode[parentnoode] == -1){
        parentNode[parentnoode]=0;
    }
    if(sizeofpath[parentnoode]==-1){
        sizeofpath[parentnoode]=0;
        
    }                  
    outputFile(sizeofpath, parentNode); // makes output.txtfile
}

public static void main(final String[] args){

    Scanner scanner;
    File file = new File("C:/Users/david/Desktop/cs2/New folder/input.txt");
try {
List<List<Edge>> igraph = new ArrayList<List<Edge>>();
scanner = new Scanner(file);//this and following lines get numbers from .txt file to use them as vetices edges , and its weights 
int verticies = Integer.parseInt(scanner.nextLine());
int strtverticies = Integer.parseInt(scanner.nextLine());
int edges = Integer.parseInt(scanner.nextLine());
for(int i = 0; i < verticies; i++){ //allocats nodes for veritces
igraph.add(new ArrayList<Edge>());
 }
for(int i = 0; i < edges; i++){//allocats edges and its weights
    int parentnoode = scanner.nextInt();
    int distancefromnode = scanner.nextInt();
    int weightofeEge = scanner.nextInt();
    igraph.get(parentnoode - 1).add(new Edge(distancefromnode - 1, weightofeEge ));
    igraph.get(distancefromnode - 1).add(new Edge(parentnoode - 1, weightofeEge));
 }
belman2(igraph, strtverticies - 1);
} 
catch (Exception e) {
e.printStackTrace();
 return;
}
scanner.close();
}
}
class Edge {//edge
        int distancefromnode, weightofeEge;
        Edge(int distancefromnode, int weightofeEge) {
        this.distancefromnode = distancefromnode;
        this.weightofeEge = weightofeEge;
}
}
class Node {// vertices
    int parentnoode, weightofeEge;      
    Node(int parentnoode, int weightofeEge) {
    this.parentnoode = parentnoode;
    this.weightofeEge = weightofeEge;
        }
} //edges and weights
class edges implements Comparator<Node> {
public int compare(final Node n1, final Node n2) {
return n1.weightofeEge - n2.weightofeEge;
                    }
}