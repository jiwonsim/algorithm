import Foundation

class Solution {
    func eraseOverlapIntervals(_ intervals: [[Int]]) -> Int {
        var result = Int()
        
        if intervals.count == 0 { return 0 }
        
        let intervals = intervals.sorted{ $0[0] < $1[0] }
        
        var end = intervals[0][1]
        for i in 1..<intervals.count {
            var current = intervals[i]
            
            if current[0] < end {
                end = min(end, current[1])
                result+=1
            }
            else { end = current[1] }
        }
        
        return result
    }
}
