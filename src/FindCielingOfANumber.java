public class FindCielingOfANumber{
    public static int findCielingOfANumber(int[] input_array, int value_to_be_found){
        int low_index = 0;
        int high_index = input_array.length - 1;
        boolean isAsc = input_array[low_index] < input_array[high_index];
        while(low_index <= high_index){
            int mid_index = (low_index + high_index) / 2;
            if(input_array[mid_index] == value_to_be_found){
                return mid_index;
            }
            if (isAsc){
                if (value_to_be_found < input_array[mid_index]){
                    high_index = mid_index - 1;
                }
                else{
                    low_index = mid_index + 1;
                }
            }
            else{
                if (value_to_be_found > input_array[mid_index]){
                    high_index = mid_index - 1;
                }
                else{
                    low_index = mid_index + 1;
                }
            }
        }
        return low_index;
    }

    public static void main(String[] args){
        int[] array = {1,3,5,8,9,13,16,19,22,34,45,56,66};
        int target = 33;

        System.out.println("Array : ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("\ntarget : " + target);
        int index_found = findCielingOfANumber(array, target);
        System.out.println("\nCieling Index :- " + index_found + " -> " + array[index_found]);
    }
}