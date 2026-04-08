class Solution {
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
        int i = 0, length = 0, j = 0;

        while(i < str.length()){
            while(str.charAt(j) != '#'){
                j++;
            }
            length = Integer.parseInt(str.substring(i, j));
            String temp = str.substring(j+1, j+1+length);
            res.add(temp);
            i = j+1+length;
            j = j+1+length;
        }

        return res;
    }
}
