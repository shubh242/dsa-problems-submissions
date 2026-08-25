class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append("#");
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        int j = 0;
        List<String> result = new ArrayList<>();

        while(j < str.length()) {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                i++;
            }

            i++;
            j = i+Integer.parseInt(sb.toString());
            result.add(str.substring(i, j));
            i = j;
            j++;

        }
        return result;
    }
}
