class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();

        for(String s :strs){
            char[] m = s.toCharArray();
            Arrays.sort(m);
            String b = new String(m);
            if(hm.containsKey(b)){
                hm.get(b).add(s);

            }else{
                List<String> lm = new ArrayList<>();
                lm.add(s);
                hm.put(b,lm);
            }

        }
        List<List<String>>  res = new ArrayList<>();
                for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
        
             List<String> value = entry.getValue();
             res.add(value);
            
        }

       return res; 
    }
}