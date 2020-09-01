import Foundation

class Boj16948 {
    
    private let directions = [[-2, -1], [-2, +1], [0, -2],
                              [0, +2], [+2, -1], [+2, +1]]
    
    var N = Int()
    
    struct Position {
        var row: Int, col: Int, count: Int
        init(_ row: Int, _ col: Int, _ count: Int = 0) {
            self.row = row
            self.col = col
            self.count = count
        }
    }
    
    func go(_ start: Position, _ end: Position) -> Int {
        var que = [Position]()
        var head = 0
        var visited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: N)
        
        que.append(start)
        visited[que[head].row][que[head].col] = true
        
        while head < que.count {
            let current = que[head]
            head += 1
            
            if current.row == end.row && current.col == end.col {
                return current.count
            }
            
            for direction in directions {
                let next = Position(current.row + direction[0], current.col + direction[1], current.count+1)
                
                if next.row < 0 || next.row >= N || next.col < 0 || next.col >= N { continue }
                if visited[next.row][next.col] { continue }
                
                visited[next.row][next.col] = true
                que.append(next)
            }
        }
        return -1
    }
    
    func main() {
        guard let inputN = readLine(),
            let positions = readLine()?.split(separator: " ").compactMap({Int(String($0))})
            else { return }
        
        N = Int(inputN) ?? 0
        let start = Position(positions[0], positions[1])
        let end = Position(positions[2], positions[3])
        
        print(go(start, end))
        
    }
}

Boj16948().main()
