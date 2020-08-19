class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var hold = [Int](repeating: Int.min, count: 2+1), sell = [Int](repeating: 0, count: 2+1)
        
        for i in 0..<prices.count {
            for j in 1...2 {
                sell[j] = max(sell[j], hold[j]+prices[i])
                hold[j] = max(hold[j], sell[j-1]-prices[i])
            }
        }
        
        return sell[2]
    }
}
