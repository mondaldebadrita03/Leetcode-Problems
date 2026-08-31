class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int curcpi = -1;
        int prevcpi = -1;
        int curind = 1;
        ListNode cur = head.next;
        ListNode prev = head;
        int res[] = new int[2];
        res[0] = Integer.MAX_VALUE;

        while(cur.next != null){
            ListNode nextNode = cur.next;
            if((cur.val < nextNode.val && cur.val < prev.val) || cur.val > nextNode.val && cur.val > prev.val ){
                if(prevcpi == -1){
                    curcpi = curind;
                    prevcpi = curind;
                }
                else{
                    res[0] = Math.min(res[0], curind - prevcpi);
                    prevcpi = curind;
                }

            }
            prev = prev.next;
            cur = cur.next;
            curind++;
        }
        
        if(curcpi != -1 && res[0] != Integer.MAX_VALUE){
            res[1] = prevcpi - curcpi;
        }
        else{
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
}
