class TopVotedCandidate {

     int currentWinner;
    int maxVote;
    int voters[] = new int[5001];
    TreeMap<Integer,Integer> timeline;
    public TopVotedCandidate(int[] persons, int[] times) {
        timeline = new TreeMap<>();
        int len = persons.length;
        maxVote = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int cvote = ++voters[persons[i]];
            if(maxVote <= cvote){
                maxVote = cvote;
                currentWinner = persons[i];
            }
            timeline.put(times[i],currentWinner);
        }
    }

    public int q(int t) {
        return timeline.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */