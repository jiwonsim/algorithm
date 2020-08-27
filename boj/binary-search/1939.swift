import Foundation

class Boj1939 {
    private var N = Int()
    private var M = Int()
    private var map = [[Edge]]()
    private var factoryLocations = [Int]()
    private var visited = [Bool]()
    
    func dfs(_ index: Int, _ limit: Int) -> Bool {
        if visited[index] { return false }
        if index == factoryLocations[1] {
            // 찾음!
            return true
        }
        
        visited[index] = true
        
        for element in map[index] {
            if element.cost >= limit {
                // 그 다음으로 탐색
                if dfs(element.node, limit) {
                    return true
                }
            }
        }
        
        return false
    }
    
    func main() {
        guard let nm = readLine()?
            .split(separator: " ").compactMap({Int(String($0))})
            else { return }
        
        N = nm[0] // number of lands
        M = nm[1] // number of land's information
        
        map = [[Edge]](repeating: [Edge](), count: N+1)
        visited = [Bool](repeating: false, count: N+1)
        
        var maxCost = 0
        for _ in 0..<M {
            guard let input = readLine()?
                .split(separator: " ").compactMap({Int(String($0))})
                else { return }
            
            let A = input[0]
            let B = input[1]
            let C = input[2] // weight limit
            
            map[A].append(Edge(B, C))
            map[B].append(Edge(A, C))
            maxCost = max(maxCost, C)
        }
        
        var start = 0
        var end = maxCost
        
        
        guard let fatoryLocations = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        factoryLocations = fatoryLocations
        
        var result = 0
        while start <= end {
            let mid = (start+end)/2
            
            visited = [Bool](repeating: false, count: N+1)
            
            if dfs(factoryLocations[0], mid) {
                start = mid+1
                result = mid
            }
            else { end = mid-1 }
        }
        
        print(result)
    }
    
    private struct Edge {
        var node: Int
        var cost: Int
        
        init(_ node: Int, _ cost: Int) {
            self.node = node
            self.cost = cost
        }
        
        init() {
            node = Int()
            cost = Int()
        }
    }
}

Boj1939().main()
