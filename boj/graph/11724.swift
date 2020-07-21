import Foundation

var map = [[Int]](repeating: [Int](), count: 1001)
var visited = [Bool](repeating: false, count: 1001)

func search(_ number: Int) {
    
    visited[number] = true
    
    for ele in map[number] {
        if visited[ele] { continue }
        search(ele)
    }
}

if let input = readLine()?.split(separator: " ").compactMap({ Int(String($0)) }) {
    
    // initialize & input
    let N = input[0]
    let M = input[1]
    
    for _ in 0..<M {
        guard let connected = readLine()?.split(separator: " ").compactMap({ Int(String($0)) }) else { exit(0) }
        map[connected[0]].append(connected[1])
        map[connected[1]].append(connected[0])
    }
    
    var result = 0
    
    for i in 1...N {
        if visited[i] { continue }
        search(i)
        result+=1
    }
    
    print(result)
    
}
