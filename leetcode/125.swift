// 문자열 변환은 최대한 피하자.

class Solution {
    func isPalindrome(_ s: String) -> Bool {
        let sChars = Array(s.lowercased())
        let length = sChars.count
        
        var left = 0, right = length-1
        
        while left < right {
            while !sChars[left].isValid && left < right {
                left+=1
            }
            while !sChars[right].isValid && left < right {
                right-=1
            }
            
            if sChars[left] != sChars[right] { return false }
            left+=1
            right-=1
        }
        
        return true
    }
}

extension Character {
    var isValid: Bool { return isLetter || isNumber }
}

/*
 // time limit failure
 import Foundation

 class Solution {
     func isPalindrome(_ s: String) -> Bool {
         let unwrappedString = s.replacingOccurrences(of: "[^A-Za-z0-9]", with: "", options: .regularExpression, range: nil).lowercased()
         let length = unwrappedString.count
         
         var left = 0, right = length-1
         
         while left < right {
             if unwrappedString[left] != unwrappedString[right] { return false }
             left+=1
             right-=1
         }
         
         return true
     }
 }

 extension String {
     subscript(x: Int) -> Character {
         return self[self.index(self.startIndex, offsetBy: x)]
     }
 }

 */
