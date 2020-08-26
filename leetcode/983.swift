import Foundation

class Solution {
    
    private var days = [Int]()
    private var costs = [Int]()
    private var checked = [Int:Int]()
    private var length = 0
    
    private let durations = [1, 7, 30]
    
    func findCost(_ todayIndex: Int) -> Int{
        if (todayIndex >= length) {
            return 0
        }
        
        if (checked[todayIndex] != nil) {
            return checked[todayIndex]!
        }
        
        var result = Int.max
        var nextIndex = todayIndex
        
        for i in 0..<durations.count {
            while (nextIndex < length && days[todayIndex] + durations[i] > days[nextIndex]) {
                nextIndex += 1
            }
            
            result = min(result, findCost(nextIndex)+costs[i])
        }
        
        checked[todayIndex] = result
        
        return result
    }
    
    
    func mincostTickets(_ days: [Int], _ costs: [Int]) -> Int {
        self.days = days
        self.costs = costs
        self.length = days.count
        
        return findCost(0)
    }
}


//print(Solution().mincostTickets([1, 4, 6, 7, 8, 20], [2, 7, 15]))
//print(Solution().mincostTickets([1,2,3,4,5,6,7,8,9,10,30,31], [2,7,15]))
print(Solution().mincostTickets([1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,21,24,25,27,28,29,30,31,34,37,38,39,41,43,44,45,47,48,49,54,57,60,62,63,66,69,70,72,74,76,78,80,81,82,83,84,85,88,89,91,93,94,97,99],
[9,38,134]))
