

public class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.isEmpty()) return result;

        int i = 0;
        while (i < str.length()) {
            int j = i;
            // Find the '#' to get the length prefix
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            j++; // Move past '#'
            String word = str.substring(j, j + len);
            result.add(word);
            i = j + len; // Move to next length prefix
        }
        return result;
    }

}