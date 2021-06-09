import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class day_1_leetcode_15 {
    /*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素
    a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

*/
    public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
           List lists= new ArrayList<ArrayList<Integer>>();
           if(nums.length<=2){
               return  lists;
           }
           List list=new ArrayList<Integer>();
            if (nums.length==3){
               if (nums[0]+nums[1]+nums[2]==0){
                   list.add(nums[0]);
                   list.add(nums[1]);
                   list.add(nums[2]);
                   lists.add(new ArrayList(list));
               }

               return lists;
           }
            list.clear();
            int right=nums.length-1;

            int left;
            for(int i=0;i<right;i++) {
                left=i+1;
                right=nums.length-1;
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] == 0) {
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(new ArrayList(list));
                        list.clear();
                        int temp=nums[right];
                        right--;
                        while (right>0&&nums[right]==temp){
                            right--;
                        }
                    } else if (nums[left] + nums[right] + nums[i] < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
                while (i+1<nums.length&&nums[i]==nums[i+1]){
                    i++;
                }
            }
            return lists;
    }
    public static boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        Stack<Integer> stack=new Stack<Integer>();
        Stack<Integer> stack1=new Stack<Integer>();
        int temp=0;
        if(nums.length%k!=0){
            return false;
        }
        for(int i=nums.length-1;i>=0;i--){
            stack.push(nums[i]);
        }
        int point=nums.length/k;
        while (point>0){
            int flag=stack.pop();
            int times=k-1;
            while (times>0){
                if(stack.isEmpty()){
                    return false;
                }
                temp=stack.pop();
                if (temp-flag==1){
                    flag=temp;
                    times--;
                }
                else if (temp-flag!=1){
                    stack1.push(temp);
                }

            }
            while (!stack1.isEmpty()){
                int pin=stack1.pop();
                stack.add(pin);
            }
            point--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[]nums={16,21,26,35};
      boolean b= isPossibleDivide(nums,4);
        System.out.println(b);
    }
}
