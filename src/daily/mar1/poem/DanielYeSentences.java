/*
 * Programmer: Daniel ye
 * Date: March 2, 2022
 * Teacher: Ms. Krasteva
 * Description: This class prints out 5 random sentences
 */

package daily.mar1.poem;

public class DanielYeSentences {

    public static void main(String[] args) {
        // number of lines to make
        int times = 5;
        for(int i = 0; i < times; i++){
            // for each line, Write [article] [noun] [verb] [preposition] [article] [adjective] [noun]
            String firstNoun = Word.randNoun();
            String secondAdj = Word.randAdj();
            System.out.println(Word.capitalize(Word.getArt(firstNoun)) + " " + firstNoun + " " + Word.randVerb() +
                    " " + Word.randProp() + " " + Word.getArt(secondAdj) + " " + secondAdj + " " + Word.randNoun());
        }
    }
}
