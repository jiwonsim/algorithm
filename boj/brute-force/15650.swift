import Foundation

var N = Int(), M = Int()
var visited = [Bool]()
var array = [Int]()
var result = [Int]()

func search(index: Int, depth: Int) {
    if depth > M {
        for i in 1...M {
            print("\(result[i])", terminator: " ")
        }
        print()
        return
    }
    
    
    for i in stride(from: index + 1, through: N, by: 1) {
        if visited[i] { continue }

        visited[i] = true
        result[depth] = i
        search(index: i, depth: depth + 1)
        visited[i] = false
    }
}


func solution() {
    let input = readLine()!.split(separator: " ").compactMap { Int($0) }
    
    N = input[0]
    M = input[1]

    array = [Int](1...input[0])
    visited = [Bool](repeating: false, count: input[0] + 1)
    result = [Int](repeating: 0, count: input[0] + 1)

    search(index: 0, depth: 1)
}

solution()
