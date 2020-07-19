import Foundation

var N: Int = 0, M: Int = 0
var numbers = [Int](), visited = [Bool](), result = [Int]()

func search(_ index: Int, _ depth: Int) {
    if depth == M {
        for ele in result {
            print(ele, terminator: " ")
        }
        print()
        return
    }
    
    var before = -1
    for i in index..<numbers.count {
        if visited[i] { continue }
        if before == numbers[i] { continue }
        
        visited[i] = true
        before = numbers[i] // 같은 depth에 같은 수가 나오면 안 되니까 flag의 역할을 before가 대신한다.
        result[depth] = numbers[i]
        search(i+1, depth+1)
        visited[i] = false
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    N = input[0]
    M = input[1]
    numbers = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    numbers.sort()
    
    visited = [Bool](repeating: false, count: 10001)
    result = [Int](repeating: 0, count: M)
    
    search(0, 0)
}
solution()
