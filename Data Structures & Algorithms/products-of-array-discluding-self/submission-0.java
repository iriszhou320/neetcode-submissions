class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];

        pre[0] = 1;
        post[nums.length-1] = 1;

        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i-1] * nums[i-1];
        }

        for (int i = nums.length -2; i >= 0; i--) {
            post[i] = post[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            System.out.println(pre[i]);
            System.out.println(post[i]);
            res[i] = pre[i] * post[i];
        }

        return res;
    }
}  
