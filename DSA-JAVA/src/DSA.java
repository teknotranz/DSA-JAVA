import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DSA {
    int[] arr = {8, 7, 3, 4, 6};
    int[] arr1 = {18, 7, 3, 6, 4};

    public void bubbleSort(){

        //1. start doing 1 pass where it puts the highest value of the array at the end through swapping
        //1a the result of first loop will result: 7-3-4-6-8
        //1b now we just need to loop this n times by adding an outer loop that will loop n-times


        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        //improvement is in the inner loop we made it arr.length - i -i
        //when we make the first pass, we know that the highest value is in the last element
        //at first loop we only loop up to n-1, second loop up to n-2
        //we use the i, outerloop index, to subtract

        System.out.println(Arrays.toString(arr));
    }

    //<editor-fold desc="Two Sum Bruteforce.">


    //</editor-fold>


    //<editor-fold desc="Arrays And Strings - Iterative Basics Month 1">

    /**
     * Two-Sum Brute-force N^2
     * whether array is sorted or not, compares one element to all other elements.
     * Nested For-Loops
     * */
    public void twoSumBrute(){
        int target = 22;
        for(int i = 0; i < arr1.length-1; i++){
            for(int j = i+1; j < arr1.length; j++){
                int x = arr1[i];
                int y = arr1[j];
                if(x + y == target){
                    System.out.println(arr1[i] + arr1[j]);

                }
            }
        }
        System.out.println("No solution");

    }

    /**
     * Two Sum O(n)
     *  Given array is sorted and using two-pointers.
     *  Give array is unsorted and use hashmap
     */
    public void twoSum(){
        int target = 7;
        int[] arr = {1,2,3,4,18,21};
        int left = 0;
        int right = arr.length-1;
        //this is not a 'good' version as i is not being used
        //you can replace this with (for ; left < right;)
//        for(int i = 0; i < arr.length-1; i++){
//            int currSum = arr[left] + arr[right];
//            if(currSum == target){
//                System.out.println("SOLUTION");
//            }
//            if(currSum < target){
//                left++;
//            }else{
//                right--;
//            }
//        }
        while(left < right){
            if(arr[left] + arr[right] == target){
                System.out.println("Two pointer Solution found");
                break;
            }
            if(arr[left] + arr[right] > target) {
                right--;
            }else{
                left++;
            }
        }
        // using of a hashmap version
        int[] arr1 = {8,13,4,9,11};
        int target1 = 20;


        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++){
            int currentDiff = target1 - arr1[i];
            if(map.containsKey(currentDiff)){
                System.out.println("Hashmap solution found");
                return;
            }else{
                map.put(arr1[i], arr1[i]);
            }

        }

        System.out.println("No solution");

    }



    /**
     * Pattern Tip: Whenever you need to compute an aggregate
     * (min, max, sum, count condition...) over an array,
     * a simple loop with an accumulator variable is usually the way to go.
     * Practice this “scan and update” pattern – it’s everywhere in array problems.
     */
    public void aggregatesExample(){
        int arr[] = {3,11, 7, 2,9};
        int lowest = arr[0];
        int highest = arr[0];
        int sumTotal = 0;

        for(int i = 0; i < arr.length; i++){
            //track total while looping
            sumTotal += arr[i];

            //track highest
            if (arr[i] > highest){
                highest = arr[i];
            }

            //track lowest
            if(arr[i] < lowest){
                lowest = arr[i];
            }
        }

        System.out.println("Lowest: " + lowest
        + "\nHighest: " + highest
        + "\nSum: " + sumTotal);

    }


    //Problem: reverse array in-place without using another array to hold the values.

    /**
     * Pattern Tip (Two Pointer):
     * If you have to examine or re-arrange pairs of elements from an array
     * (especially from ends or from two sequences),
     * think of two pointers.
     * For example, problems like “check if a string is a palindrome” or
     * “two-sum in a sorted array” can use this approach.
     * Key insight: One pointer starts at the beginning and one at the end,
     * moving toward each other based on some condition.
     *
     *
     * Perform n/2 swaps. This two pointer strategy is a powerful pattern
     * that often converts a quadratic solution into a linear one by eliminating nested loops
     */
    public void reverseArrayInPlace(){
        int[] arr = {5,8,1,2,6};
        int leftPointer = 0, rightPointer = arr.length-1;

        //stop when the two pointers meet or cross
        while(leftPointer < rightPointer){
            int temp = arr[leftPointer];
            arr[leftPointer] = arr[rightPointer];
            arr[rightPointer] = temp;
            leftPointer++;
            rightPointer--;
        }
        System.out.println(Arrays.toString(arr));
    }


    //maximum sum of a contiguous array
    public void slidingWindow1(){
        int[] arr = new int[]{4, 2, 1, 7, 8, 1, 2, 8, 21};
        int maxSum = 0;

        if(arr.length < 3){
            for(int i = 0; i < arr.length; i++){
                maxSum = arr[i] + maxSum;
            }
            System.out.println("less than three elements, max sum: " + maxSum);
        }

        //for arr > 3
        //initialize the first 3 elements contain the max contiguous subarray
        for(int i = 0;  i < 3; i++){
            maxSum = arr[i] + maxSum;
        }
        int runningSum = maxSum;
        //start loop at index 1 up to the n-2
        //add the value of current index plus the next two
//        for(int i = 1; i < arr.length-3; i++){
//            int num1 = arr[i];
//            int num2 = arr[i+1];
//            int num3 = arr[i+2];
//            int currSum = num1 + num2 + num3;
//            if(currSum > maxSum){
//                maxSum = currSum;
//            }
//        }

        //the issue with this is that we keep summing part
        //that already been calculated, values that need
        //to change are the left and right most indexes

        for(int i = 3; i < arr.length; i++){
            //remove the left most index
            //then add the current index
            runningSum = runningSum - arr[i-3];
            runningSum = runningSum + arr[i];
            if(runningSum > maxSum){
                maxSum = runningSum;
            }
        }

        System.out.println(maxSum);

    }


    /**
     * using two pointer. left at index 0 and right at last index
     * compare two until the pointers cross
     */
    public void isPalindrome(){
        String input = "level";
        if (input == null ||  input.isEmpty() || input.length() < 3){
            System.out.println("No solution");
            return;
        }
        char leftChar = ' ';
        char rightChar = ' ';
        int leftPointer = 0;
        int rightPointer = input.length()-1;
        while(leftPointer < rightPointer){
            if(input.charAt(leftPointer) == input.charAt(rightPointer)){
                leftPointer++;
                rightPointer--;
            }else{
                System.out.println("NOT PALINDROME");
                return;
            }

        }
        System.out.println("PALINDROME");
        
    }

    //</editor-fold>



}
