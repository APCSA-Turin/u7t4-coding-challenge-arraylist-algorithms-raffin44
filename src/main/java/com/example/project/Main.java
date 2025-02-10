package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    /** Inserts toInsert after each String in stringList
    *  that contains the letter "i"
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0, toInsert.length() > 0
    *
    *  @param stringList  original arraylist of Strings
    *  @param str String to insert
    */
        public static ArrayList<String> insertAfterI(ArrayList<String> stringList, String str) {
            // Loop through each element in the stringList
            for (int i = 0; i < stringList.size(); i++) {
                // Check if the current string contains the letter "i"
                if (stringList.get(i).contains("i")) {
                    i++; // Move to the next index to insert after the current element
                    stringList.add(i, str); // Insert the given string at the next position
                }
            }
            return stringList; // Return the modified list
        }



    /** Removes all Strings from stringList that have a length of 3
   *
   *  DOES mutate (modify) elements of stringList.
   *  PRECONDITION: stringList.size() > 0
   *
   *  @param stringList  original arraylist of Strings
   */
    public static ArrayList<String> removeThree(ArrayList<String> stringList){
         // Iterate through the list
        for (int i = 0; i < stringList.size(); i++) {
            // Check if the current string has a length of 3
            if (stringList.get(i).length() == 3) {
                stringList.remove(i); // Remove the string from the list
                i--; // Decrement i to avoid skipping the next element
            }
        }
        return stringList; // Return the modified list
    }



    /** Returns an ArrayList with all elements of arr reversed
   *
   *  Does NOT mutate (modify) elements in intList.
   *  PRECONDITION: intList.size() > 0
   *
   *  @param intList  original array of integers
   */
    public static ArrayList<Integer> reverseArray(int[] intList){
        // Create a new ArrayList to store the reversed elements
        ArrayList<Integer> reversedList = new ArrayList<>();
    
        // Loop through the array in reverse order
        for (int i = intList.length - 1; i >= 0; i--) {
            reversedList.add(intList[i]); // Add each element to reversedList
        }
               
        return reversedList; // Return the new reversed list
    }



    /** Appends an uppercase version of each string to the end of wordList;
     *  the uppercase versions appear in the same order as the lowercase versions
     *  for example, if wordList is ["hello", "my", "best", "friend"]
     *  this this method modifies wordList to be:
     *  ["hello", "my", "best", "friend", "HELLO", "MY", "BEST", "FRIEND"]
     *
     *  DOES mutate (modify) elements in wordList
     *  PRECONDITIONS: wordList.size() > 0,
     *                 all words in wordList are initially lowercase
     *
     *  @param wordList  arraylist of Strings
     */
    public static ArrayList<String> duplicateUpperEnd(ArrayList<String> wordList){
        // Store the original size of wordList before adding new elements
        int originalSize = wordList.size();

        // Iterate over the original elements of wordList
        for (int i = 0; i < originalSize; i++) {
           // Convert the current word to uppercase and add it to the end of the list
           wordList.add(wordList.get(i).toUpperCase());
    }
    // Return the modified wordList
    return wordList;
    }



    /** Returns an arraylist of Strings that represents the input sentence parsed
   *  into separate words, using a single space (" ") as the delimiter
   *
   *  For example, if sentence = "This is my sentence!"
   *  this method return the arraylist: [This, is, my, sentence!]
   *
   *  PRECONDITION: sentence does not end with a space and each word is
   *                separated by exactly one space
   *
   *  @param sentence  the input String
   *  @return  new arraylist of Strings containing the words of sentence
   */

    public static ArrayList<String> parseSentence(String sentence){         
            // Initialize an empty ArrayList to store parsed words
    ArrayList<String> parsed = new ArrayList<String>();
    // Iterate over each character in the sentence
    for (int i = 0; i < sentence.length(); i++) {
        // Check if the current character is a space (word separator)
        if (sentence.substring(i, i + 1).equals(" ")) {
            // Add the substring from the start of the sentence to the current index as a word
            parsed.add(sentence.substring(0, i));
            // Remove the processed word (including space) from the sentence
            sentence = sentence.substring(i + 1);
            // Reset index to start processing the new sentence from the beginning
            i = 0;
        } 
        // If no spaces remain, add the last word and break the loop
        else if (sentence.indexOf(" ") == -1) {
            parsed.add(sentence);
            break;
        }
    }
    // Return the ArrayList containing the parsed words
    return parsed;
    }



    /** Moves all words in wordList that begin with "b" to the front of
   *  wordList; all "b" words that are moved should appear in the same order
   *  in the modified arrayList as they did before being moved
   *
   *  For example, this method will take a wordList:
   *  ["apple", "banana", "cherry", "donut", "Bagel", "danish", "berry", "baguette", "soda"]
   *  and modify it to
   *  ["banana", "Bagel", "berry", "baguette", "apple", "cherry", "donut", "danish", "soda"]
   *
   *  DOES mutate (modify) elements in wordList
   *  PRECONDITIONS: - wordList.size() > 0
   *                 - all strings in wordList have length >= 1
   *
   *  @param wordList  arraylist of words
   */
    public static ArrayList<String> moveBWords(ArrayList<String> wordList){
    // Create a list to store words that start with 'b' or 'B'
    ArrayList<String> bWords = new ArrayList<>();
    // Create a list to store words that do not start with 'b'
    ArrayList<String> otherWords = new ArrayList<>();
    // Iterate through each word in wordList
    for (String word : wordList) {
        // Check if the word (in lowercase) starts with 'b'
        if (word.toLowerCase().startsWith("b")) {
            bWords.add(word);  // Add to bWords list
        } else {
            otherWords.add(word);  // Add to otherWords list
        }
    }
    // Append all non-"b" words after the "b" words
    bWords.addAll(otherWords);

    // Clear the original list and update it with the sorted words
    wordList.clear();
    wordList.addAll(bWords);

    // Return the modified list
    return wordList;
    }



   /** Removes all duplicate values from an intList, leaving only the first
     *  occurrence in the arrayList; for example, this method will modify
     *  [1, 2, 5, 4, 2, 2, 1, 6, 4, 4, 8, 1, 7, 4, 2] --> [1, 2, 5, 4, 6, 8, 7]
     *
     *  DOES mutate (modify) elements in intList
     *  PRECONDITION: intList.size() > 0
     *
     *  @param intList  intList of Integers
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> intList){
        // Iterate through the list to check for duplicates
        for (int i = 0; i < intList.size(); i++) {
            int current = intList.get(i);
                    
            // Inner loop to remove subsequent occurrences of current value
            for (int j = i + 1; j < intList.size(); j++) {
                if (intList.get(j).equals(current)) {
                    intList.remove(j);
                    j--; // Adjust index to account for the removed element
                }
            }
        }
        return intList; // Return the modified list
    } 

    // Given an array of ints, 
    // return true if the array is length 1 or more, 
    // and the first element and the last element are equal.
    // sameFirstLast([1, 2, 3]) → false
    // sameFirstLast([1, 2, 3, 1]) → true
    // sameFirstLast([1, 2, 1]) → true
    //sameFirstLast([]) -> false
    public static boolean sameFirstLast(ArrayList<Integer> list){
        // Check if the list has at least one element  
        // and if the first element is equal to the last element  
        return list.size() >= 1 && list.get(0).equals(list.get(list.size() - 1));
    }



    // Given an array of ints, swap the first and last elements in the array. 
    // Return the modified array. The array length will be at least 1.
    // swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    // swapEnds([1, 2, 3]) → [3, 2, 1]
    // swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    // swapEnds([]->[])
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list){        
        // Check if the list has more than one element  
        if (list.size() > 1) {  
        // Store the first element in a temporary variable  
        int temp = list.get(0);  
        // Set the first element to the last element  
        list.set(0, list.get(list.size() - 1));  
        // Set the last element to the temporary variable (original first element)  
        list.set(list.size() - 1, temp);  
    }  
    // Return the modified list  
    return list;  
    }



    // Return an array that contains the exact same numbers as the given array, 
    // but rearranged so that all the zeros are grouped at the start of the array. 
    // The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. 
    // You may modify and return the given array or make a new array.
    // zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    // zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    // zeroFront([1, 0]) → [0, 1]
    public static ArrayList<Integer> zeroFront(ArrayList<Integer> list){
        // Create a new list to store the rearranged elements.
        ArrayList<Integer> result = new ArrayList<>();
        int zeroCount = 0; // Counter to track the number of zeros.
        // Count the number of zeros in the list.
        for (Integer num : list) {
            if (num == 0) {
                zeroCount++;
            }
        }
        // Add all the zeros at the beginning of the result list.
        for (int i = 0; i < zeroCount; i++) {
            result.add(0);
        }
        
        // Add the non-zero elements after the zeros.
        for (Integer num : list) {
            if (num != 0) {
                result.add(num);
            }
        }
        
        // Clear the original list and copy the modified elements back into it.
        list.clear();
        list.addAll(result);
        
        // Return the modified list.
        return list;
    }

    // We'll say that an element in an array is "alone" if there are values before and after it, 
    // and those values are different from it. If the value is at the end compare to the left and if its at the beginning compare to the right
    //Return a version of the given array where every instance 
    // of the given value which is alone is replaced by whichever value to its left or right is larger.
    // notAlone([1, 2, 3], 2) → [1, 3, 3]
    // notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 5]
    // notAlone([3, 4], 3) → [4,4]
    public static ArrayList<Integer> notAlone(ArrayList<Integer> list, int val){
        for (int i = 1;  i < list.size() - 1; i++) {
            boolean checks = list.get(i) == val && list.get(i-1) != list.get(i) && list.get(i+1) != list.get(i);
            if (checks) {
                list.set(i, Math.max(list.get(i-1), list.get(i+1))); 
            } 
        }
        boolean checksFirst = list.get(0) == val && list.get(1) > list.get(0);
        if (checksFirst) {
            list.set(0, list.get(1));
        }
        boolean checksLast = list.get(list.size() - 1) == val && list.get(list.size() - 2) > list.get(list.size() - 1);
        if (checksLast){
            list.set(list.size() - 1, list.get(list.size() - 2));
        }    
        return list;
    }
    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. 
    // You may modify and return the given array;
    // shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    // shiftLeft([1, 2]) → [2, 1]
    // shiftLeft([1]) → [1]

    public static ArrayList<Integer> shiftLeft(ArrayList<Integer> list){
    // Only shift if there is more than one element in the list
    if (list.size() > 1) {
        // Remove the first element and store it
        int first = list.remove(0);
        
        // Append the removed first element to the end of the list
        list.add(first);
    }
    // Return the modified list
    return list;
}
    


    // Return an array that contains exactly the same numbers as the given array, 
    // but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
    // but every other number may move. The array contains the same number of 3's and 4's, 
    // every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
    // fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    // fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    // fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    public static ArrayList<Integer> fix34(ArrayList<Integer> list){
    // Create a list to store all 4s in the original list
    ArrayList<Integer> fours = new ArrayList<>();

    // First, find all positions of 4s in the list
    for (int i = 0; i < list.size(); i++) {
        if (list.get(i) == 4) {
            fours.add(i);
        }
    }

    // Index to track which 4 we are placing
    int fourIndex = 0;

    // Iterate through the list to find 3s that are not followed by a 4
    for (int i = 0; i < list.size(); i++) {
        // If the current element is 3 and it's not already followed by a 4
        if (list.get(i) == 3 && (i == list.size() - 1 || list.get(i + 1) != 4)) {
            // Swap the number after the 3 with the next available 4
            int temp = list.get(i + 1);
            list.set(i + 1, 4);  // Place 4 immediately after 3
            list.set(fours.get(fourIndex), temp); // Move the swapped number to the previous 4's position
            // Move to the next available 4 in the stored index list
            fourIndex++;
        }
    }

    // Return the modified list
    return list;
    }

    /** Returns an arraylist of Integers that contain all mode(s) of the array numList.
   *  The mode of a list is the value that appears the greatest number of times.
   *  A list can have one mode, multiple mode, or no mode.
   *
   *  If all elements in the list appear the exact same number of times, there is no
   *  mode and this method should return an empty arraylist.
   *
   *  For example, if numList is: [1, 2, 6, 2, 3, 4, 6, 5, 5, 6, 7],
   *  then numList contains one mode: 6
   *  and this method returns an arrayList containing 6
   *
   *  If numList is: [1, 2, 3, 2, 4, 5, 5, 6],
   *  then numList contains two modes: 2, 5
   *  and this method returns an arraylist containing 2 and 5 (in any order)
   *
   *  If numList is: [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6],
   *  then numList contains no mode because all values appear the same number of times
   *  and this method returns an empty arrayList: []
   *
   *  Does NOT mutate (modify) elements in numList
   *  PRECONDITIONS: numList.length > 0
   *
   *  @param numList  numList of ints
   */
    public static ArrayList<Integer> modes(int[] numList){
            ArrayList<Integer> modeList = new ArrayList<>(); // List to store mode(s)
            int maxCount = 0; // Track highest occurrence count
            int[] frequency = new int[numList.length]; // Array to store frequency of each element
    
            // First pass: Count occurrences of each number
            for (int i = 0; i < numList.length; i++) {
                int count = 0;
                for (int j = 0; j < numList.length; j++) {
                    if (numList[i] == numList[j]) {
                        count++;
                    }
                }
                frequency[i] = count;
                maxCount = Math.max(maxCount, count); // Update maxCount if necessary
            }
    
            // Check if all elements have the same frequency
            boolean allSameFrequency = true;
            for (int count : frequency) {
                if (count != maxCount) {
                    allSameFrequency = false;
                    break;
                }
            }
            if (allSameFrequency) {
                return modeList; // Return empty list if all elements appear the same number of times
            }
    
            // Second pass: Identify numbers that appear maxCount times
            for (int i = 0; i < numList.length; i++) {
                if (frequency[i] == maxCount && !modeList.contains(numList[i])) {
                    modeList.add(numList[i]); // Add mode(s) to the list
                }
            } 
            return modeList; // Return the list of mode(s)
    }
}