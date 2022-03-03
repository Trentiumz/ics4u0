/*
 * Programmer: Daniel ye
 * Date: March 2, 2022
 * Teacher: Ms. Krasteva
 * Description: This class prints out a sample AI poem
 */

package daily.mar1.poem;

public class DanielYeAIPoem {

    /**
     * Fills a template String with random nouns, verbs, articles, and adjectives, then returns it
     * @param template the template string. use '|N' for a noun with an article, '|n' for a noun, '|v' for a verb,
     *                 '|a' for an adjective, '|A' for an adjective with article
     * @return a filled String with the templates
     */
    public static String fill(String template){
        int i = 0;
        // the current string
        StringBuilder cur = new StringBuilder();

        // loop through each character
        while(i < template.length()){
            // if the character is the escape character
            if(template.charAt(i) == '|'){
                // insert the corresponding phrase depending on the next letter into the string
                switch(template.charAt(i + 1)){
                    case 'N':
                        String curNoun = Word.randNoun();
                        cur.append(Word.getArt(curNoun)).append(" ").append(curNoun);
                        break;
                    case 'n':
                        cur.append(Word.randNoun());
                        break;
                    case 'v':
                        cur.append(Word.randVerb());
                        break;
                    case 'A':
                        String curAdj = Word.randAdj();
                        cur.append(Word.getArt(curAdj)).append(" ").append(curAdj);
                        break;
                    case 'p':
                        cur.append(Word.randProp());
                }
                // once processed, skip the next two characters
                i += 2;
            } else {
                // otherwise, add the current character
                cur.append(template.charAt(i));
                i++;
            }
        }
        return cur.toString();
    }

    public static void main(String[] args){
        // fill in a sample poem
        System.out.println(fill("For you, |N |v depressingly |p |A |n."));
        System.out.println(fill("Without you, there would never have been a |n who |v."));
        System.out.println(fill("Yet, without a word, you |v |p |A |n"));
        System.out.println(Word.capitalize(fill("|N searched for you, |N cried for you, |N died for you.")));
        System.out.println(fill("And I... Well I |v |p |A |n in hopes of you."));
        System.out.println(fill("But, alas, I never |v for you"));
        System.out.println(fill("So perhaps I will be able to forget you."));
        System.out.println(fill("And smile when I remember when we |v together."));
    }
}
