import Foundation

struct Pos {
    var row: Int, col: Int
    var cnt: Int
    
    init(_ row: Int, _ col: Int) {
        self.row = row
        self.col = col
        self.cnt = 0
    }
    
    init(_ row: Int, _ col: Int, _ cnt: Int) {
        self.row = row
        self.col = col
        self.cnt = cnt
    }
}

guard let inputOfN = readLine() else { exit(0) }
guard let N = Int(inputOfN) else { exit(0) }

var map = [[Int]](repeating: [Int](repeating: 0, count: N), count: N) // 입력 맵
var coloredMap = [[Int]](repeating: [Int](repeating: 0, count: N), count: N) // 섬 판별 맵
var mapOfLength = [[Int]](repeating: [Int](repeating: 0, count: N), count: N) // 다리 길이 맵

var result = Int.max // 결과 값

for i in 0..<N {
    guard let inputOfRow = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }
    for j in 0..<N {
        map[i][j] = inputOfRow[j]
    }
}


var color = 0
for i in 0..<N {
    for j in 0..<N {
        if map[i][j] == 1 && coloredMap[i][j] == 0 {
            color += 1
            allocateToLand(i, j, color)
        }
    }
}
search()
print(result)

let toward = [[1, 0], [-1, 0], [0, 1], [0, -1]]
func isInRange(_ row: Int, _ col: Int, _ N: Int) -> Bool {
    if row < 0 || col < 0 || row >= N || col >= N { return false }
    return true
}


func allocateToLand(_ row: Int, _ col: Int, _ color: Int) {
    var que = [Pos]()
    que.append(Pos(row, col))
    coloredMap[row][col] = color
    
    while !que.isEmpty {
        let cur = que.removeFirst()
        
        for i in 0..<4 {
            let nextRow = toward[i][0] + cur.row
            let nextCol = toward[i][1] + cur.col
            
            if !isInRange(nextRow, nextCol, N) { continue }
            if map[nextRow][nextCol] == 0 { continue }
            if coloredMap[nextRow][nextCol] == color { continue }
            
            coloredMap[nextRow][nextCol] = color
            que.append(Pos(nextRow, nextCol))
        }
    }
}

func search() {
    
    var que = [Pos]()
    var visited = [[Bool]](repeating: [Bool](repeating: false, count: N), count: N)
    
    for i in 0..<N {
        for j in 0..<N {
            if coloredMap[i][j] > 0 {
                que.append(Pos(i, j, 0))
                visited[i][j] = true
            }
        }
    }
    
    while !que.isEmpty {
        let cur = que.removeFirst()
        for i in 0..<4 {
            let nextRow = cur.row + toward[i][0]
            let nextCol = cur.col + toward[i][1]
            
            if !isInRange(nextRow, nextCol, N) { continue }
            if coloredMap[nextRow][nextCol] > 0 { // 이미 방문했던 곳을 만남
                if coloredMap[nextRow][nextCol] == coloredMap[cur.row][cur.col] { // 내 섬이면, 패스
                    continue
                }
                else { // 내 섬이 아니면 다른 섬에서 오는 다리를 만난 거니까 출력하고 끝냄
                    result = min(result, mapOfLength[cur.row][cur.col] + mapOfLength[nextRow][nextCol])
                }
            }
            else {
                // 새롭게 방문한 곳이라면 큐에 값을 넣고 다리 연결하기
                que.append(Pos(nextRow, nextCol, cur.cnt+1))
                coloredMap[nextRow][nextCol] = coloredMap[cur.row][cur.col]
                mapOfLength[nextRow][nextCol] = mapOfLength[cur.row][cur.col]+1
            }
        }
        
    }
}
