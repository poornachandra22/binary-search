public class FindSmallestLetterGreaterThanTarget {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l=0;
        int h=letters.length-1;
        if(target>=letters[h]){
            return letters[0];
        }
        while(l<=h){
            int m=l+(h-l)/2;
            if(target<letters[m]){
                h=m-1;
            }
            else{
                l=m+1;
            }
            System.out.println(" l = " + letters[l] + " & h = " + letters[h]);
        }
        return letters[l];
    }
    public static void main(String[] args){
        char[] array = {'c','f','j'};
        char target = 'j';

        System.out.println("Array : ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println("\ntarget : " + target);

        char index_found = nextGreatestLetter(array, target);
        System.out.println("Output is :- " + index_found);
    }
}
