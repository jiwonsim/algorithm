import Foundation

class Solution {
    
    func remove(_ S: String) -> String {
        var output = String()
        
        var last: Character?
        for (_, v) in S.enumerated() {
            if let temp = last {
                if temp == v { last = nil }
                else {
                    output.append(temp)
                    last = v
                }
            }
            else { last = v }
        }
        
        if let temp = last { output.append(temp) }
        
        return output
    }
    
    func removeDuplicates(_ S: String) -> String {
        if S.count == 0 { return "" }
        
        var result = String()
        var existed = remove(S)
        while true {
            
            let newString = remove(existed)
            if newString == existed {
                result.append(newString)
                break
            }
            
            existed = newString
        }
               
        return result
    }
}
extension String {
    subscript(x: Int) -> Character {
        return self[self.index(self.startIndex, offsetBy: x)]
    }
    
    func rangeBy(_ start: Int, _ end: Int) -> Range<String.Index> {
        return self.index(self.startIndex, offsetBy: start)..<self.index(self.startIndex, offsetBy: end)
    }
}
