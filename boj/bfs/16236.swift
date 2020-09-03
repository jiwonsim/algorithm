import Foundation

class Boj16236 {
    
    struct Pair {
        var r: Int, c: Int, t: Int
        init(_ r: Int, _ c: Int, _ t: Int) {
            self.r = r
            self.c = c
            self.t = t
        }
    }
    
    private let dirs = [[1, 0], [0, -1],
                [0, 1], [-1, 0]]
    
    private var N = Int()
    private var map = [[Int]]()
    
    private func go(_ r: Int, _ c: Int, _ size: Int) -> Pair {
        // 잡아먹을 물고기를 탐색하는 함수 내에서 상어의 크기는 일정하다.
        // 자신보다 작은 물고기를 찾아서 먹는다. -> 먹으면 탐색 끝, 현재 위치와 시간 출력
        // 자신과 같은 사이즈의 물고기는 지나가고 먹지는 않는다.
        
        var que = [Pair]()
        var visited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: N)
        var head = 0
        
        // "가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다."라는 조건으로
        // 현재 위치와 사이즈로 먹을 수 있는 물고기를 모두 저장한 후 정렬하여 반환한다.
        var eaten = [Pair]()
        
        que.append(Pair(r, c, 0))
        visited[r][c] = true
        
        while head < que.count {
            let cur = que[head]
            head+=1
            
            for dir in dirs {
                let nr = cur.r + dir[0]
                let nc = cur.c + dir[1]
                
                if nr < 0 || nc < 0 || nr >= N || nc >= N { continue }
                if visited[nr][nc] { continue }
                if map[nr][nc] > size { continue } // 나보다 크면 패쓰
                
                visited[nr][nc] = true
                que.append(Pair(nr, nc, cur.t+1))
                if map[nr][nc] != 0 && map[nr][nc] < size {
                    eaten.append(Pair(nr, nc, cur.t+1))
                }
            }
        }
        
        if eaten.count == 0 { return Pair(-1, -1, -1) }
        // c보다 r이, r, c보다 t가 더 우선적으로 정렬해야 되기 때문에 sorted()를 각각 붙인다.
        return eaten.sorted(by: {$0.c < $1.c}).sorted(by: {$0.r < $1.r}).sorted(by: {$0.t < $1.t})[0]
    }
    
    func main() {
        guard let inputN = readLine() else { return }
        N = Int(inputN) ?? 0
        map = [[Int]](repeating: [Int](repeating: 0, count: N), count: N)
        
        var s = Pair(0, 0, 0)
        
        for i in 0..<N {
            guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
            
            for j in 0..<N {
                map[i][j] = input[j]
                if map[i][j] == 9 {
                    s.r = i
                    s.c = j
                    map[i][j] = 0
                }
            }
        }
        
        var result = 0
        var size = 2, sum = 0
        for _ in 0...20*20 {
            let eaten = go(s.r, s.c, size)
            let r = eaten.r, c = eaten.c, t = eaten.t
            
            if t == -1 { // 더이상 탐색할 수 없다.
                break
            }
            
            // 탐색이 성공했다면
            // 맵과 상어의 위치, 결과값을 갱신
            map[r][c] = 0
            s.r = r
            s.c = c
            result += t
            sum += 1 // 한마리를 먹음
            
            if sum == size { // 내 사이즈만큼 먹었으면, 내 사이즈가 1 증가한다.
                size += 1
                sum = 0
            }
        }
        
        print(result)
        
    }
}

Boj16236().main()
