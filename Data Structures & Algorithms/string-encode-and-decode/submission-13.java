class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            int len = s.length();
            sb.append(len + "#" + s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0)
            return new ArrayList<>();
        int k = 0;
        while(str.charAt(k) != '#'){
            k++;
        }
        int initialLen = Integer.parseInt(str.substring(0, k)), i = k+1, j = k+1+initialLen;
        List<String> res = new ArrayList<>();
        while(j <= str.length()){
            res.add(str.substring(i, j));
            if(j >= str.length())
                break;
            initialLen = j;
            while(str.charAt(j+1) != '#'){
                j++;
            }
            initialLen = Integer.parseInt(str.substring(initialLen, j+1));
            i = j+2;
            j += initialLen+2;
            System.out.println(i + " " + j);
        }
        return res;
    }
}
