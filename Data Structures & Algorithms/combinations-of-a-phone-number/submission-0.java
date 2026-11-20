class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<>();
        HashMap<Character, Character[]> phone = new HashMap<>();
        phone.put('2', new Character[]{'a','b','c'});
        phone.put('3', new Character[]{'d','e','f'});
        phone.put('4', new Character[]{'g','h','i'});
        phone.put('5', new Character[]{'j','k','l'});
        phone.put('6', new Character[]{'m','n','o'});
        phone.put('7', new Character[]{'p','q','r','s'});
        phone.put('8', new Character[]{'t','u','v'});
        phone.put('9', new Character[]{'w','x','y','z'});

        List<String> result = new ArrayList<>();
        backtrack(digits, phone, result, new StringBuilder(), 0);
        return result;
    }

    public void backtrack(String digits, HashMap<Character, Character[]> map, List<String> result, StringBuilder sb, int idx) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for(Character c: map.get(digits.charAt(idx))) {
            sb.append(c);
            backtrack(digits, map, result, sb, idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
