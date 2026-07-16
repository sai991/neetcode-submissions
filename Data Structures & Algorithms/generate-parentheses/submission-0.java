class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        backtrack(res,1,0,n,new StringBuffer("("));
        return res;
    }

    public void backtrack(List<String> sub, int open, int close,int n,StringBuffer sb){
        if(open==close && close==n){
            sub.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            backtrack(sub,open+1,close,n,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
             sb.append(")");
            backtrack(sub,open,close+1,n,sb);
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
