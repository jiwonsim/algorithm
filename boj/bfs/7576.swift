import Foundation

struct Position {
    var y: Int, x: Int, time: Int
    
    init(_ y: Int, _ x: Int, _ time: Int) {
        self.y = y
        self.x = x
        self.time = time
    }
}

let toward = [[0, 1], [0, -1], [1, 0], [-1, 0]]

func bfs() -> Bool {
    var que = [Position]()
    var visited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: M)
    
    for tomato in tomatos {
        que.append(tomato)
        visited[tomato.y][tomato.x] = true
    }
    
    var head = 0
    while que.count > head {
        let cur = que[head] // que에서 removeFirst() 하는 방식으로는 시간초과가 난다. head를 이용!
        head+=1
        empty-=1
        
        if empty == 0 {
            print("\(cur.time)")
            return true
        }
        
        for i in 0..<4 {
            let nextY = cur.y + toward[i][0]
            let nextX = cur.x + toward[i][1]
            
            if nextX < 0 || nextY < 0 || nextX >= N || nextY >= M { continue }
            if visited[nextY][nextX] { continue }
            if map[nextY][nextX] == -1 { continue }
            
            visited[nextY][nextX] = true
            que.append(Position(nextY, nextX, cur.time+1))
        }
    }
    
    return false
}

guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }

var N = input[0], M = input[1]

var map = [[Int]](repeating: [Int](repeating: 0, count: N), count: M)
var tomatos = [Position]()

var empty = N*M

for i in 0..<M {
    guard let row = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }
    for j in 0..<N {
        map[i][j] = row[j]
        if map[i][j] == 1 {
            tomatos.append(Position(i, j, 0))
        }
        if map[i][j] == -1 { empty -= 1 }
    }
}

if empty == 0 { print("0") } // 전체가 -1인 경우가 있기 때문에
if !bfs() { print("-1") }
