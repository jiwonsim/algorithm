import Foundation


class Solution {
    func sortArrayByParity(_ A: [Int]) -> [Int] {
        return A.enumerated().reduce(into: [Int]()) { (lhs, rhs) in
            let (_, value) = rhs
            lhs.insert(value, at: value.isMultiple(of: 2) ? 0 : lhs.count)
        }
    }
}


Solution().sortArrayByParity([3, 1, 2, 4])
