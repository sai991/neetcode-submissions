class Solution {

    HashMap<Character, String> hp = new HashMap<>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
         if (digits == null || digits.length() == 0) {
            return new ArrayList();
        }

        List<String> res = new ArrayList();
        backtrack(res,0,digits,new StringBuilder());
        return res;
        
    }

    public void backtrack(List<String> res,int index, String digits, StringBuilder sb){

        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
String letters = hp.get(digits.charAt(index));
for (char letter : letters.toCharArray()) {
            // Choose
            sb.append(letter);
            
            // Explore next digit
            backtrack(res, index + 1,digits, sb);
            
            // Unchoose (backtrack)
            sb.deleteCharAt(sb.length() - 1);
        }


    }


}
