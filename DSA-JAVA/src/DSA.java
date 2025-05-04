import java.util.Arrays;

public class DSA {
    int[] arr = {8, 7, 3, 4, 6};

    public void bubbleSort(){

        //1. start doing 1 loop where it puts the highest value of the array at the end through swapping
        //1a the result of first loop will result: 7-3-4-6-8
        //1b now we just need to loop this n times by adding an outer loop that will loop n-times

        //improvement is in the inner loop we made it arr.length - i -i
        //when we make the first pass, we know that the highest value is in the last element
        //at first loop we only loop up to n-1, second loop up to n-2
        //we use the i, outerloop index, to subtract
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
