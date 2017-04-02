import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Random;


class LSR_dij
{
    static final int INF=Integer.MAX_VALUE;
    class AdjListNode
    {
        private int v;
        private int weight;

        AdjListNode(int _v, int _w)
        {
			v = _v;
			weight = _w;
		}

        int getV()
        {
			return v;
		}

        int getWeight()
        {
			return weight;
		}
    }

    class Graph
    {
        private int V;
        private LinkedList<AdjListNode>adj[];
        Graph(int v)
        {
            V=v;
            adj = new LinkedList[V];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList<AdjListNode>();
        }
        void addEdge(int u, int v, int weight)
        {
            AdjListNode node = new AdjListNode(v,weight);
            adj[u].add(node);// Add v to u's list
        }


        void topologicalSortUtil(int v, Boolean visited[], Stack stack)
        {

            visited[v] = true;
            Integer i;


            Iterator<AdjListNode> it = adj[v].iterator();
            while (it.hasNext())
            {
                AdjListNode node =it.next();
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }

            stack.push(new Integer(v));
        }


        void shortestPath(int s)
        {
            Stack stack = new Stack();
            int dist[] = new int[V];


            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;


            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);


            for (int i = 0; i < V; i++)
                dist[i] = INF;
            dist[s] = 0;


            while (stack.empty() == false)
            {

                int u = (int)stack.pop();


                Iterator<AdjListNode> it;
                if (dist[u] != INF)
                {
                    it = adj[u].iterator();
                    while (it.hasNext())
                    {
                        AdjListNode i= it.next();
                        if (dist[i.getV()] > dist[u] + i.getWeight())
                            dist[i.getV()] = dist[u] + i.getWeight();
                    }
                }
            }


            for (int i = 0; i < V; i++)
            {
                if (dist[i] == INF)
                    System.out.print( "INF ");
                else
                    System.out.print( dist[i] + " ");
            }
        }
    }


    Graph newGraph(int number)
    {
        return new Graph(number);
    }

    public static void main(String args[])
    {

		Scanner scan=new Scanner(System.in);
		int a,b,w,i,j;
        LSR_dij t = new LSR_dij();
        Graph g = t.newGraph(50);
		Random rand=new Random();
		for(i=0;i<50;i++)
		{
			for(j=0;j<50;j++){
				w=rand.nextInt(10)+1;
				if(i==j)
					w=0;
				g.addEdge(i,j,w);
		}}


        int s ;
		s=scan.nextInt();
        System.out.println("Following are shortest distances "+
                            "from source " + s );
        g.shortestPath(s);
    }
}





















/* g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 3, 1);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 2);
        g.addEdge(2, 1, 3);
        g.addEdge(3, 4, 4);
        g.addEdge(4, 3, 6);
        */