import Foundation

class Boj16954 {
    
    struct Position {
        var row: Int, col: Int, time: Int
        init(_ row: Int, _ col: Int, _ time: Int ) {
            self.row = row
            self.col = col
            self.time = time
        }
    }
    
    let directions = [[-1, -1], [-1, 0], [-1, +1],
                      [0, -1], [0, 0], [0, +1],
                      [+1, -1], [+1, 0], [+1, +1]]
    
    var map = [[Int]](repeating: [Int](repeating: 0, count: 8), count: 8)
    
    func go() -> Int {
        var que = [Position]() // 욱제 is here
        var head = 0
        que.append(Position(7, 0, 0))
        
        var visited = [[[Bool]]](repeating: [[Bool]](repeating: [Bool](repeating: false, count: 8+1), count: 8), count: 8)
        
        while head < que.count {
            let cur = que[head]
            head += 1
            
            if cur.time == 8 || (cur.row == 0 && cur.col == 7) { return 1 }
            
            for dir in directions {
                let nr = dir[0]+cur.row
                let nc = dir[1]+cur.col
                let nt = cur.time+1
                
                if nr < 0 || nc < 0 || nr >= 8 || nc >= 8 { continue }
                if nr-cur.time >= 0 && map[nr-cur.time][nc] == 1 { continue }
                if nr-cur.time-1 >= 0 && map[nr-cur.time-1][nc] == 1 { continue }
                if visited[nr][nc][nt] { continue }
                visited[nr][nc][nt] = true
                que.append(Position(nr, nc, nt))
            }
        }
        
        return 0
    }
    
    func main() {
        for i in 0..<8 {
            guard let input = readLine() else { return }
            let array = Array(input)
            for j in 0..<8 {
                if array[j] == "#" {
                    map[i][j] = 1
                }
            }
        }
        print(go())
    }
}

Boj16954().main()
