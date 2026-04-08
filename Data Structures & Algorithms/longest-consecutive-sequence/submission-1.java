class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int con = Integer.MIN_VALUE;
        int counter = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            numSet.add(nums[i]);
        }
        
        Object[] numArr = numSet.toArray();
        // int temp = numSet.get(0);

        for(int i = 0; i < numArr.length; i++){
            con = Math.max(con, countElement(numSet, (Integer)numArr[i], 0)+1);
        }
        return con;
    }

    public int countElement(Set<Integer> numSet, Integer temp, int counter){
        if(numSet.contains(temp+1)){
            counter++;
        }else{
            return counter;
        }
        counter = countElement(numSet, temp+1, counter);
        // System.out.println(temp + " - " + counter);
        return counter;
    }
}
