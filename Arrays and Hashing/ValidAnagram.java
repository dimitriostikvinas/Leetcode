import java.util.HashMap;
// import java.util.Map;

public class ValidAnagram {
    public static boolean is_Anagram(String s, String t) {
        HashMap<Character, Integer> charMap = new HashMap<>();

        if( s.length() > t.length()){
            return false;
        }

        for(char c : s.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        // for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
        //     System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        // }
        
        for(char c : t.toCharArray()){
            if(charMap.containsKey(c) && charMap.get(c) !=0 ){
                charMap.put(c, charMap.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
    
    
    public static void main(String[] args) {
		String s = "aacc";
        String t = "ccac";

        System.out.println(is_Anagram(s, t)); // Output: true
	}
}