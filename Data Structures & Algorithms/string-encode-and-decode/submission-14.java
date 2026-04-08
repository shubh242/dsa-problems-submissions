class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs) {
            sb.append(s.length()+"#"+s+"#");
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0, j = 0;
        List<String> strs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int wordSize = 0;
        while(j < str.length()) {
            while(str.charAt(i) != '#'){
                sb.append(str.charAt(i));
                i++;
            }
            wordSize = Integer.parseInt(sb.toString());
            // System.out.println(sb.toString());
            sb.setLength(0);
            i = i+1;
            j = i+wordSize;
            strs.add(str.substring(i,j));
            i = j+1;
            j = i;
            // System.out.println(strs.toString());
        }
        return strs;
    }
}
