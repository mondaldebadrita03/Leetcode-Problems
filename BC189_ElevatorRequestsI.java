class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int time = requests[0];
        for(int i = 0; i < requests.length - 1; i++){
            time += Math.abs(requests[i]-requests[i+1]);
        }
        return time;
    }
}
