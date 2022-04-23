package SegmentTree;
    class Node
    {
        Node links[];
        int pc;//Prefix count
        int ew;        //Words ending with
        Node() {
            links = new Node[26];
            pc = 0;
            ew = 0;
        }
    public boolean containsKey(char ch,Node node) {
        return (node.links[ch - 'a'] != null);
    }

}
public class TrieforMaximumWordswithPrefix {
    public static void BuildTrie(String str,Node root)
    {
        Node node=root;
       for(int i=0;i<str.length();i++)
       {
           char ch=str.charAt(i);
           if(node.containsKey(ch,node))
           {
               node.links[ch-'a'].pc+=1;
           }
           else
           {
               node.links[ch-'a']=new Node();
               node.links[ch-'a'].pc=1;
           }
           node=node.links[ch-'a'];
       }
       node.pc+=1;
       node.ew+=1;

    }
    public static void NumberofElementwithPrefix(String str,Node root)
    {
        Node node=root;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(!node.containsKey(ch,node))
            {
                System.out.println("There is no any person with prefix as "+ str);
                break;
            }
            node=node.links[ch-'a'];
        }
        System.out.println("There are "+node.pc+" person with prefix in their name "+str);
    }
    public static void delete(String str,Node root)
    {
        Node node=root;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(node.containsKey(ch,node))
            {
                node.links[ch-'a'].pc-=1;
                node=node.links[ch-'a'];
            }
            else
            {
                System.out.println("There does not exist any name "+str+".");
            }
        }
        node.ew-=1;
    }
    public static boolean isPresent(String str,Node root)
    {
      Node node=root;
      for(int i=0;i<str.length();i++)
      {
          char ch=str.charAt(i);
          if(!node.containsKey(ch,node))
          {
              return false;
          }
          node=node.links[ch-'a'];
      }
      return (node.ew!=0);
    }


    public static void main(String[] args) {
        String arr[]={"ashutosh","ashish","ashok","aman","gulshan","rabindra","abhishek"};
        Node root=new Node();
        for(int i=0;i<arr.length;i++)
        {
            BuildTrie(arr[i],root);
        }
        System.out.println(root.links[0].pc);
        NumberofElementwithPrefix("ash",root);
        NumberofElementwithPrefix("a",root);
        delete("ashutosh",root);
        NumberofElementwithPrefix("ash",root);
        System.out.println(isPresent("abhishek",root));

    }



}
