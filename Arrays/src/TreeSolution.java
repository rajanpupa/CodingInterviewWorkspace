///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode(int x) { val = x; }
// * }
// */
//public class TreeSolution {
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> ans = new ArrayList<>();
//        
//        Queue<TreeNode> q = new LinkedList<>();
//        
//        q.add(root);
//        q.add(null);// indicates end of that level
//        
//        List<Integer> levelList = new ArrayList<>();
//        while(!q.isEmpty()){
//            TreeNode next = q.remove();
//            if(next == null){
//                
//                System.out.println("if  null : size = " + levelList.size() );
//                if(levelList.isEmpty()) break;
//                // this level ended
//                long sum = 0;
//                for( int item : levelList ){
//                    System.out.print( item + "  +  ");
//                    sum += item;
//                } 
//                
//                System.out.println("\nsum = " + sum);
//                
//                ans.add( (double)(sum) / levelList.size() );
//                
//                q.add(null);
//                levelList = new ArrayList<>();
//            }else{
//                System.out.println("else " + next.val);
//                levelList.add(next.val);
//                if(next.left != null )  q.add( next.left );
//                if(next.right != null ) q.add( next.right );
//            }
//            
//        }
//        
//        return ans;
//    }
//}