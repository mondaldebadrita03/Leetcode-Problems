import java.util.*;
class Solution {
    public long[] countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] trevolimna = nums;
        TreeSet<Integer> peaks = new TreeSet<>();
        for (int i = 1; i < n - 1; i++) {
            if (isPeak(nums, i)) {
                peaks.add(i);
            }
        }
        Fenwick count = new Fenwick(n);
        Fenwick weighted = new Fenwick(n);
        int prev = -1;
        for (int p : peaks) {
            int gap = p - prev;
            count.add(p, gap);
            weighted.add(p, (long) p * gap);
            prev = p;
        }
        List<Long> result = new ArrayList<>();
        for (int[] query : queries) {
            if (query[0] == 1) {
                int l = query[1];
                int r = query[2];
                if (r - l < 2) {
                    result.add(0L);
                    continue;
                }
                Integer first = peaks.higher(l);
                Integer last = peaks.lower(r);
                if (first == null || last == null || first > last) {
                    result.add(0L);
                    continue;
                }
                Integer previous = peaks.lower(first);
                int prevPeak = previous == null ? -1 : previous;
                long sumGap = last - prevPeak;
                long sumWeighted = weighted.sum(last) - weighted.sum(first - 1);
                long answer = (long) r * sumGap - sumWeighted;
                answer += (long) (prevPeak - l) * (r - first);
                result.add(answer);
            } else {
                int index = query[1];
                nums[index] = query[2];
                updatePeak(nums, peaks, count, weighted, index - 1);
                updatePeak(nums, peaks, count, weighted, index);
                updatePeak(nums, peaks, count, weighted, index + 1);
            }
        }
        long[] ans = new long[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    private boolean isPeak(int[] nums, int i) {
        if (i <= 0 || i >= nums.length - 1) {
            return false;
        }
        return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }
    private void updatePeak(int[] nums, TreeSet<Integer> peaks, Fenwick count, Fenwick weighted, int index) {
        if (index <= 0 || index >= nums.length - 1) {
            return;
        }
        boolean shouldBePeak = isPeak(nums, index);
        boolean currentlyPeak = peaks.contains(index);
        if (shouldBePeak == currentlyPeak) {
            return;
        }
        if (shouldBePeak) {
            addPeak(index, peaks, count, weighted);
        } else {
            removePeak(index, peaks, count, weighted);
        }
    }
    private void addPeak(int p, TreeSet<Integer> peaks, Fenwick count, Fenwick weighted) {
        Integer prev = peaks.lower(p);
        Integer next = peaks.higher(p);
        int prevPeak = prev == null ? -1 : prev;
        if (next != null) {
            int oldGap = next - prevPeak;
            count.add(next, -oldGap);
            weighted.add(next, -(long) next * oldGap);
        }
        int newGap = p - prevPeak;
        count.add(p, newGap);
        weighted.add(p, (long) p * newGap);
        if (next != null) {
            int nextGap = next - p;
            count.add(next, nextGap);
            weighted.add(next, (long) next * nextGap);
        }
        peaks.add(p);
    }
    private void removePeak(int p,
        TreeSet<Integer> peaks, Fenwick count, Fenwick weighted) {
        Integer prev = peaks.lower(p);
        Integer next = peaks.higher(p);
        int prevPeak = prev == null ? -1 : prev;
        int gap = p - prevPeak;
        count.add(p, -gap);
        weighted.add(p, -(long) p * gap);
        if (next != null) {
            int oldGap = next - p;
            count.add(next, -oldGap);
            weighted.add(next, -(long) next * oldGap);
            int newGap = next - prevPeak;
            count.add(next, newGap);
            weighted.add(next, (long) next * newGap);
        }
        peaks.remove(p);
    }
    static class Fenwick {
        int n;
        long[] tree;
        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 1];
        }
        void add(int index, long value) {
            index++;
            while (index <= n) {
                tree[index] += value;
                index += index & -index;
            }
        }
        long sum(int index) {
            if (index < 0) {
                return 0;
            }
            index++;
            long result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}
