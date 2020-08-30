import Foundation

class Boj16197 {
    
    private var N = Int(), M = Int()
    private var map = [[String]]()
    
    private let directions = [[0, 1], [0, -1],
                             [1, 0], [-1, 0]]
    
    private func isInRange(_ y: Int, _ x: Int) -> Bool {
        if y < 0 || y >= N || x < 0 || x >= M { return false }
        return true
    }
    
    private func go(_ y1: Int, _ x1: Int, _ y2: Int, _ x2: Int, _ count: Int) -> Int {
        // 10회까지 못 찾으면 끝
        if count > 10 { return -1 }
        
        let fallenOne = !isInRange(y1, x1)
        let fallenTwo = !isInRange(y2, x2)
        
        // 둘 다 떨어지면 끝
        if fallenOne && fallenTwo { return -1 }
        // 둘 중 하나만 떨어지면 성공
        if fallenOne || fallenTwo { return count }
        
        var result = -1
        for direction in directions {
            var nextY1 = y1+direction[0]
            var nextY2 = y2+direction[0]
            
            var nextX1 = x1+direction[1]
            var nextX2 = x2+direction[1]
            
            // 벽을 만나면 원상복귀
            if isInRange(nextY1, nextX1) && map[nextY1][nextX1] == "#" {
                nextY1 = y1
                nextX1 = x1
            }
            if isInRange(nextY2, nextX2) && map[nextY2][nextX2] == "#" {
                nextY2 = y2
                nextX2 = x2
            }
            
            let nextCount = go(nextY1, nextX1, nextY2, nextX2, count+1)
            // 다음 경로로 못 찾았으면 다른 방향으로 탐색
            if nextCount == -1 { continue }
            // result가 갱신되지 않았거나 result의 값이 새로운 경로의 값보다 크면 갱신
            if result == -1 || result > nextCount {
                result = nextCount
            }
        }
        
        return result
    }
    
    func main() {
        guard let NM = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        N = NM[0]
        M = NM[1]
        
        map = [[String]](repeating: [String](repeating: String(), count: M), count: N)
        
        var y1 = -1, x1 = -1, y2 = -1, x2 = -1
        
        for i in 0..<N {
            guard let input = readLine() else { return }
            for j in 0..<M {
                map[i][j] = input[j]
                if map[i][j] == "o" {
                    if y1 == -1 {
                        y1 = i
                        x1 = j
                    }
                    else {
                        y2 = i
                        x2 = j
                    }
                }
            }
        }
        
        print(go(y1, x1, y2, x2, 0))
    }
}

Boj16197().main()


extension String {
    subscript(x: Int) -> String {
        return String(self[self.index(self.startIndex, offsetBy: x)])
    }
}
