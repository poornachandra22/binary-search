public class SearchInsertPosition {
    public static int binarySearchInsertOrderSearch(int[] input_array, int value_to_be_found){
        int low_index = 0;
        int high_index = input_array.length - 1;
        while(low_index <= high_index){
            int mid_index = low_index + (high_index - low_index) / 2;
            if(input_array[mid_index] == value_to_be_found){
                return mid_index;
            }
            if (value_to_be_found < input_array[mid_index]){
                high_index = mid_index - 1;
            }
            else{
                low_index = mid_index + 1;
            }
        }
        if(input_array[low_index] < value_to_be_found){
            return low_index + 1;
        }
        else{
            return low_index;
        }
    }

    public static void main(String[] args){
        int[] array = {1,3,5,8,9,13,16,19,22,34,45,56,66};
        int target = 33;

        System.out.println("Array : ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("\ntarget : " + target);

        int index_found = binarySearchInsertOrderSearch(array, target);
        System.out.println("Value belongs at the index of " + index_found + " -> " + array[index_found]);

    }
}
