class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          HashMap<String, List<String>> hashMap = new HashMap<>();
        
        List<String> anagramGroup;
        for (String curStr : strs) {
            String sortedStr = sortLetters(curStr);
            if (hashMap.containsKey(sortedStr)) {
                anagramGroup = hashMap.get(sortedStr);
                anagramGroup.add(curStr);
            } else {
                anagramGroup = new ArrayList<>();
                anagramGroup.add(curStr);
                hashMap.put(sortedStr, anagramGroup);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

   
    private String sortLetters(String word) {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }


    
}