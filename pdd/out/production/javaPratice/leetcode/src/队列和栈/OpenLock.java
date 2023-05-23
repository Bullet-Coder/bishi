package 队列和栈;
//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//
//锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//
//列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//
//字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        System.out.println(set);
        //开始遍历的字符串是"0000"，相当于根节点
        String startStr ="0000";
        if(set.contains(startStr)) return -1;
        //创建队列
        Queue<String> queue = new LinkedList<>();
        //记录访问过的节点
        Set<String> visited = new HashSet<>();
        queue.offer(startStr);
        visited.add(startStr);
        //树的层数
        int level = 0;
        while (!queue.isEmpty()){
            //每层的子节点个数
            int size = queue.size();
            while(size-- > 0){
                String str = queue.poll();
                for(int i = 0; i < 4; i++){
                    char ch = str.charAt(i);
                    String strAdd = str.substring(0, i) + (ch == '9' ? 0 : ch - '0' + 1)
                            + str.substring(i + 1);
                    String strSub = str.substring(0, i) + (ch == '0' ? 9 : ch - '0' - 1)
                            + str.substring(i + 1);
                    if(str.equals(target)) return level;
                    if(!visited.contains(strAdd) && !set.contains(strAdd)){
                        queue.offer(strAdd);
                        visited.add(strAdd);
                    }
                    if(!visited.contains(strSub) && !set.contains(strSub)){
                        queue.offer(strSub);
                        visited.add(strSub);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        OpenLock ol = new OpenLock();
        System.out.println(ol.openLock(deadends, target));
    }
}
