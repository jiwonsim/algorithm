import Foundation

class Boj2206 {
    struct Position {
        var row: Int, col: Int, broken: Int
        
        init(_ row: Int, _ col: Int, _ broken: Int) {
            self.row = row
            self.col = col
            self.broken = broken
        }
    }
    
    private let directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    private var map = [[Int]]()
    
    private func go(_ N: Int, _ M: Int) -> Int {
        var que = [Position]()
        var head = 0
        var visited = [[[Int]]](repeating: [[Int]](repeating: [Int](repeating: 0, count: 2), count: M), count: N)
        
        que.append(Position(0, 0, 0))
        visited[0][0][0] = 1
        
        while head < que.count {
            let current = que[head]
            head += 1
            
            for direction in directions {
                let nextRow = current.row+direction[0]
                let nextCol = current.col+direction[1]
                
                if nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M { continue }
                
                if map[nextRow][nextCol] == 0 {
                    // 벽이 아닐 때는 그냥 간다. 부쉈는지의 여부는 유지
                    if visited[nextRow][nextCol][current.broken] == 0 {
                        visited[nextRow][nextCol][current.broken] = visited[current.row][current.col][current.broken]+1
                        que.append(Position(nextRow, nextCol, current.broken))
                    }
                }
                else {
                    // 벽일 때는, 깰 수 있을 때 간다.
                    if current.broken == 0 {
                        // 깬다고 표시하고 큐에 삽입
                        if visited[nextRow][nextCol][1] == 0 {
                            visited[nextRow][nextCol][1] = visited[current.row][current.col][current.broken]+1
                            que.append(Position(nextRow, nextCol, current.broken+1))
                        }
                    }
                    // 이미 이전에 깼다면 패쓰
                }
            }
        }
        
        return visited[N-1][M-1][0] == 0 && visited[N-1][M-1][1] == 0 ? -1 : min(visited[N-1][M-1][0] == 0 ? Int.max : visited[N-1][M-1][0], visited[N-1][M-1][1] == 0 ? Int.max : visited[N-1][M-1][1])
    }
    
    func main() {
        guard let NM = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        let N = NM[0]
        let M = NM[1]
        
        map = [[Int]](repeating: [Int](repeating: 0, count: M), count: N)
        
        for i in 0..<N {
            guard let input = readLine() else { return }
            
            let rowNumbers = Array(input).compactMap { Int(String($0)) }
            for j in 0..<M {
                map[i][j] = rowNumbers[j]
            }
        }
        
        print(go(N, M))
    }
}

Boj2206().main()
