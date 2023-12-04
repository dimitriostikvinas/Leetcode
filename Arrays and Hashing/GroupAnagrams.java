
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs){
            char[] chars = word.toCharArray(); // Converts the current word into a character array.
            Arrays.sort(chars); //Sorts the character array. This is crucial because  anagrams, when sorted, will have the same characters in the same order.
            String sortedWord = new String(chars); // Converts the sorted character array back to a string, creating a representation of the word with its characters sorted.

            map.putIfAbsent(sortedWord, new ArrayList<>());// The key is the sorted word, and the value is a new ArrayList. This is done to ensure that each group of anagrams has a corresponding list in the map.

            map.get(sortedWord).add(word); // adding the original word to the list of anagrams associated with the sorted version of that word in the map.
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        // Example usage
        String[] inputWords = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(inputWords);

        // Display the result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
