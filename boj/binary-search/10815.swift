import Foundation

class Boj10815 {
    
    func go(_ cards: [Int], _ value: Int) -> Bool {
        var left = 0, right = cards.count - 1
        
        while left <= right {
            let mid = (left+right)/2
            
            if cards[mid] == value { return true }
            else if cards[mid] > value {
                right = mid-1
            }
            else { left = mid+1 }
        }
        
        return false
    }
    
    func main() {
        guard let _ = readLine(),
            var cards = readLine()?.split(separator: " ").compactMap({Int(String($0))}),
            let _ = readLine(),
            let target = readLine()?.split(separator: " ").compactMap({Int(String($0))})
            else { return }
        
        // 이분탐색을 위해 오름차순으로 정렬
        cards.sort()
        
        for element in target {
            print(go(cards, element) ? 1 : 0, terminator: " ")
        }
    }
}

Boj10815().main()
