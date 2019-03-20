import java.util.*;
import java.lang.Math; 
public class ShortestDistanceToChar{

    public static int[] shortestToChar(String S, char C) {
        List<Integer> cAppearanceList = new ArrayList<Integer> (); //this will contain the "indices" (b/c the character may appear 1 or more times) of C.
        int[] shortestDistance = new int[S.length()]; 
        int min = S.length(); //we initialize min distance to the specified character a "big" number--none of the characters will have a distance as large as the string length
        for(int i=0; i<S.length(); i++) { //so here we reserve the "position" (index) of C's appearance, and save the index to an array list
            if (S.charAt(i) == C)
                cAppearanceList.add(i); 
        }
        for(int j=0; j<S.length(); j++) { //now we find the distance of each character to C
            min = S.length(); //make sure to reset minimum distance for each charaacter in string S 
            for(int k=0; k<cAppearanceList.size(); k++) { //here we compare each character in S against each position of the appearance of C
                min= (min > Math.abs(j - cAppearanceList.get(k)))? Math.abs(j - cAppearanceList.get(k)):min;  //C can appear in different indices, so we're looking for the "shortest" distance from a character in S to one of the indices. 
            }
            shortestDistance[j]=min; //save this minimum distance between each character in S and position of C. 
        }
        return shortestDistance; 
    }
     public static void main(String []args){
         String myString = "love"; 
         int[] answer = shortestToChar(myString, 'o');
         for (int i=0; i<answer.length; i++) {
            System.out.println(answer[i]+" ");
         }
     }
}
