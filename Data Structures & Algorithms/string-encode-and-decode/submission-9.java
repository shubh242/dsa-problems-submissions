class Solution {
    public int k = 5;
    public String noString = "SPACE_EMPTY_STRING";

    public String encode(List<String> strs) {
        String res = "";
        int length = 0;

        for(int i = 0; i < strs.size(); i++){
            length = strs.get(i).length();
            res += length+"#"+strs.get(i);
        }

        System.out.println(res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < str.length()){
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            System.out.println(str.charAt(i) + " " + str.charAt(j) + " " + length);
            String temp = str.substring(j+1, j+1+length);
            res.add(temp);
            i = j+1+length;
            j = j+1+length;
        }

        return res;
    }
}
