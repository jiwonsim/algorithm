import Foundation

func isRight(_ str: String) -> Bool {
    var stack = [Character]()
    
    for element in str {
        if element == "(" {
            stack.append(element)
        }
        else {
            if stack.count == 0 { return false }
            if stack.last! != "(" { return false }
            stack.removeLast()
        }
    }
    return true
}

func divide(_ str: String) -> (String, String) {
    var left = 0, right = 0
    
    for i in 0..<str.count {
        let element = str[i]
        
        if element == "(" { left += 1 }
        else { right += 1 }
        
        if left == right {
            return (str.divide(0, i+1), str.divide(i+1, str.count))
        }
    }
    
    return (str, String())
}

func makeRightString(_ u: String, _ v: String) -> String {
    var right = "(" + go(v) + ")"
    for element in u.divide(1, u.count-1) {
        if element == "(" { right += ")" }
        else { right += "(" }
    }
    return right
}

func go(_ p: String) -> String {
    if p.count == 0 { return String() }
    
    let (u, v) = divide(p)
    
    if isRight(u) {
        if isRight(v) { return u + v }
        let modifiedV = go(v)
        return u + modifiedV
    }
    else {
        return makeRightString(u, v)
    }
}

func solution(_ p: String) -> String {
    
    return go(p)
}

extension String {
    subscript(x: Int) -> Character {
        return self[self.index(self.startIndex, offsetBy: x)]
    }
    
    func divide(_ start: Int, _ end: Int) -> String {
        let startIndex = self.index(self.startIndex, offsetBy: start)
        let endIndex = self.index(self.startIndex, offsetBy: end)
        return String(self[startIndex..<endIndex])
    }
}
