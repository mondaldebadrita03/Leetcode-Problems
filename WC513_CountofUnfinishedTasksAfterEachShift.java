//Time Limit Exceeded 607 / 608 testcases passed
class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int[][] drelvanito = {tasks, shifts};
        int incompleteTask = tasks[0];
        int task=0;
        int[] ans= new int[shifts.length];
        for(int i=0; i<shifts.length; i++){
            int time=shifts[i];
            // int task = tasks.length - 1;
            while(task<tasks.length && time>0){
                if(time>=incompleteTask){
                    time-=incompleteTask;
                    task++;
                    if(task<tasks.length)
                        incompleteTask=tasks[task];
                }else{
                    incompleteTask-=time;
                    time=0;
                }
            }   
            ans[i]=tasks.length-task;
            if(task==tasks.length){
                task=0;
                incompleteTask=tasks[0];
            }
        }
        return ans;
    }
}

//Correct code
class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int[][] drelvanito = {tasks, shifts};
        int n = tasks.length;
        int[] ans = new int[shifts.length];
        long[] prefix = new long[n];
        prefix[0] = tasks[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + tasks[i];
        }
        long progress = 0;
        long total = prefix[n - 1];
        for (int i = 0; i < shifts.length; i++) {
            progress += shifts[i];
            if (progress >= total) {
                ans[i] = 0;
                progress = 0;
                continue;
            }
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] > progress)
                    right = mid;
                else
                    left = mid + 1;
            }
            ans[i] = n - left;
        }
        return ans;
    }
}
