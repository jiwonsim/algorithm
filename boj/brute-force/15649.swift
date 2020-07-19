import Foundation

var N = Int(), M = Int()
var visited = [Bool]()
var array = [Int]()
var result = [Int]()

// 찾기
func search(index: Int, depth: Int) {
    if depth > M {
        for i in 1...M {
            print(result[i], terminator: " ")
        }
        print()
        return
    }
    
    for i in 1...N {
        if visited[i] { continue }
        
        visited[i] = true
        result[depth] = i
        search(index: i, depth: depth + 1)
        visited[i] = false
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").compactMap{ Int($0) }

    N = input[0]
    M = input[1]

    visited = [Bool](repeating: false, count: N + 1)
    array = [Int](1...N)

    result = [Int](repeating: 0, count: N + 1)
    search(index: 1, depth: 1)
}

solution()
