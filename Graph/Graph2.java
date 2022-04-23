package Graph;
/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

        Example 1:
        0          3
        |          |
        1 --- 2    4
        Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

        Example 2:
        0           4
        |           |
        1 --- 2 --- 3
        Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

        Note:
        You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.*/
import java.util.*;

public class Graph2 {
    public static void noOfComponents(int node,ArrayList<ArrayList<Integer>> adj,int vis[])
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            int temp=q.poll();
            for(Integer it:adj.get(temp))
            {
                if(vis[it]==-1)
                {
                    q.add(it);
                    vis[it]=1;
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
//        adj.get(0).add(1);
//        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        int vis[]=new int[5];
        for(int i=0;i<5;i++)
            vis[i]=-1;
        int c=0;
        for(int i=0;i<5;i++)
        {
            if(vis[i]==-1)
            {
                c++;
                vis[i]=1;
                noOfComponents(i,adj,vis);
            }

        }
        System.out.println(c);


    }
}
