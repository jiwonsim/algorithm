import Foundation

var N = 0, M = 0
var inputArray = [String]()
var array = [Int]()
var results = [Int]()
var result = String()

func search(_ index: Int, _ depth: Int) {
    if depth == M {
        var temp = String()
        for i in 0..<M {
            temp.append("\(results[i]) ")
        }
        result.append("\(temp)\n")
        return
    }
    
    for i in (index)..<array.count {
        results[depth] = array[i]
        search(i, depth+1)
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    N = input[0]
    M = input[1]
    
    results = [Int](repeating: 0, count: N)
    array = readLine()!.split(separator: " ").map { Int(String($0))! }
    array.sort()
    
    search(0, 0)
    print(result)
}

solution()
