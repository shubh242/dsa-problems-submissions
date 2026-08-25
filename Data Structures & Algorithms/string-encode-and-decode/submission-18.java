class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < strs.size(); i++) {
            String toAppend = strs.get(i).length()+"#"+strs.get(i);
            sb.append(toAppend);
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        int j = 0;
        List<String> result = new ArrayList<>();

        while(j < str.length()) {
            String size = "";
            while(str.charAt(i) != '#') {
                size += str.charAt(i);
                i++;
            }

            i++;
            j = i+Integer.parseInt(size);
            // System.out.println(i + " " + j);
            result.add(str.substring(i, j));
            i = j;
            j++;

        }
        return result;
    }
}
