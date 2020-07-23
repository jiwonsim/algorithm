import Foundation

let toward = [[0, 1], [0, -1], [1, 0], [-1, 0]]

var N = Int(), M = Int()
var map = [[String]]()
var visited = [[Bool]]()

struct Position: Equatable {
    var row: Int, col: Int
    
    init(_ row: Int, _ col: Int) {
        self.row = row
        self.col = col
    }
    
    static func == (lhs: Position, rhs: Position) -> Bool {
        return lhs.row == rhs.row && lhs.col == rhs.col
    }
}

func search(_ current: Position, _ length: Int, _ start: Position) {
    if current == start && length >= 4 {
        print("Yes")
        exit(0)
    }
    
    if visited[current.row][current.col] { return }
    visited[current.row][current.col] = true

    for i in 0..<toward.count {
        let nextRow = current.row + toward[i][0]
        let nextCol = current.col + toward[i][1]
        
        if nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M { continue }
        if map[nextRow][nextCol] != map[current.row][current.col] { continue }
        
        search(Position(nextRow, nextCol), length+1, start)
    }
    
    visited[current.row][current.col] = false
}

func main() {
    guard let input = readLine()?.split(separator: " ").compactMap({ Int(String($0)) }) else {
        print("error of reading input")
        return
    }
    
    N = input[0]
    M = input[1]
    
    map = [[String]](repeating: [String](repeating: String(), count: M), count: N)
    visited = [[Bool]](repeating: [Bool](repeating: false, count: M), count: N)
    
    for i in 0..<N {
        guard let row = readLine()?.compactMap({String($0)}) else {
            print("error of reading row")
            return
        }
        for j in 0..<M {
            map[i][j] = row[j]
        }
    }
    
    for i in 0..<N-1 {
        for j in 0..<M-1 {
            search(Position(i, j), 0, Position(i, j))
        }
    }
    print("No")
}


main()
