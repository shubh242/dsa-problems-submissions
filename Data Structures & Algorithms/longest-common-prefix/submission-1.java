class Solution {
    public String longestCommonPrefix(String[] strs) {
        int counter = Integer.MAX_VALUE;
        String smallest = "";

        for(int i = 0; i < strs.length; i++) {
            if(counter > strs[i].length()) {
                counter = strs[i].length();
                smallest = strs[i];
            }
        }

        while(counter >= 0) {
            String prefix = smallest.substring(0, counter);
            boolean allMatch = true;
            for(int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) return prefix;
            counter--;
        }
        return "";
    }
}