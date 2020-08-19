class Solution {
    func distributeCandies(_ candies: Int, _ numOfPeople: Int) -> [Int] {
        var candies = candies
        
        var candiesHolding = [Int](repeating: 0, count: numOfPeople)
        
        var currentCandy = 1
        var peopleIndex = 0
        while candies > 0 {
            if currentCandy > candies {
                candiesHolding[peopleIndex%numOfPeople] += candies
                break
            }
            
            candiesHolding[peopleIndex%numOfPeople] += currentCandy
            candies -= currentCandy
            
            peopleIndex+=1
            currentCandy+=1
        }
        
        return candiesHolding
    }
}
