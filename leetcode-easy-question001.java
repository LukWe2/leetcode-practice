// 1. Two Sum
/* You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

// diese Lösung geht nicht/ist nicht richtig:
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++){
            currentSum = nums[i] + nums[i + 1];

            if (currentSum == target){
                return new int[]{i, i + 1};
            }
        }
        return new int[]{0};
    }
}
/*
- Weil: sie nur direkt benachbarte Elemente prüft, nicht alle Kombinationen
- Zum Beispiel: nums = [3, 2, 3], target = 6
- Die richtige Lösung wäre: nums[0] + nums[2] also 3 + 3 = 6 → [0, 2]
- Dieser Code prüft aber nur: nums[0] + nums[1] also 3 + 2 = 5 und nums[1] + nums[2] also 2 + 3 = 5, aber nicht nums[0] und nums[2]

- Außerdem enthält sie noch einen Fehler: Beim letzten Durchlauf ist i = nums.length - 1, und weil wir nums[i] machen somit nums[nums.length]
- Dieser Index existiert nicht → ArrayIndexOutOfBoundsException, weil nullbasiert also length ist in dem Beispiel hier 3, geht aber nur bis nums[2], müsste also i < nums.length - 1 machen
- aber selbst dann wäre die Lösung immer noch nicht korrekt, weil sie eben nur Nachbarn prüft
*/


// diese ist richtig, weil: durch die zweite Schleife nimmt man jede Zahl, und multipliziert sie mit jeweils jeder ab der nächsten Zahl (wegen int j = i + 1)
// erster Durchlauf von i, also i = 0 (nums[i] = 2):
// j = 1 -> nums[i] + nums[j] = 2 + 7
// j = 2 -> nums[i] + nums[j] = 2 + 11
// j = 3 -> nums[i] + nums[j] = 2 + 15

// zweiter Durchlauf von i, also i = 1 (nums[i] = 7):
// j = 2 -> nums[i] + nums[j] = 7 + 11
// j = 3 -> nums[i] + nums[j] = 7 + 15

// dritter Durchlauf von i, also i = 2 (nums[i] = 11):
// j = 3 -> nums[i] + nums[j] = 11 + 15

// vierter Durchlauf von i, also i = 3 (nums[i] = 15):
// j startet bei i + 1 = 4
// 4 < nums.length ist false, daher läuft die innere Schleife nicht mehr

class Solution2 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}


