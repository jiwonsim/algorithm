import Foundation

class Boj14442 {
    struct Position {
        let row: Int, col: Int, brokenCnt: Int
        init(_ row: Int, _ col: Int, _ brokenCnt: Int) {
            self.row = row
            self.col = col
            self.brokenCnt = brokenCnt
        }
    }
    private let directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    private var N = Int(), M = Int(), K = Int()
    private var map = [[Int]]()
    
    private func go() -> Int {
        var que = [Position](), head = 0
        var visited = [[[Int]]](repeating: [[Int]](repeating: [Int](repeating: 0, count: K+1), count: M+1), count: N+1)
        
        que.append(Position(0, 0, 0))
        visited[0][0][0] = 1
        
        while head < que.count {
            let current = que[head]
            head+=1
            
            for direction in directions {
                let nextRow = current.row + direction[0]
                let nextCol = current.col + direction[1]
                
                if nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M { continue }
                
                if map[nextRow][nextCol] == 0 {
                    // 벽을 안 만나면 그냥 감
                    if visited[nextRow][nextCol][current.brokenCnt] != 0 { continue }
                    que.append(Position(nextRow, nextCol, current.brokenCnt))
                    visited[nextRow][nextCol][current.brokenCnt] = visited[current.row][current.col][current.brokenCnt] + 1
                }
                else {
                    // 벽을 만났다!
                    // 더 부실 수 있는지 확인하고, current.brokenCnt+1 <= K
                    // 더 부실 수 없다면 패쓰, 부실 수 있다면 체크 후 계속 간다.
                    if current.brokenCnt+1 > K { continue }
                    if visited[nextRow][nextCol][current.brokenCnt+1] != 0 { continue }
                    que.append(Position(nextRow, nextCol, current.brokenCnt+1))
                    visited[nextRow][nextCol][current.brokenCnt+1] = visited[current.row][current.col][current.brokenCnt] + 1
                }
            }
        }
        
        var result = Int.max
        for i in 0...K {
            if visited[N-1][M-1][i] == 0 { continue }
            result = min(result, visited[N-1][M-1][i])
        }
        return result == Int.max ? -1 : result
    }
    
    func main() {
        guard let NMK = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        N = NMK[0]
        M = NMK[1]
        K = NMK[2]
        
        map = [[Int]](repeating: [Int](), count: N)
        
        for i in 0..<N {
            guard let input = readLine() else { return }
            map[i] = Array(input).compactMap { Int(String($0)) }
        }
        
        print(go())
    }
}

Boj14442().main()
