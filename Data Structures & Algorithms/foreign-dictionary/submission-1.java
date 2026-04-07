class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for(String word: words){
        for(char c: word.toCharArray()){
            adj.putIfAbsent(c, new HashSet<>());
            indegree.put(c,0);
        }
      }

      for(int i=0;i<words.length-1;i++){
        String w1 = words[i];
        String w2 = words[i+1];

        int minlen = Math.min(w1.length(),w2.length());
        if(w1.length() > w2.length() && 
        w1.substring(0,minlen).equals(w2.substring(0,minlen))) return "";

        for(int j=0; j<minlen;j++){
            if(w1.charAt(j) != w2.charAt(j)){
                if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j))+1);
                }
                break;
            }
        }
      }

        Queue<Character> q = new LinkedList<>();
        for(char c: indegree.keySet()){
            if(indegree.get(c)==0) q.offer(c);
        }
        StringBuilder ans = new StringBuilder();

        while(!q.isEmpty()){
            char word = q.poll();
            ans.append(word);

            for(char nei: adj.get(word)){
                indegree.put(nei, indegree.get(nei)-1);
                if(indegree.get(nei)==0) q.offer(nei);
            }
        }

        return ans.length() == indegree.size() ? ans.toString() : "";
    }
}
