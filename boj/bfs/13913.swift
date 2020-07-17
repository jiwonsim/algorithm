import Foundation

let maxSize = 100000

var N = 0, M = 0

func search() {
    var que = [Int]()
    var time = [Int](repeating: 0, count: maxSize*2)
    var route = [Int](repeating: 0, count: maxSize*2)
    
    que.append(N)
    time[N] = 1
    route[N] = N
    
    var first = 0
    
    while (que.count > 0) {
        let cur = que[first]

        first += 1
        
        if cur == M {
            print(time[cur]-1)
            break
        }
        
        if cur-1 >= 0 && time[cur-1] == 0 {
            route[cur-1] = cur
            time[cur-1] = time[cur]+1
            que.append(cur-1)
        }
        if cur+1 <= maxSize && time[cur+1] == 0 {
            route[cur+1] = cur
            time[cur+1] = time[cur]+1
            que.append(cur+1)
        }
        if cur*2 <= maxSize && time[cur*2] == 0 {
            route[cur*2] = cur
            time[cur*2] = time[cur]+1
            que.append(cur*2)
        }
    }
    
    var tracking = M
    
    var result = [Int]()
    while tracking != N {
        result.append(tracking)
        tracking = route[tracking]
    }
    result.append(N)
    
    for ele in result.reversed() {
        print(ele, terminator: " ")
    }
}

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    N = input[0]
    M = input[1]
    
    search()
}

solution()
