public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs.size()==0){
            return Character.toString((char)258);
        }
        String seperate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s);
            sb.append(seperate);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s.equals(Character.toString((char)258))){
            return new ArrayList<>();
        }
        String seperate = Character.toString((char)257);
        return Arrays.asList(s.split(seperate,-1));
        
    }
}




🧠 Encode–Decode Strings – Summary
🔹 Purpose

Convert a list of strings into a single string (encode)

Convert it back to the original list of strings (decode)

Handles empty strings and special characters safely

🔐 Key Idea

Use rare Unicode characters as markers:

char(257) → separator between strings

char(258) → special marker for empty list

These characters won’t normally appear in input strings.

🔁 Encoding Logic

If the input list is empty:

Return a special marker string (char(258)).

Otherwise:

Append each string to a StringBuilder

Separate them using char(257)

Remove the last extra separator

Return the final encoded string.

🔁 Decoding Logic

If the input string equals the empty-list marker (char(258)):

Return an empty list.

Otherwise:

Split the string using the separator (char(257))

Use split(separator, -1) to preserve empty strings

Return the result as a list.
