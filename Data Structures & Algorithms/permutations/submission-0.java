class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums,res,new ArrayList<>(),new boolean[nums.length]);
        return res;

        
    }
    private void permute(int[] nums,List<List<Integer>> res, List<Integer> curr, boolean[] seen){

        if(curr.size()==nums.length){
           res.add(new ArrayList<>(curr));
            return;

        }
        for(int i=0;i<nums.length;i++){
if(seen[i]) continue;
seen[i] = true;
curr.add(nums[i]);
permute(nums,res,curr,seen);
seen[i]= false;

curr.remove(curr.size()-1);


        }
        
    }
}
