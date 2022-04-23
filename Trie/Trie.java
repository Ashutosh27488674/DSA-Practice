package Trie;
class Node
{
    Node links[]=new Node[26];
    boolean flag;
    Node()
    {

    }
    public boolean contains(char ch)
    {
        return this.links[ch-'a']!=null;
    }
    public void put(char ch,Node node)
    {
        this.links[ch-'a']=node;
    }
    public Node get(char ch) {
        return this.links[ch - 'a'];
    }
    public void setEnd()
    {
        this.flag=true;
    }

}
public class Trie {
    public Node root;
    Trie()
    {
        root=new Node();
    }
    public void insert(String str)
    {
        Node node=root;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(!node.contains(ch))
            {
                node.put(ch,new Node());
            }
            node=node.get(ch);
        }
        node.setEnd();

    }
    public boolean isPresent(String str)
    {
        Node node=root;
        for(int i=0;i<str.length(); i++)
        {
            char ch=str.charAt(i);
            if(!node.contains(ch))
                return false;
            node=node.get(ch);
        }
        return true;
    }
    public  boolean startsWith(String str)
    {
        Node node=root;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(!node.contains(ch))
                return false;
           node= node.get(ch);

        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj=new Trie();
        String str="ashutosh";
        obj.insert(str);
        System.out.println(obj.isPresent(str));
        System.out.println(obj.startsWith("ash"));

    }
}
