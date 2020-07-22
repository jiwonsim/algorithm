import Foundation

var N = Int()
var time = [Int](), cost = [Int]()

var result = 0

func search(_ index: Int, _ sum: Int) {
    result = max(result, sum)
    
    for i in index..<N {
        if i+time[i] > N { continue }
        search(i+time[i], sum+cost[i])
    }
}

if let input = readLine() {
    N = Int(input)!
    
    time = [Int](repeating: 0, count: N+1)
    cost = [Int](repeating: 0, count: N+1)
    
    for i in 0..<N {
        guard let counsel = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { exit(0) }
        
        time[i] = counsel[0]
        cost[i] = counsel[1]
    }
    
    search(0, 0)
    
    print(result)
}
