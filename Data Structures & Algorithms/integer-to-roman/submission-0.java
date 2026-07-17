class Solution {
    public String intToRoman(int num) {
        HashMap<Integer, String> intMap = new HashMap<>();
        intMap.put(1, "I");
        intMap.put(4, "IV");
        intMap.put(5, "V");
        intMap.put(9, "IX");
        intMap.put(10, "X");
        intMap.put(40, "XL");
        intMap.put(50, "L");
        intMap.put(90, "XC");
        intMap.put(100, "C");
        intMap.put(400, "CD");
        intMap.put(500, "D");
        intMap.put(900, "CM");
        intMap.put(1000, "M");
        
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Map.Entry<Integer, String>> pq = new PriorityQueue<>(
            (a,b) -> b.getKey() - a.getKey()
        );
        pq.addAll(intMap.entrySet());

        System.out.println(pq.toString());

        while(num > 0) {
            Map.Entry<Integer, String> curr = pq.poll();
            if(num/curr.getKey() > 0) {
                int count = num/curr.getKey();
                num %= curr.getKey();
                while(count > 0) {
                    sb.append(curr.getValue());
                    count--;
                }
            }
        }

        return sb.toString();
    }
}