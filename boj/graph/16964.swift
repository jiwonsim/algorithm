import Foundation

guard let inputOfN = readLine() else { exit(0) }
guard let N = Int(inputOfN) else { exit(0) }

var map = [[Int]](repeating: [Int](), count: N+1)
var cost = [Int](repeating: 0, count: N+1)
var result = [Int]()
var visited = [Bool](repeating: false, count: N+1)

for _ in 0..<N-1 {
    guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }
    
    map[input[0]].append(input[1])
    map[input[1]].append(input[0])
}

guard let target = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }

// 가중치 할당
for i in 0..<N {
    cost[target[i]] = i
}

// 가중치를 기준으로 정렬
for i in 1...N {
    map[i].sort { (lhs, rhs) -> Bool in
        return cost[lhs] < cost[rhs]
    }
}

search(1)
for i in 0..<N {
    if result[i] != target[i] {
        print("0")
        exit(0)
    }
}
print("1")


func search(_ number: Int) {
    if visited[number] { return }
    
    visited[number] = true
    result.append(number)
    for element in map[number] {
        search(element)
    }
}
