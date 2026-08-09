// 2. (bzw. 9. in Leetcode) Palindrome Number
/*
Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?
*/


/*
Erklärung:

- Idee ist die Zahlen einzeln in einem Array zu haben, um dieses dann umdrehen zu können also zu reversen
- kann aber aus einem int nicht einzeln die Digits in ein Array packen, mit String geht es
- deswegen in String packen und die einzelnen Bestandteile des Strings also die einzelnen Zeichen rausholen

- "String numbersInText = Integer.toString(x);" wandelt int in String um
- "numbersInArray[i] = numbersInText.charAt(i) - '0';" wandelt das Zeichen an i-ter Stelle in ein int wieder um und dieser einzelne Integer wird in Array einzeln gepackt
- "charAt(Zeichen in String) - '0'" wandelt allgemein Zeichen in int um wenn es eine Zahl geschrieben ist, weil die Zeichen '0' bis '9' intern aufeinanderfolgende Zeichencodes haben
- Durch das Subtrahieren von '0' erhält man den Zahlenwert der Ziffer. 
- "reversedNumbers[i] = numbersInArray[numbersInArray.length - 1 - i];" kopiert die Elemente aus numbersInArray von hinten nach vorne in reversedNumbers
- numbersInArrray.length - 1 ist ja das letzte Element weil index von letzter Stelle eins weniger als die Länge ist weil Indizes nullbasiert sind (gehen von 0 los)
- Beispiel: numbersInArray = [1 (Index 0), 2 (Index 1), 3 (Index 2), 4 (Index 3)]
- Dann passiert:
i = 0 → Index 4 - 1 - 0 = 3 → reversedNumbers[0] = 4
i = 1 → Index 4 - 1 - 1 = 2 → reversedNumbers[1] = 3
i = 2 → Index 4 - 1 - 2 = 1 → reversedNumbers[2] = 2
i = 3 → Index 4 - 1 - 3 = 0 → reversedNumbers[3] = 1
- wenn wir ohne "- i" machen würden also "numbersInArray[numbersInArray.length - 1]", dann würden wir immer die Zahl beim Durchlauf an i-ter Stelle an die gleiche Stelle machen
- wenn z.B. numbersInArray Länge 4 hätte, dann wäre es "numbersInArray[4 (numbersInArray.length) - 1] also "numbersInArray[3]" bei jedem Durchlauf, 
aber wir müssen immer eins zurück innerhalb dem numbersInArray Array sozusagen, weil wir ja von hinten nach vorne rückwärts die Zahlen nehmen wollen
- da i immer eins größer wird, ziehen wir somit immer eins mehr ab und gehen in der Position hinter und bewegen uns somit im numbersInArray rückwärts pro Aufruf 
und füllen reversedNumbers mit den rückwärtsgehenden Zahlen auf
- Ergebnis: reversedNumbers = [4, 3, 2, 1]
- Warum length - 1? Weil bei einem Array der letzte Index immer Länge − 1 ist.


*/
import java.util.Arrays;

class Solution {
    public boolean isPalindrome(int x) {
        // idea: 
        // - zahlen in Array bekommen einzeln
        // - Array reversen und seperat speichern
        // - prüfen ob beide gleich sind

        String numbersInText = Integer.toString(x);
        int[] numbersInArray = new int[numbersInText.length()];

        for (int i = 0; i < numbersInText.length(); i++){
            numbersInArray[i] = numbersInText.charAt(i) - '0';
        }

        int[] reversedNumbers = new int[numbersInArray.length];

        for (int i = 0; i < numbersInArray.length; i++){
            reversedNumbers[i] = numbersInArray[numbersInArray.length - 1 - i];
        }

        if (Arrays.equals(numbersInArray, reversedNumbers)){
            return true;
        }

        return false;
    }
}



