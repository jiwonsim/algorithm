import java.util.*; 

class Solution {
    
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>(); 
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j]; 
                if (set.contains(sum)) continue; 
                set.add(sum); 
            }
        }
        
        int[] answer = new int[set.size()];
        int i = 0; 
        for (int element : set) {
            answer[i++] = element; 
        }
        
        Arrays.sort(answer); 
        
        return answer; 
    }
}
