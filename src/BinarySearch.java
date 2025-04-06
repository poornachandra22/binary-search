import java.util.Scanner;
public class BinarySearch{

    // Binary Search | works best for Searching in sorted arrays
    // Iterative Approach
    public static int binarySearchIterative(int[] input_array, int value_to_be_found){
        int low_index = 0;
        int high_index = input_array.length - 1;
        while(low_index <= high_index){
            int mid_index = (low_index + high_index) / 2;
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
        return -1;
    }

    // Iterative Approach | when we do not know if array is sorted in ASC or DESC order
    public static int binarySearchOrderAgnostic(int[] input_array, int value_to_be_found){
        int low_index = 0;
        int high_index = input_array.length - 1;

        while(low_index <= high_index){
            int mid_index = (low_index + high_index) / 2;
            boolean isAsc = input_array[low_index] < input_array[high_index];

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
        return -1;
    }

    // Recursive Approach
    public static int binarySearchRecursive(int[] input_array, int low_index, int high_index, int value_to_be_found){
        while(low_index <= high_index){
            int mid_index = (low_index + high_index) / 2;
            if(input_array[mid_index] == value_to_be_found){
                return mid_index;
            }
            if(value_to_be_found > input_array[mid_index]){
                return binarySearchRecursive(input_array, (mid_index + 1), high_index, value_to_be_found);
            }
            else{
                return binarySearchRecursive(input_array, low_index, (mid_index - 1), value_to_be_found);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Array length : ");
        int array_length = scanner.nextInt();

        int[] array_given = new int[array_length];
        for (int i = 0; i < array_length; i++){
            System.out.println("Enter element for position "+(i+1)+" :");
            int input = scanner.nextInt();
            array_given[i]=input;
        }

        System.out.println("Array given by user : ");
        for(int i=0; i<array_given.length; i++){
            System.out.print(array_given[i] + " ");
        }

        System.out.println("\nEnter value to be searched : ");
        int value = scanner.nextInt();

        int index_found = binarySearchOrderAgnostic(array_given, value);
        // int index_found = binarySearchRecursive(array_given, 0, (array_given.length -1), value);

        if(index_found != -1){
            System.out.println("Value belongs at index " + (index_found));
        }
        else{
            System.out.println("Value not found in given array");
        }
        scanner.close();
    }
}