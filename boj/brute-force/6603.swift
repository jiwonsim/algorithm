import Foundation

let chosenCnt = 6

func search(_ index: Int, _ depth: Int, _ numbers: [Int], _ result: inout [Int], _ visited: inout [Bool]) {
    if chosenCnt+1 == depth {
        result.printInline()
        return
    }
    
    for i in index..<numbers.count {
        if visited[i] { continue }
        
        visited[i] = true
        result[depth] = numbers[i]
        search(i+1, depth+1, numbers, &result, &visited)
        visited[i] = false
    }
}

while true {
    guard let numbers = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else {
        break
    }
    
    if numbers[0] == 0 { break }
    
    var result = [Int](repeating: 0, count: numbers.count+1)
    var visited = [Bool](repeating: false, count: numbers.count+1)
    
    search(1, 1, numbers, &result, &visited)
    print()
}

extension Array {
    func printInline() {
        for i in 1...chosenCnt {
            print(self[i], terminator: " ")
        }
        print()
    }
}
