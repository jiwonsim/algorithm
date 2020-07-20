import Foundation

var M = Int(), N = Int()
var map = [[Int]]()
var toward = [[1, 0], [-1, 0], [0, 1], [0, -1]]

struct Position {
    var r: Int, c: Int, b: Int
    
    init(_ row: Int, _ col: Int, _ broken: Int) {
        r = row
        c = col
        b = broken
    }
}

func search() {
    var que = [Position]()
    var visited = [[Bool]](repeating: [Bool](repeating: false, count: M), count: N)
    
    que.append(Position(0, 0, 0))
    visited[0][0] = true
    
    while !que.isEmpty {
        let cur = que.removeFirst()
        
        if cur.r == N-1 && cur.c == M-1 {
            print(cur.b)
            return
        }
        
        for i in 0..<4 {
            let nextR = cur.r + toward[i][0]
            let nextC = cur.c + toward[i][1]
            
            if nextR < 0 || nextC < 0 || nextR >= N || nextC >= M { continue }
            if visited[nextR][nextC] { continue }
            
            visited[nextR][nextC] = true
            if map[nextR][nextC] == 1 {
                que.append(Position(nextR, nextC, cur.b+1))
            }
            else {
                que.insert(Position(nextR, nextC, cur.b), at: 0)
            }
        }
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").compactMap { Int(String($0)) }

    M = input[0]
    N = input[1]
    
    map = [[Int]](repeating: [Int](), count: N)
    for i in 0..<N {
        let inputOfRow = readLine()!
        let arrayOfRow = Array(inputOfRow)
        let row = arrayOfRow.map { Int(String($0))! }
        map[i] = row
    }
    
    search()
}

solution()

