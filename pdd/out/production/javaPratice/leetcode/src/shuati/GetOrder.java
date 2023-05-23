package shuati;

import java.util.*;

public class GetOrder {
//    public int[] getOrder(int[][] tasks){
//        int n = tasks.length;
//        int[][] nTasks = new int[n][3];
//        //tasks数组添加下标属性
//        for (int i = 0; i < n; i++) {
//            nTasks[i][0] = tasks[i][0];
//            nTasks[i][1] = tasks[i][1];
//            nTasks[i][2] = i;
//        }
//        //排序数组，按照入队时间排序
//        Arrays.sort(nTasks, Comparator.comparingInt(a -> a[0]));
//        //定义优先队列，放置需要处理的任务,排列顺序为：处理时间短的任务放前面，如果处理时间相同，序号小的放前面
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->{
//            if(a[1] != b[1]) return a[1] - b[1];
//            else return a[2] - b[2];
//        });
//        int[] res =  new int[n];
//        int idx = 0;
//        int time = 1;
//        int j = 0;
//        while(idx < n){
//            //入队
//            while(j < n && nTasks[j][0] <= time) pq.offer(nTasks[j++]);
//            if(pq.isEmpty()){
//                time = nTasks[j][0];
//            }else{
//                int[] cur = pq.poll();
//                res[idx++] = cur[2];
//                time += cur[1];
//            }
//        }
//        return res;
//    }
    class Task implements Comparable<Task>{
        public int id;
        public int enqueueTime;
        public int processingTime;

    public Task(int id, int enqueueTime, int processingTime) {
        this.id = id;
        this.enqueueTime = enqueueTime;
        this.processingTime = processingTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", enqueueTime=" + enqueueTime +
                ", processingTime=" + processingTime +
                '}';
    }

    @Override
        public int compareTo(Task task) {
            if(this.processingTime == task.processingTime)
                return this.id - task.id;
            else
                return this.processingTime - task.processingTime;
        }
    }
    
    public int[] getOrder(int[][] tasks){
        List<Task> taskList = new ArrayList<>();
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(taskList, Comparator.comparingInt(t -> t.enqueueTime));
        PriorityQueue<Task> pq = new PriorityQueue<Task>();
        int i = 0, pointer = 0;
        int CPU = taskList.get(0).enqueueTime;
        int[] ans = new int[n];
        while (i < n){
            while (i < n && taskList.get(i).enqueueTime <= CPU){
                pq.offer(taskList.get(i));
                i++;
            }

            if (!pq.isEmpty()){
                Task task = pq.poll();
                ans[pointer++] = task.id;
                CPU += task.processingTime;
            }else{
                CPU = taskList.get(i).enqueueTime;
            }
        }

        while (!pq.isEmpty()){
            Task task = pq.poll();
            ans[pointer++] = task.id;
        }

        return ans;
    }

    public static void main(String[] args) {
        GetOrder go = new GetOrder();
        int[][] tasks = new int[][]{{7,10},{7, 12},{7, 5},{4, 3},{7, 4}, {3, 5}};
        go.getOrder(tasks);
    }
}
