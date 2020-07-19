import Foundation

var N = 0, M = 0
var array = [Int]()
var visited = [Bool]()
var results = [Int]()
var result = String()

func search(_ depth: Int) {
    if depth == M {
        var temp = String() // result에 append를 하게 되면 시간초과가 난다.
        for ele in results {
            temp.append("\(ele) ")
        }
        result.append("\(temp)\n")
        return
    }
    
    for i in array {
        results[depth] = i
        search(depth + 1)
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    N = input[0]
    M = input[1]
    
    array = [Int](1...N)
    visited = [Bool](repeating: false, count: N + 1)
    results = [Int](repeating: 0, count: M)
    
    for i in array {
        results[0] = i
        search(1)
    }
    
    print(result)
}

solution()
