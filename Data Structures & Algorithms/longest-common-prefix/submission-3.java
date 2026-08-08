class Solution {
    public String longestCommonPrefix(String[] strs) {
        String smallest = "a";
        int smallestLength = Integer.MAX_VALUE;
        int smallestIdx = 0;

        for(int i = 0; i < strs.length; i++) {
            if(smallestLength > strs[i].length()) {
                smallest = strs[i];
                smallestLength = strs[i].length();
                smallestIdx = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < smallest.length(); i++) {
            sb.append(smallest.charAt(i));
            for(int j = 0; j < strs.length; j++) {
                String prefix = sb.toString();
                if(smallestIdx == j)
                    continue;

                if(!strs[j].startsWith(prefix)) {
                    sb.deleteCharAt(sb.length()-1);
                    return sb.toString();
                }
            }
        }

        return sb.toString();
    }
}