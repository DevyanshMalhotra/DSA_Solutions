// Left View of Binary Tree java solutions

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans=new ArrayList<>();
      Queue<Node> q=new LinkedList<>();

      if(root==null){
          return ans;
      }else{
          q.add(root);
      }
      
      while(q.size() != 0){
          
          int sze=q.size();
          
          for(int i=1 ; i<=sze ;i++){
              Node p=q.remove();
              
              if(i==1){
                  ans.add(p.data);
              }
              if(p.left!=null){
                  q.add(p.left);
              }
              if(p.right!=null){
                  q.add(p.right);
              }
          }
      }
      return ans;
    }
}
