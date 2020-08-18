import Foundation

enum Test {
    case capital, lower, camel
}

class Solution {
    var upper = String(), lower = String()
    
    func predicate(_ word: String, _ test: Test) -> Bool {
        switch test {
        case .capital: return upper == word
        case .lower: return lower == word
        case .camel: return lower.substringByIndex(1) == word.substringByIndex(1)
        }
    }
    
    func detectCapitalUse(_ word: String) -> Bool {
        upper = word.uppercased()
        lower = word.lowercased()
        
        if predicate(word, .capital) || predicate(word, .lower) || predicate(word, .camel) { return true }
        return false
    }
}

extension String {
    func substringByIndex(_ start: Int, _ end: Int? = nil) -> String {
        let startIndex = self.index(self.startIndex, offsetBy: start)
        let endIndex = self.index(self.startIndex, offsetBy: end ?? self.count)
        return String(self[startIndex..<endIndex])
    }
    
    subscript(x: Int) -> Character {
        return self[self.index(self.startIndex, offsetBy: x)]
    }
}
