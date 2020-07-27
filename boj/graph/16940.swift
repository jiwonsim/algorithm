import Foundation

guard let inputOfN = readLine() else { exit(0) }
guard let N = Int(inputOfN) else { exit(0) }

var map = [[Int]](repeating: [Int](), count: N+1)

for _ in 0..<N-1 {
    guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }
    
    map[input[0]].append(input[1])
    map[input[1]].append(input[0])
}

guard let target = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }

print(search() ? "1" : "0")

func search() -> Bool {
    
    var que = [Int]()
    var visited = [Bool](repeating: false, count: N+1)
    var parent = [Int](repeating: 0, count: N+1)
    
    que.append(1)
    visited[1] = true
    
    var index = 2
    for _ in 0..<N {
        let cur = que.removeFirst()
        
        var count = 0
        for element in map[cur] {
            if visited[element] { continue }
            parent[element] = cur
            count+=1
        }
        
        for i in index..<index+count {
            if i >= N+1 || parent[target[i-1]] != cur { return false }
            que.append(target[i-1])
            visited[target[i-1]] = true
        }
        
        index+=count
    }
    
    return true
}
