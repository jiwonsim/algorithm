import Foundation

class Boj16198 {
    
    var N = Int()
    var marbles = [Int]()
    var visited = [Bool]()
    
    var result = -1
    
    func go(_ sum: Int) {
        
        for i in 1..<N-1 {
            if visited[i] { continue }
            
            visited[i] = true
            
            var left = i, right = i
            while left >= 0 && visited[left] {
                left -= 1
            }
            while right < N && visited[right] {
                right += 1
            }
            
            go(sum+(marbles[left]*marbles[right]))
            visited[i] = false
        }
        
        result = max(result, sum)
        
    }
    
    func main() {
        guard let inputN = readLine(),
            let input = readLine()?.inlineInteger
            else { return }
        
        N = Int(inputN) ?? 0
        marbles = input
        visited = [Bool](repeating: false, count: N)
        
        go(0)
        print(result)
    }
}

Boj16198().main()

extension String {
    var inlineInteger: [Int] {
        return self.split(separator: " ").compactMap({Int(String($0))})
    }
}
