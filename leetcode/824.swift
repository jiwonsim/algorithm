import Foundation

class Solution {
    
    func isFirstInVowel(_ s: String) -> Bool {
        let firstText = s[0].lowercased()
        
        if firstText == "a" || firstText == "e" || firstText == "i" || firstText == "o" || firstText == "u" { return true }
        return false
    }
    
    func toGoatLatin(_ S: String) -> String {
        let sentences = S.split(separator: " ")
        
        var result = String()
        
        for i in 0..<sentences.count {
            var sentence = String(sentences[i])
            
            if !isFirstInVowel(sentence) {
                sentence.append(sentence.remove(at: sentence.index(sentence.startIndex, offsetBy: 0)))
            }
            sentence.append("ma")
            
            for _ in 0...i {
                sentence.append("a")
            }
            
            if i == sentences.count-1 { result.append(sentence) }
            else { result.append(sentence+" ")}
        }
        
        return result
    }
}

extension String {
    func index(_ i: Int) -> Index {
        return self.index(self.startIndex, offsetBy: i)
    }
    
    subscript(x: Int) -> Character {
        let index = self.index(self.startIndex, offsetBy: x)
        return self[index]
    }
}
