import Foundation

var N = 0, M = 0
var inputArray = [String]()
var array = [String]()
var visited = [Bool]()
var explorer = [String]()
var result = String()

func search(_ index: Int, _ depth: Int) {
    if depth == M {
        var temp = String()
        for i in 0..<M {
            temp.append("\(explorer[i]) ")
        }
        result.append("\(temp)\n")
        return
    }
    
    for i in 0..<array.count {
        explorer[depth] = array[i]
        search(i, depth+1)
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    N = input[0]
    M = input[1]
    
    explorer = [String](repeating: String(), count: N)
    visited = [Bool](repeating: false, count: N)
    
    array = readLine()!.split(separator: " ").map { String($0)}
    array.sort { (lhs, rhs) -> Bool in
        Int(lhs)! < Int(rhs)!
    }
    
    search(0, 0)
    print(result)
}

solution()
