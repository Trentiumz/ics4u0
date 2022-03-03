/*
 * Programmer: Daniel ye
 * Date: March 1, 2022
 * Teacher: Ms. Krasteva
 * Description: This class provides a list of words, and provides methods for getting a random word and adding appropriate articles
 */

package daily.mar1.poem;

import java.util.*;

public class Word {
    public static final ArrayList<String> NOUNS = new ArrayList<String>(Arrays.asList("bottle", "cup", "pencil", "desk", "sticker", "window", "box", "watch", "boy", "girl", "person", "child", "adult", "woman", "man"));
    public static final ArrayList<String> PREPOSITIONS = new ArrayList<String>(Arrays.asList("at", "by", "for", "from", "in", "of", "on", "to", "with", "above", "across", "after", "against", "along", "around", "before", "behind", "below", "beneath", "beside", "between", "close to", "inside", "into", "like", "near", "off", "on top of", "onto", "out of", "outside", "over", "past", "through", "toward", "under", "within"));
    public static final ArrayList<String> ADJECTIVES = new ArrayList<String>(Arrays.asList("agreeable", "bloody", "blushing", "busy", "clean", "creepy", "delightful", "drab", "dull", "elegant", "evil", "expensive", "fine", "frantic", "hungry", "homeless", "modern", "mushy", "nutty", "prickly", "scary", "spotless", "unsightly", "vast", "zealous"));
    public static final ArrayList<String> VERBS = new ArrayList<String>(Arrays.asList("walked", "spoke", "ate", "played", "read", "jumped", "painted", "cried", "smiled", "laughed", "sneezed"));
    public static final ArrayList<Character> VOWELS = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    /**
     * returns a random grammatically correct article for a noun
     * @param noun the noun
     * @return the corresponding article
     */
    public static String getArt(String noun) {
        if(Math.random() < 0.3) return "the";
        else if(VOWELS.contains(noun.charAt(0))) return "an";
        else return "a";
    }

    /**
     * Capitalizes the first letter of a word
     * @param word the word to capitalize
     * @return the capitalized word
     */
    public static String capitalize(String word){
        String first = word.substring(0, 1).toUpperCase();
        if(word.length() > 1) return first + word.substring(1);
        else return first;
    }

    /**
     * Returns a random word in a lsit
     * @param words the list of words
     * @return a random word in words
     */
    public static String randomWord(List<String> words){
        int index = (int) (Math.random() * words.size());
        return words.get(index);
    }

    /**
     * generate a random noun
     * @return a random noun
     */
    public static String randNoun(){
        return randomWord(NOUNS);
    }

    /**
     * generate a random proposition
     * @return a random proposition
     */
    public static String randProp(){
        return randomWord(PREPOSITIONS);
    }

    /**
     * generate a random adjective
     * @return a random adjective
     */
    public static String randAdj(){
        return randomWord(ADJECTIVES);
    }

    /**
     * generate a random verb
     * @return a random verb
     */
    public static String randVerb(){
        return randomWord(VERBS);
    }
}
