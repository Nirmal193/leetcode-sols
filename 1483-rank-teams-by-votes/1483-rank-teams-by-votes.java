class Solution {
   public String rankTeams(String[] votes) {
    int n = votes[0].length();
    int[][] rank = new int[26][n]; 
    for (String vote : votes) {
        for (int i = 0; i < vote.length(); i++) {
            rank[vote.charAt(i) - 'A'][i]++;
        }
    }

    Character[] teams = new Character[n];
    for (int i = 0; i < n; i++) {
        teams[i] = votes[0].charAt(i);
    }

    Arrays.sort(teams, new Comparator<Character>() {
        public int compare(Character a, Character b) {
            for (int i = 0; i < n; i++) {
                if (rank[a - 'A'][i] != rank[b - 'A'][i]) {
                    return rank[b - 'A'][i] - rank[a - 'A'][i]; 
                }
            }
            return a - b; 
        }
    });

    StringBuilder sb = new StringBuilder();
    for (char c : teams) sb.append(c);
    return sb.toString();
}

}