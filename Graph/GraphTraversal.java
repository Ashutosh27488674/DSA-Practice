package Graph;

import java.util.*;
class Node
{
    int prev,value;
    Node(int prev,int value)
    {
        this.prev=prev;
        this.value=value;
    }
}
public class GraphTraversal {

    //Bipartite Graph..


    public static void isBypertite(int node,int vis[],ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        vis[node]=0;
        while(!q.isEmpty())
        {
            int val=q.poll();
            for(Integer it:adj.get(val))
            {
                if(vis[it]==-1)
                {
                    vis[it]=(vis[val]==0)?1:0;
                    q.add(it);
                }
                else
                {
                    if(vis[it]==vis[val])
                    {
                        System.out.println("IS not aBipertite Graph");
                        return ;
                    }
                }
            }

        }
        System.out.println("Is a  Bipertite Graph.");
    }
    public static void isBipertite(ArrayList<ArrayList<Integer>> adj)
    {
        int vis[]=new int[adj.size()];
        for(int i=0;i<adj.size();i++) vis[i]=-1;
        for(int i=0;i<adj.size();i++)
        {
            if(vis[i]==-1)
            {
                isBypertite(i,vis,adj);
            }
        }
    }



    //Cycle Detection using DFS.
    public static boolean isCyclic(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,int prev)
    {
        for(Integer it:adj.get(node))
        {
            if(!vis[it])
            {
                vis[it]=true;
                return isCyclic(it,vis,adj,node);
            }
            else
            {
                if(it!=prev)
                    return true;
            }
        }
        return false;
    }
    public static void isCyclicDfS(ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[]=new boolean[adj.size()];
        for(int i=0;i<adj.size();i++)
        {
            if(!vis[i])
            {
                if(isCyclic(i,vis,adj,-1)) {
                    System.out.println("Graph is Cyclic ");
                    return;
                }
            }
        }
        System.out.println("Graph is not a Cyclic Graph");

    }


    //Cycle Detection using BFS.
    public static boolean isCyclic(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj)
    {
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(-1,node));
        while(!q.isEmpty())
        {
            Node temp=q.poll();
            int val=temp.value;
            int pre=temp.prev;
            vis[val]=true;
            for(Integer it:adj.get(val))
            {
            if(!vis[it])
            {
                q.add(new Node(val,it));
            }
            else
            {
                if(it!=pre)
                    return true;
            }
            }
        }
        return false;
    }
    public static void isCyclic1(ArrayList<ArrayList<Integer>> adj)
    {
       boolean vis[]=new boolean[adj.size()];
       for(int i=0;i<adj.size();i++)
       {
           if(!vis[i]) {
               if (isCyclic(i, vis, adj)) {
                   System.out.println("Graph is Cyclic.");
                   return;
               }
           }
       }
        System.out.println("Not a Cyclic Graph");

    }



//Dfs Traversal of a Graph....

    public static void dfSTraversal(int node,boolean []vis,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans)
    {
        if(!vis[node]) {
            ans.add(node + 1);
            vis[node] = true;
        }
        for(Integer it:adj.get(node))
        {
            if(!vis[it])
                dfSTraversal(it,vis,adj,ans);
        }
    }
    public static void dfS(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans)
    {
        for(int i=0;i<adj.size();i++)
        {
            if(!vis[i])
            {
                dfSTraversal(i,vis,adj,ans);
            }
        }
    }




    //BFS Traversal of a Graph...
    public static void bfS(int node,ArrayList<ArrayList<Integer>> adj,boolean vis[],ArrayList<Integer> ans)
    {
//        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty())
        {
            int temp=q.poll();
            if(!vis[temp]) {
                ans.add(temp + 1);
                vis[temp] = true;
            }
            for(Integer it:adj.get(temp))
            {
                if(!vis[it])
                    q.add(it);
            }
        }
//        return ans;
    }



    //Main Function...............................................



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=sc.nextInt(),m=sc.nextInt();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i=0;i<m;i++)
        {
            int ver=sc.nextInt();
            int con=sc.nextInt();
            adj.get(ver-1).add(con-1);
            adj.get(con-1).add(ver-1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                bfS(i,adj,vis,ans);
            }
        }
        System.out.println("BFS Traversal of a Graph");
        for(Integer it:ans)
            System.out.print(it+" ");
        System.out.println();
        System.out.println("________________________________________________");
        boolean vis1[]=new boolean[n];
        ArrayList<Integer> ans2=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(!vis1[i])
                dfS(i,vis1,adj,ans2);
        }
        System.out.println("DFS Traversal of a graph");
        for(Integer it:ans2)
            System.out.print(it+" ");
        System.out.println();
        isCyclic1(adj);
        isCyclicDfS(adj);
        isBipertite(adj);
    }
}
