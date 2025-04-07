public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int searchIndex(int[] nums, int target, boolean isFirst){
        int l=0;
        int h=nums.length-1;
        int index_found = -1;

        while(l<=h){
            int m=l+(h-l)/2;
            if(target < nums[m]){
                h=m-1;
            }
            else if(target > nums[m]){
                l=m+1;
            }
            else{
                index_found = m;
                if(isFirst){
                    h=m-1;
                }
                else{
                    l=m+1;
                }
            }
        }
        return index_found;
    }

    public static int[] firstAndLastOccuranceOfTheElement(int[] nums, int target){
        int[] ans = {-1, -1};
        ans[0] = searchIndex(nums, target, true);
        ans[1] = searchIndex(nums, target, false);
        return ans;
    }

    public static void main(String[] args){
        int[] array = {5,7,7,7,7,8,8,10};
        int target = 7;
        System.out.println("Array : ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("\ntarget : " + target);
        int[] pair = firstAndLastOccuranceOfTheElement(array, target);
        System.out.println("Occurance are : " + pair[0] + " , " + pair[1]);
    }
}
