import Foundation

func solution(_ s:String) -> Int {
    
    if s.count <= 1 { return 1 }
    
    var shortestLength = Int.max
    for unit in 1...s.count/2 { // s.count <= 1000
        
        var currentString = String()
        
        var before: String = s[s.rangeBy(0, unit)] // 이전 문자
        var count: Int = 1 // 연속하는 수
        for i in sequence(first: unit, next: {$0+unit}).prefix(while: {$0 <= s.count}) {
            
            // i+unit의 범위를 체크해서 current에 할당해준다.
            var current = String()
            if i+unit >= s.count {
                current = s[s.rangeBy(i, s.count)]
            }
            else { current = s[s.rangeBy(i, i+unit)] }
            
            if before == current {
                // 이전 문자와 현재 탐색할 문자가 같을 때,
                count += 1
            }
            else {
                // 이전 문자와 다를 때
                // 1개 이상 반복될 때만 숫자를 붙인다.
                if count == 1 { currentString += "\(before)" }
                else {
                    currentString += "\(count)\(before)"
                }
                // 초기화
                count = 1
                before = current
            }
        }
        // 마지막 값을 넣어준다.
        if count > 1 {
            currentString += "\(count)\(before)"
        }
        else { currentString += "\(before)" }
        
        // 최소 길이 갱신
        shortestLength = min(shortestLength, currentString.count)
    }
    
    return shortestLength
}

extension String {
    func rangeBy(_ start: Int, _ end: Int) -> Range<String.Index> {
        let start = self.index(self.startIndex, offsetBy: start)
        let end = self.index(self.startIndex, offsetBy: end)
        return start..<end
    }
    
    subscript(x: Int) -> String {
        return String(self[self.index(self.startIndex, offsetBy: x)])
    }
    
    subscript(range: Range<String.Index>) -> String {
        return String(self[range])
    }
}
