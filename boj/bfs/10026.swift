import Foundation

class Boj10026 {
    private struct Pair {
        var r: Int, c: Int
        init(_ r: Int, _ c: Int) {
            self.r = r
            self.c = c
        }
    }
    
    private let dirs = [[0, 1], [0, -1],
                        [1, 0], [-1, 0]]
    
    private var N = Int()
    private var map = [[Character]]()
    
    private func possibe(_ weakness: Bool, _ cur: Pair, _ next: Pair) -> Bool {
        if map[cur.r][cur.c] == map[next.r][next.c] { return true }
        if weakness {
            if map[cur.r][cur.c] == "R" && map[next.r][next.c] == "G" { return true }
            if map[cur.r][cur.c] == "G" && map[next.r][next.c] == "R" { return true }
        }
        return false
    }
    
    private func go(_ weakness: Bool = false) -> Int {
        var sum = 0
        var visited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: N)
        
        for i in 0..<N {
            for j in 0..<N {
                if visited[i][j] { continue }
                sum += 1
                
                var que = [Pair](), head = 0
                que.append(Pair(i, j))
                visited[i][j] = true
                
                while head < que.count {
                    let cur = que[head]
                    head+=1
                    
                    for dir in dirs {
                        let nr = dir[0]+cur.r
                        let nc = dir[1]+cur.c
                        
                        if nr < 0 || nc < 0 || nr >= N || nc >= N { continue }
                        if visited[nr][nc] { continue }
                        if !possibe(weakness, cur, Pair(nr, nc)) { continue }
                        
                        visited[nr][nc] = true
                        que.append(Pair(nr, nc))
                    }
                }
            }
        }
        return sum
    }
    
    func main() {
        guard let inputN = readLine() else { return }
        N = Int(inputN) ?? 0
        map = [[Character]](repeating: [Character](), count: N)
        
        for i in 0..<N {
            guard let input = readLine() else { return }
            map[i] = Array(input)
        }
        
        print(go(), go(true))
    }
}


Boj10026().main()
