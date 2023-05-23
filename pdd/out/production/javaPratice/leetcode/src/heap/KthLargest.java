package heap;

public class KthLargest {
    int[] nums;  //存放元素
    int k;
    int size;//元素个数
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = new int[k+1];
        for(int i :nums){
            add(i);
        }
    }


    public int add(int val) {
        //元素少于k的时候子需要将元素加入到最后，然后排序
        if(size<k){
            nums[++size] = val;
            int index = size;
            while(index>1){
                int father = index/2;
                if(nums[father]>nums[index]){
                    int temp = nums[father];
                    nums[father] = nums[index];
                    nums[index] = temp;
                    index = father;
                }else break;
            }
        }else{
            //如果元素个数等于k，比较堆顶元素与val的大小
            if(val>nums[1]){
                //堆顶元素比val小时交换堆顶元素，然后排序
                swap(val);
            }

        }
        return nums[1];
    }
    public void swap(int val){
        nums[1] =  val;
        int index = 1;
        while(index < k&&index<=k/2){
            int left = index*2;
            int right = index*2+1;
            //判断right是不是大于k
            if(right>k){
                if(nums[left]<nums[index]){
                    int temp = nums[left];
                    nums[left] = nums[index];
                    nums[index] = temp;
                }
                break;
            }
            if(nums[left]<nums[index]||nums[right]<nums[index]){
                int temp;
                if(nums[left]<nums[right]){
                    temp = nums[left];
                    nums[left] = nums[index];
                    nums[index] = temp;
                    index = left;
                }else{
                    temp = nums[right];
                    nums[right] = nums[index];
                    nums[index] = temp;
                    index = right;
                }

            }else break;

        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums ={4,2,8,5};
        KthLargest kl = new KthLargest(k,nums);
        int num1 = kl.add(3);
        int num2 = kl.add(5);
        int num3 = kl.add(10);
        int num4 = kl.add(9);
        int num5 = kl.add(4);
    }
}
