import Foundation

var N = 0, M = 0
var array = [Int]()
var results = [Int]()
var result = String()

func search(_ index: Int, _ depth: Int) {
    if depth == M {
        var temp = String()
        for ele in results {
            temp.append("\(ele) ")
        }
        result.append("\(temp)\n")
        return
    }
    
    for i in index..<array.count {
        results[depth] = i
        search(i, depth + 1)
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    N = input[0]
    M = input[1]
    
    array = [Int](0...N)
    results = [Int](repeating: 0, count: M)
    
    search(1, 0)
    
    print(result)
}

solution()
