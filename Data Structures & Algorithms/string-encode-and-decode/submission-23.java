class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s: strs) {
            sb.append(String.valueOf(s.length()));
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int j = 0;
        // 5#Hello5#World
        for(int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(j) != '#') {
                sb.append(str.charAt(j));
                j++;
            }
            int len = Integer.parseInt(sb.toString());
            i = j+1;
            j += len+1;
            result.add(str.substring(i, j));
            i = j;
        }
        return result;
    }
}
