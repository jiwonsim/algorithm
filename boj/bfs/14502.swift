import Foundation

class Boj14502 {
    
    struct Position {
        var row: Int, col: Int
        init(_ row: Int, _ col: Int) {
            self.row = row
            self.col = col
        }
    }
    
    private let directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    
    private var N = Int(), M = Int()
    private var map = [[Int]]()
    private var visited = [[Bool]]()
    
    private var viruses = [Position]()
    private var emptySpaces = [Position]()
    
    private var result = 0
    
    func counting(_ array: [[Int]]) -> Int {
        var count = 0
        for i in 0..<N {
            for j in 0..<M {
                if array[i][j] == 0 {
                    count += 1
                }
            }
        }
        return count
    }
    
    func spreadVirus() -> Int {
        var temporaryMap = map
        var que = [Position]()
        var head = 0
        var checked = [[Bool]](repeating: [Bool](repeating: false, count: M), count: N)
        
        for virus in viruses {
            que.append(virus)
            checked[virus.row][virus.col] = true
        }
        
        while head < que.count {
            let current = que[head]
            head += 1
            
            for direction in directions {
                let next = Position(current.row+direction[0], current.col+direction[1])
                
                if next.row < 0 || next.col < 0 || next.row >= N || next.col >= M { continue }
                if checked[next.row][next.col] || temporaryMap[next.row][next.col] != 0 { continue }
                
                checked[next.row][next.col] = true
                temporaryMap[next.row][next.col] = 2
                que.append(next)
            }
        }
        
        return counting(temporaryMap)
    }
    
    func go(_ row: Int, _ col: Int, _ wallCnt: Int) {
        if wallCnt == 3 {
            // 벽을 세 개 만들었다.
            // 바이러스 뿌리기
            result = max(result, spreadVirus())
            return
        }
        
        for nextRow in 0..<N {
            for nextCol in 0..<M {
                if map[nextRow][nextCol] != 0 || visited[nextRow][nextCol] { continue }
                
                visited[nextRow][nextCol] = true
                map[nextRow][nextCol] = 1
                
                go(nextRow, nextCol, wallCnt+1)
                
                map[nextRow][nextCol] = 0
                visited[nextRow][nextCol] = false
            }
        }
    }
    
    func main() {
        guard let NM = readLine()?.inlineInteger else { return }
        
        N = NM[0]
        M = NM[1]
        
        map = [[Int]](repeating: [Int](), count: N)
        visited = [[Bool]](repeating: [Bool](repeating: false, count: M), count: N)
        
        for i in 0..<N {
            guard let row = readLine()?.inlineInteger else { return }
            map[i] = row
            for j in 0..<M {
                
                if map[i][j] == 0 {
                    emptySpaces.append(Position(i, j))
                }
                if map[i][j] == 2 {
                    viruses.append(Position(i, j))
                }
            }
        }
        
        go(0, 0, 0)
        
        print(result)
    }
}

Boj14502().main()

extension String {
    var inlineInteger: [Int] {
        return split(separator: " ").compactMap({Int(String($0))})
    }
}
