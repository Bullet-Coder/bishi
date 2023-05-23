package Lei;

import java.util.*;

public class MainFunc {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = s.length();
        for(int j = 0; j < len; j++){
            int i = dic.getOrDefault(s.charAt(j), -1); //获取索引
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res,tmp);
        }
        return res;
    }
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for(int i = 2; i <= n; i++){
            double[] tmp = new double[5 * i + 1];
            for(int j = 0; j < dp.length; j++){
                for(int k = 0; k < 6; k++){
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String sortedWord = sort(str);
            if(map.containsKey(sortedWord)){
                map.get(sortedWord).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedWord, list);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }


    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i - 1] > 0 && nums[i - 1] > 0?
                    nums[i] + nums[i - 1] : nums[i];
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int x = m - 1, y = n - 1;
        for(int i = length; i >= 0; i--){
            if(y < 0 || (x >= 0 && nums1[x] >= nums2[y])){
                nums1[i] = nums1[x--];
            }else{
                nums1[i] = nums2[y--];
            }
        }
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for(int i = 1; i <= n; i++){
            if(s.charAt(i - 1) != '0'){
                f[i] += f[i - 1];
            }
            if(i > 1 && s.charAt(i - 2) != '0' &&
                    ((s.charAt(i - 2) * 10 + s.charAt(i - 1) - '0') <= 26)) f[i] += f[i - 2];
        }
        return f[n];
    }

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if( dfs(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int k){
        if(k == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false;
        if(word.charAt(k) != board[i][j]) return false;
        char t = board[i][j];
        board[i][j] = '0';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i , j - 1, k + 1);
        board[i][j] = t;
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++){
            if(nums[k] > 0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                }else if(sum > 0){
                    while(i < j && nums[j] == nums[--j]);
                }else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) adjacency.add(new ArrayList<>());
        for(int[] cp : prerequisites){
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) queue.add(i);
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre))
                if(--indegrees[cur] == 0) queue.add(cur);
        }
        return numCourses == 0;
    }

    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0, pre2 = slow;
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int n1sat = 0, n2sat = 0;
        int x = 0;
        for(int i = 0; i <= len / 2; i++){
            left = right;
            if(n1sat < m && n2sat >= n || nums1[n1sat] < nums2[n2sat]){
                right = nums1[n1sat++];
            }else right = nums2[n2sat++];
        }
        if((len & 1) == 0) return (left + right) / 2.0;
        else return right;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int x = nums[i] - 1;
            nums[x] += n;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] <= n) res.add(i + 1);
        }
        return res;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j <= matrix[0].length){
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] > target){
                i--;
            }else j++;
        }
        return false;
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int left = 0, right = res - 1, m = 0;
            while (left <= right) {
                m = (left + right) / 2;
                if (nums[i] <= dp[m]) right = m - 1;
                else left = m + 1;
            }
            dp[left] = nums[i];
            if (res == right + 1) res++;
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        dp[0][0] = 0; //不持有股票，也没有卖股票
        dp[0][1] = 0; //不持有股票，因为卖出去了
        dp[0][2] = -1 * prices[0]; //持有股票，今天买的
        dp[0][3] = -1 * prices[0]; //持有股票，不是今天买的
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]); //不持有股票的两种情况最大值
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][3]) + prices[i]; //今天卖出股票，
            dp[i][2] = dp[i - 1][0] - prices[i]; //今天买入，但是前一天一定没有卖出
            dp[i][3] = Math.max(dp[i - 1][2], dp[i - 1][3]); //今天没买，继承前一天买的
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[n - 1];
        int right = -1, left = 0;
        //从左向右遍历，找到最后一个小于最大值的数字i，作为右边界
        for(int i = 0; i < n; i++){
            if(nums[i] < max) {
                right = i;
            }else max = nums[i];
        }
        //从右向左遍历，找到最后一个大于最小值的数字i，作为左边界
        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > min){
                left = i;
            }else min = nums[i];
        }
        return right - left + 1;

    }

    public int reverse(int x) {
        long res = 0;
        while(x != 0){
            int temp = x % 10;
            if(res > 214748364 || res == 214748364 && temp > 8) return 0;
            if(res < -214749364 || res == -214748364 && temp < -9) return 0;
            res = res * 10 + temp;
            x /= 10;
        }
        return (int)res;
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : tasks) {
            freq.put(ch,freq.getOrDefault(ch,0) + 1);
        }
        //任务总数
        int m = freq.size();
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for(Map.Entry<Character, Integer> entry : entrySet){
            int val = entry.getValue();
            nextValid.add(1);
            rest.add(val);
        }

        int time = 0;
        for(int i = 0; i < tasks.length; i++){
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                if(rest.get(j) != 0)
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
            }
            time = Math.max(time,minNextValid);
            int best = -1;
            for(int j = 0; j < m; j++){
                if(rest.get(j) != 0 && nextValid.get(j) <= time){
                    if(best == -1 || rest.get(j) > rest.get(best))
                        best = j;
                }
            }
            nextValid.set(best,time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }

    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++){
            if((n & (1 << i)) != 0) res++;
        }
        return res;
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Deque<Integer> m0 = new ArrayDeque<>();
        Deque<Integer> n0 = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                m0.push(i);
                n0.push(j);
            }
        }
        while(!m0.isEmpty() && !n0.isEmpty()){
            for(int i = 0; i < m; i++){
                matrix[i][n0.peek()] = 0;
            }
            for(int i = 0; i < n;i++){
                matrix[m0.peek()][i] = 0;
            }
            m0.pop();
            n0.pop();
        }
    }

    public String countAndSay(int n) {
        if(n == 1) return"1";
        String before = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<before.length(); i++){
            int count = 1;
            while(i < before.length() - 1 && before.charAt(i) == before.charAt(i + 1)){
                ++count;
                ++i;
            }
            sb.append(count);
            sb.append(before.charAt(i));
        }

        return sb.toString();
    }

    public int minDistance(String word1, String word2) {
        int wd1Len = word1.length();
        int wd2Len = word2.length();
        int[][] dp = new int[wd1Len + 1][wd2Len + 1];
        for(int i = 0; i <= wd2Len; i++){
            dp[0][i] = i;
        }
        for(int i = 0; i <= wd1Len; i++){
            dp[i][0] = i;
        }
        for(int i = 1; i <= wd1Len; i++){
            for(int j = 1; j <= wd2Len; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[wd1Len][wd2Len];
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }

    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            System.out.println("a:" + a + "  b:" + b + "  sa:" + sa + "  sb:" + sb + " " + sb.compareTo(sa) +"  " + Arrays.toString(ss));
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }

    public void sortList(List<Integer> list){
        list.add(2);
        list.add(9);
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(0);

        Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        System.out.println("o1:" + o1 + "  o2:" + o2 + list.toString());
                        return o1 - o2;
                    }
                }
        );
        System.out.println(list);
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        int n = s.length();
        char[] str = (" " + s).toCharArray();
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(str[i] == '(') continue;
            else if(str[i] == ')'){
                if(str[i - 1] == '(') dp[i] = dp[i - 2] + 2;
                else if(str[i - 1] == ')') {
                    if(i - dp[i - 1] - 1 >= 0 && str[i - dp[i - 1]] == '(')
                        dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //存储某个节点能够到达的其它节点集合
        List<Integer>[] lists = new ArrayList[numCourses];
        //某节点的入度
        int[] points = new int[numCourses];
        for(int[] p : prerequisites){
            points[p[0]]++;
            if(lists[p[1]] == null) lists[p[1]] = new ArrayList<>();
            lists[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(points[i] == 0) queue.add(i);
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int p = queue.poll();
                res[idx++] = p;
                if(lists[p] == null) continue;
                for(int val : lists[p]){
                    points[val]--;
                    if(points[val] == 0) queue.add(val);
                }
            }
        }
        return idx == numCourses ? res : new int[0];
    }

    //正则表达式匹配
    public boolean isMatch(String s, String p) {
        int sn = s.length(), pn = p.length();
        boolean[][] dp = new boolean[sn + 1][pn + 1];
        dp[0][0] = true;
        for(int j = 1; j <= pn; j++){
            if(p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }
        for(int i =1; i <= sn; i++){
            for(int j = 1; j <= pn; j++){
                if(s.charAt(i- 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                    else if(p.charAt(j - 1) == '*'){
                    //*号前面一个字符j - 2匹配当前i - 1字符， 三种情况
                    if(s.charAt(i - 1) == p.charAt(j - 2) ||
                            p.charAt(j - 2) == '.')
                        //删除，考察s(0, i); p(0, j -3)
                        //抵消，考察s(0, i - 1); P(0, j - 3)
                        //重复，考察s(0, i - 1); p(0, j - 1)
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    else{
                        //*号前面一个字符j - 2 != 当前i - 1字符
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sn][pn];
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> points = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int[] arr : buildings){
            //左端点取负，方便排序
            int l = arr[0], r = arr[1], h = arr[2];
            points.add(new int[]{l, -h});
            points.add(new int[]{r, h});
        }
        //先排序左端点，再排序右端点
        //左端点从大到小排序（也就是左端点真实值的从小到大排序）；
        //右端点从小到大排序
        Collections.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int pre = 0;
        maxHeap.add(pre); //防止右端点取出时大根堆中没有元素而导致的空指针
        //遍历端点
        for(int[] point : points){
            int x = point[0], y = point[1];
            //遇到左端点将高度加入到大根堆中
            if(y < 0){
                y = -y;
                maxHeap.add(y);
            }//遇到右端点移除大根堆堆顶元素
            else maxHeap.remove(y);
            int height = maxHeap.peek(); //获取当前最大高度（为了筛去横坐标相同但高度较低的点）
            if(height != pre){
                List<Integer> ans = new ArrayList<>(Arrays.asList(x, height));
                res.add(ans);
                pre = height;
            }
        }
        return res;
    }

    public boolean isNumber(String s) {
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                numFlag = true;
            else if(s.charAt(i) == '.' && !dotFlag && !eFlag){
                dotFlag = true;
            }else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag){
                eFlag = true;
                numFlag = false;
            }else if((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i) == 'e' || s.charAt(i - 1) == 'E')){

            }else return false;
        }
        return numFlag;
    }
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > nums[lo]){
                if(target > nums[lo] && target < nums[mid]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else {
                if(target < nums[hi] && target > nums[mid]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val -b.val );
        for(ListNode list : lists){
            pq.offer(list);
        }
        while (!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            pq.offer(temp);
        }

        return dummy.next;
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0, count = 0;
        int start = 0;
        for(int i = 0; i < t.length(); i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        while(right < s.length()){
            char ch = s.charAt(right++);
            if(need.containsKey(ch)){
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if(need.get(ch).equals(window.get(ch))) count++;
            }
            while(count == need.size()){
                if(len > right - left){
                    len = right - left;
                    start = left;
                }
                //缩小窗口
                char d = s.charAt(left++);
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d)))
                        count--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
