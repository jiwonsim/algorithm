import Foundation

class Boj3055 {
    
    struct Position {
        let r: Int, c: Int, t: Int
        
        init(_ r: Int = -1, _ c: Int = -1, _ t: Int = -1) {
            self.r = r
            self.c = c
            self.t = t
        }
    }
    
    var R = Int(), C = Int()
    var map = [[String]]()
    var waters = [Position]()
    var waterMap = [[Int]]()
    var start = Position(), end = Position()
    
    let directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    
    func isNotInRange(_ r: Int, _ c: Int) -> Bool {
        return r < 0 || c < 0 || r >= R || c >= C
    }
    
    func waterTimer() {
        // 몇 초에 물이 다 찼는지를 표시
        
        waterMap = [[Int]](repeating: [Int](repeating: -1, count: C), count: R)
        
        var que = [Position](), head = 0
        
        for water in waters {
            que.append(water)
            waterMap[water.r][water.c] = 0 // 1초부터 시작
        }
        
        while head < que.count {
            let cur = que[head]
            head+=1
            
            for direction in directions {
                let nr = direction[0]+cur.r
                let nc = direction[1]+cur.c
                let nt = cur.t+1
                
                if isNotInRange(nr, nc) { continue }
                if waterMap[nr][nc] != -1 { continue }
                if map[nr][nc] == "D" || map[nr][nc] == "X" { continue }
                
                waterMap[nr][nc] = nt
                que.append(Position(nr, nc, nt))
            }
        }
    }
    
    func go() -> Bool {
        var que = [Position](), head = 0
        var visited = [[Bool]](repeating: [Bool](repeating: false, count: C), count: R)
        
        que.append(start)
        visited[start.r][start.c] = true
        
        while head < que.count {
            let cur = que[head]
            head += 1
            
            if map[cur.r][cur.c] == "D" {
                print(cur.t)
                return true
            }
            
            for direction in directions {
                let nr = direction[0]+cur.r
                let nc = direction[1]+cur.c
                let nt = cur.t+1
                
                if isNotInRange(nr, nc) { continue }
                if map[nr][nc] == "X" || visited[nr][nc] { continue }
                if waterMap[nr][nc] >= 0 && waterMap[nr][nc] <= nt { continue }
                
                visited[nr][nc] = true
                que.append(Position(nr, nc, nt))
            }
        }
        
        return false
    }
    
    func main() {
        guard let RC = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        R = RC[0]
        C = RC[1]
        
        map = [[String]](repeating: [String](), count: R)
        
        for i in 0..<R {
            guard let input = readLine() else { return }
            map[i] = Array(input).compactMap{String($0)}
            for j in 0..<C {
                if map[i][j] == "D" { end = Position(i, j, 0) }
                if map[i][j] == "S" { start = Position(i, j, 0) }
                if map[i][j] == "*" { waters.append(Position(i, j, 0)) }
            }
        }
        
        waterTimer()
        if !go() { print("KAKTUS") }
    }
}

Boj3055().main()
