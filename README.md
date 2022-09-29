# Quickest-Path-algorithms
Programming Assignment; Dijkstra’s Algorithm
Start
My first thought about how I was going to code this algorithm was what data structure I’m
going to use to create the graph and implement Dijkstra’s algorithm. My first thought was what
data structures would suit a graph implementation, I came up with several ideal; linked list,
arraylist, tree, bst. But I settled for an 2d array. The reason I chose an array is because it suited
most what my graph needed to do. I didn't really need what the other data structures offered.
And also the easiest to implement in my point of view.


Now for Dijstra’s algorithm this was the hard part, what data structure would be more
beneficial here? I thought about using a bst, or a Fibonacci heap heap to keep track of all the
weight of edges, check it and remove ect. It seemed like going this route would be a lot harder
to code after reading dijkstra's wikipedia I thought a priority queue implementation would be the
most beneficial in terms of actual sheer amount of code I have to write and of course runtime.
Given the data structures you chose, explain what worst-case and average running time
(in asymptotic terms) your program should have.
● Explain why.

Priority queue, min() will take O(logV), and the FOR loop will take a total of
O(ElogV) which dominates the min() making it the time complexity of the algorithm. This is for
avg case. The worst case is if V < E, then the runtime would be O(ElogV+VlogV)

● Explain at least one way you could improve it given time, or why you don’t
think there’s a good way to.

Using a Fibonacci heap(another type of priority queue) which would be O(1) to
find min() and O(logV to delete giving you O(E+logV)
Given the data structures you chose, explain what worst-case and average memory
space (in asymptotic terms) your program should require.

● Explain why.

The time complexity for Dijkstra Algorithm using an array is O(V^2) but we aren't
just using an array we are using a priority queue, since we are only storing two values
per node its O(V)+O(V)= O(2V)=O(V)

● Explain at least one way you could improve it given time, or why you don’t
think there’s a good way to.

I don't think there is a better way the reason is because you will always need
those two data pieces per node.
