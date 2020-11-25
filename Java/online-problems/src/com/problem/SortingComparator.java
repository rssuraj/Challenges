package com.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * HACKERRANK
 * 
 * Comparators are used to compare two objects.
 * In this challenge, you'll create a comparator and use it to sort an array.
 * The Player class is provided in the editor below.
 * It has two fields:
 	1. name: a string.
    2. score: an integer.

 * Given an array of n Player objects, write a comparator that sorts them in order of decreasing score.
 * If 2 or more players have the same score, sort those players alphabetically ascending by name.
 * To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.
 * In short, when sorting in ascending order, a comparator function returns -1 if a < b, 0 if a = b, and 1 if a > b.

 * For example, given n = 3 Player objects with Player.name, Player.score values of data = [[Smith, 20], [Jones, 25], [Jones, 20]].
 * We want to sort the list as data(sorted) = [[Jones, 20], [Smith, 20], [Jones, 15]].

 * Function Description
 	- Declare a Checker class that implements the comparator method as described.
 	- It should sort first descending by score, then ascending by name.
 	- The code stub reads the input, creates a list of Player objects, uses your method to sort the data, and prints it out properly.

 * Input Format
 	- Locked stub code in the Solution class handles the following input from stdin:
 		* The first line contains an integer, n, the number of players.
 		* Each of the next n lines contains a player's respective name and score, a string and an integer.

 * Constraints
 	- 0 <= score <= 1000
 	- Two or more players can have the same name.
 	- Player names consist of lowercase English alphabetic letters.

 * Output Format
 	- You are not responsible for printing any output to stdout.
 	- Locked stub code in Solution will create a Checker object, use it to sort the Player array, and print each sorted element.

 * Sample Input

		5
		amy 100
		david 100
		heraldo 50
		aakansha 75
		aleksa 150

 * Sample Output

		aleksa 150
		amy 100
		david 100
		aakansha 75
		heraldo 50

 * Explanation
 	- As you can see, the players are first sorted by decreasing score and then sorted alphabetically by name.

 * @author rssuraj
 *
 */

public class SortingComparator {
	
	class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}
	
	class Checker implements Comparator<Player> {
	  	// complete this method
		public int compare(Player a, Player b) {
	        if(a.score == b.score) {
	            return a.name.compareTo(b.name);
	        }
	        else if(a.score < b.score) {
	            return 1;
	        }
	        else {
	            return -1;
	        }
	    }
	}

	public static void main(String[] args) {
        int n = 5;
        
        SortingComparator sc = new SortingComparator();

        Player[] player = new Player[n];
        Checker checker = sc.new Checker();
        
        player[0] = sc.new Player("amy", 100);
        player[1] = sc.new Player("david", 100);
        player[2] = sc.new Player("heraldo", 50);
        player[3] = sc.new Player("aakansha", 75);
        player[4] = sc.new Player("aleksa", 150);

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
	}
}
