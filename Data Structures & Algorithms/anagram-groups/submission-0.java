class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();

        for(int i=0; i<strs.length; i++){
            char arr[] = new char[26];
            
            for(int j=0; j<strs[i].length(); j++){
                arr[strs[i].charAt(j) - 'a']++;
            }

            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(strs[i]);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(strs[i]);
                map.put(ns, al);
            }
        }

        res.addAll(map.values());
        return res;
    }
}