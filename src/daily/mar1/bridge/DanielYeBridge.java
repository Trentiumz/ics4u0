/*
* Programmer: Daniel ye
* Date: March 2, 2022
* Teacher: Ms. Krasteva
* Description: This game shuffles, scores, and simulates a single round of bridge
 */

package daily.mar1.bridge;

import java.util.*;
import java.io.*;

public class DanielYeBridge {
    public static final ArrayList<String> suits = new ArrayList<String>(Arrays.asList("S", "H", "D", "C"));

    /**
     * Returns the score that a player has
     * Jack, Queen, King, Ace give 1, 2, 3, and 4 points respectively
     * If any one suit has no cards, add 3; if any one suit has exactly 1 card, add 2; if any one suit has exactly 2 cards, add 1
     * @param player a list of cards represented as Strings that a player has
     * @return the score of the player
     */
    public static int getScore(ArrayList<String> player){
        // the total score
        int total = 0;

        // whether there is a void, single, or double
        boolean hasVoid=false, hasSingle=false, hasDouble=false;

        // for every suit
        for(String suit : suits){
            // the number of cards with this suit
            int cnt = 0;
            for(String i : player){
                if(i.substring(1).equals(suit)){
                    cnt++;
                }
            }

            // if there are 0 cards, we have a void; 1 card means we have a single; 2 cards means we have a double
            if(cnt == 0) hasVoid = true;
            else if(cnt == 1) hasSingle = true;
            else if(cnt == 2) hasDouble = true;
        }

        // add points for voids, singles, and doubles
        if(hasVoid) total += 3;
        if(hasSingle) total += 2;
        if(hasDouble) total += 1;

        // for every card, add points for jacks, queens, kings, and aces
        for(String i : player){
            if(i.charAt(0) == 'J') total += 1;
            else if(i.charAt(0) == 'Q') total += 2;
            else if(i.charAt(0) == 'K') total += 3;
            else if(i.charAt(0) == 'A') total += 4;
        }

        // return the total score
        return total;
    }

    public static void main(String[] args) throws IOException{
        // read all of the cards from a file
        BufferedReader br = new BufferedReader(new FileReader("./cards.txt"));
        ArrayList<String> cards = new ArrayList<String>();

        // loop through each line, adding it to the [cards] list
        String line;
        while((line=br.readLine()) != null){
            cards.add(line);
        }

        // shuffle the cards
        Collections.shuffle(cards);

        // a list of players (which are represented as lists themselves)
        ArrayList<ArrayList<String>> player = new ArrayList<ArrayList<String>>();

        // number of players, number of cards per player
        int players = 4, cardsPerPlayer = 52 / players;
        // for every player, initialize the list and add [cardsPerPlayer] cards, removing them from the cards list
        for(int i = 0; i < players; i++){
            player.add(new ArrayList<String>());
            for(int c = 0; c < cardsPerPlayer; c++){
                player.get(i).add(cards.remove(cards.size() - 1));
            }
        }

        // the list of players with the max score
        ArrayList<Integer> maxPlayers = new ArrayList<Integer>();

        // the max score
        int maxScore=-1;
        for(int i = 0; i < player.size(); i++){
            // get the score of the player
            int score = getScore(player.get(i));

            // print out the summary of the hand and score for the player
            System.out.println("Player " + (i + 1) + ":");
            System.out.println("Hand: " + String.join(" ", player.get(i)));
            System.out.println("Score: " + score);
            System.out.println();

            // if the score is better than the max score, then we replace the max score with this
            if(score > maxScore){
                maxPlayers.clear();
                maxPlayers.add(i);
                maxScore = score;
            }else if(score == maxScore){
                // if the current score is just as good as the max score, add it to the list of players
                maxPlayers.add(i);
            }
        }

        // if there is an n-way tie, print out all the players with the best score
        if(maxPlayers.size() > 1){
            // the beginning prompt
            System.out.print("With a score of " + maxScore + ", Players ");

            // list out the player ID's, adding a comma before the second to second last player
            for(int i = 0; i < maxPlayers.size() - 1; i++){
                if(i >= 1) System.out.print(", ");
                System.out.print((maxPlayers.get(i) + 1));
            }

            // use "and" to join the final player
            System.out.print(" and " + (maxPlayers.get(maxPlayers.size() - 1) + 1));

            // suffix
            System.out.println(" all tied for first place!");
        } else {
            // print out the single player
            System.out.println("Player " + (maxPlayers.get(0) + 1) + " won with a score of " + maxScore + "!");
        }
    }
}
