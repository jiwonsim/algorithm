import Foundation

class Solution {
    var result = [Int]()
    
    func find(_ number: Int, _ N: Int, _ K: Int) {
        if N == 0 {
            result.append(number)
            return
        }
        
        var nextDigits = [Int]()
        nextDigits.append(number%10 + K)
        if K != 0 { nextDigits.append(number%10 - K)}
        
        for nextDigit in nextDigits {
            if nextDigit < 0 || nextDigit >= 10 { continue }
            find(number*10+nextDigit, N-1, K)
        }
    }
    
    func numsSameConsecDiff(_ N: Int, _ K: Int) -> [Int] {
        
        for i in 1...9 {
            find(i, N-1, K)
        }
        
        if N == 1 { result.append(0) }
        
        return result
    }
}

print(Solution().numsSameConsecDiff(1, 0))
