class Solution {
    public List<String> generateParenthesis(int n) {
        int open = 0;
        int close = 0;
        List<String> res = new ArrayList<>();

        backtracking(res, n, "", open, close);
        return res;
    }

    public void backtracking(List<String> res, int n, String brackets, int open, int close){
        if(brackets.length() == n*2){
            res.add(brackets);
            return;
        }

        if(open < n){
            backtracking(res, n, brackets+"(", open+1, close);
        }

        if(close < open){
            backtracking(res, n, brackets+")", open, close+1);
        }
    }
}
