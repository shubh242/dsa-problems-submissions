class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // [1,2,4,5]
        // [1,2,2,3,3]
        // [7,2,1,5,5,6,4] limit = 10
        // [1,3,3,5,5,6,7]    limit = 10
        //    

        int i = 0, j = people.length-1;
        int boats = 0;
        Arrays.sort(people); 

        while(i < j) { 
            if((people[i] + people[j]) > limit) { 
                j--;
            } else  { 
                i++; j--; 
            }
            boats++; 
        }

        if(i == j) boats++; 

        return boats;
    }
}