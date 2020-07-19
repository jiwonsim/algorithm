import Foundation

var N = 0, M = 0
var array = [Int]()
var visited = [Bool]()
var results = [Int]()
var result = String()

func search(_ depth: Int) {
    if depth == M {
        for i in 0..<M {
            result.append("\(results[i]) ")
        }
        result.append("\n")
        return
    }
    
    for i in 0..<array.count {
        if visited[i] { continue }
        visited[i] = true
        results[depth] = array[i]
        search(depth+1)
        visited[i] = false
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    N = input[0]
    M = input[1]
    
    results = [Int](repeating: 0, count: N)
    visited = [Bool](repeating: false, count: N)
    array = readLine()!.split(separator: " ").map { Int(String($0))! }
    array.sort()
    
    search(0)
    
    print(result)
}

solution()
