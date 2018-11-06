package N;

public class Water {

    //11.盛最多的水容器
    public int maxArea(int[] height) {
        int max = 0;
        int head = 0;
        int tail = height.length - 1;
        for (int i = 0; i <= height.length - 2; i ++){
            int all = 0;
            if (height[head] < height[tail]){
                if ((tail - head) * height[head] > max){
                    max = (tail - head) * height[head];
                }
                head ++;
            }else{
                if ((tail - head) * height[tail] > max){
                    max = (tail - head) * height[tail];
                }
                tail --;
            }
        }
        return max;
    }

}


    // for any i, the maxium area will be the farthest j that has a[j] > a[i];

   /* public int maxArea(int[] height) {

        if(height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right) {
            max = Math.max( max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;

    }*/

