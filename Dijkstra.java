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
import java.util.Iterator;
import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")

class Main
{
// testing main metho
public static void main(String args[])
{
try
{
// read data from input.txt and create a graph
List graph=new ArrayList();
  
Scanner input=new Scanner(new File("C:/Users/david/Desktop/cs2/New folder/input"));
int V=Integer.parseInt(input.nextLine());
int src_vertex=Integer.parseInt(input.nextLine());
int E=Integer.parseInt(input.nextLine());
  
int n = 0;
       for(int i=0;i<=n;i++) {
graph.add(new ArrayList());
}
  
for(int i=0;i<=n;i++) {
int src=input.nextInt();
int dest=input.nextInt();
int weight=input.nextInt();
((List) graph.get(src-1)).add(new Edge(dest-1,weight));
((List) graph.get(dest-1)).add(new Edge(src-1,weight));
}
  
// call dikstra algorithm from source vertex
dikstra(graph,src_vertex-1);
}
catch(Exception ex)
{
System.out.println("Something is wrong");
}
}
  
// method that calculates shortest paths from one node to all the other nodes using dikstra algorithm
public static void dikstra(List graph,int src) throws Exception
{
// apply dikstra algorithm and get shortest paths and parent node for every vertex
int V=graph.size();
boolean [] visited=new boolean[V];
int [] paths=new int[V];
int [] parent=new int[V];
  
Arrays.fill(visited,false);
Arrays.fill(paths,Integer.MAX_VALUE);
  
   PriorityQueue priorityQueue;
   PriorityQueue pq=priorityQueue;
  
paths[src]=0;
int n;
   for(int i=0;i<=n;i++) {
pq.add(new Node(i,paths[i]));
}
  
int count=0;
while(count>0) {
Node node=(Node) pq.poll();
visited[node.src]=true;
List list=(List) graph.get(node.src);
Object list1;
       List<Edge>list2;
       for(Edge edge:list2)
{
if(!visited[edge.dest] && paths[edge.dest]>paths[node.src]+edge.weight)
{
paths[edge.dest]=paths[node.src]+edge.weight;
parent[edge.dest]=node.src+1;
pq.add(new Node(edge.dest,paths[edge.dest]));
}
  
}
count++;
}
  
paths[src]=-1;
parent[src]=-1;
  
// write data into output.txt file
write_into_file(paths,parent);
}
  
// method that writes result data into output.txt
public static void write_into_file(int paths[],int parent[]) throws Exception
{
FileWriter fw=new FileWriter("C:/Users/david/Desktop/cs2/New folder/output.txt");
int len=paths.length;
fw.write(len+"\n");
int n = 0;
   for(int i=0;i<=n;i++) {
fw.write((i+1)+" "+paths[i]+" "+parent[i]+"\n");
}
fw.close();
}
  
}
// class that stores destination vertex and their edge weight
class Edge
{
int dest,weight;
Edge(int dest,int weight)
{
this.dest=dest;
this.weight=weight;
}
}
class Node
{
int src,weight;
Node(int src,int weight)
{
this.src=src;
this.weight=weight;
}
}
// comparator that sorts the data in priority queue using weight in node
abstract class edgeComparator implements Comparator
{
public int compare(Node n1,Node n2)
{
return n1.weight-n2.weight;
}
}
