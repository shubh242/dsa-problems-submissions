/*
[

h, l, a, b, c, d, e, f, g, i, j, k, 
m, n, o, p, q, r, s, t, u, v, w, x, y, z

]



*/


class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            for (int j = 0; j < word1.length(); j++) {
                if(j == word2.length())
                    return false;
                
                if(orderMap.get(word2.charAt(j)) != orderMap.get(word1.charAt(j))) {
                    if(orderMap.get(word2.charAt(j)) < orderMap.get(word1.charAt(j))) 
                        return false;
                    else
                        break;
                }
            }
        }

        return true;
    }
}