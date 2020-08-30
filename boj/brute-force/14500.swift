import Foundation

class Boj14500 {
    
    private var N = Int(), M = Int()
    private var costMap = [[Int]]()
    private var totalSum = 0
    private var visited = [[Bool]]()
    
    private var directions = [[0, 1], [0, -1],
                                    [1, 0], [-1, 0]]
    
    private func go(_ y: Int, _ x: Int, _ sum: Int, _ count: Int) {
        if count == 4 {
            totalSum = max(totalSum, sum)
            return
        }
        
        if y < 0 || x < 0 || y >= N || x >= M { return }
        if visited[y][x] { return }
        
        visited[y][x] = true
        for direction in directions {
            go(y+direction[0], x+direction[1], sum+costMap[y][x], count+1)
        }
        visited[y][x] = false
    }
    
    func main() {
        guard let NM = readLine()?.inlineInteger else { return }
        
        N = NM[0]
        M = NM[1]
        
        costMap = [[Int]](repeating: [Int](), count: N)
        for i in 0..<N {
            guard let input = readLine()?.inlineInteger else { return }
            costMap[i] = input
        }
        
        visited = [[Bool]](repeating: [Bool](repeating: false, count: M), count: N)
        
        for y in 0..<N {
            for x in 0..<M {
                go(y, x, 0, 0)
                
                if x+2 < M {
                    var sum = 0
                    sum += costMap[y][x]+costMap[y][x+1]+costMap[y][x+2]
                    if y-1 >= 0 {
                        totalSum=max(totalSum, sum+costMap[y-1][x+1])
                    }
                    if y+1 < N {
                        totalSum=max(totalSum, sum+costMap[y+1][x+1])
                    }
                }
                if y+2 < N {
                    var sum = 0
                    sum += costMap[y][x]+costMap[y+1][x]+costMap[y+2][x]
                    if x+1 < M {
                        totalSum=max(totalSum, sum+costMap[y+1][x+1])
                    }
                    if x-1 >= 0 {
                        totalSum=max(totalSum, sum+costMap[y+1][x-1])
                    }
                }
            }
        }
        
        print(totalSum)
    }
}

Boj14500().main()

extension String {
    var inlineInteger: [Int] {
        return self.split(separator: " ").compactMap({Int(String($0))})
    }
}
