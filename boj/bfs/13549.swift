import Foundation

var N = Int(), M = Int()

func solution() {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    
    N = input[0]
    M = input[1]
    
    var time = [Int](repeating: 0, count: 100001)
    var que = [Int]()
    
    time[N] = 1
    que.append(N)
    
    while !que.isEmpty {
        let cur = que.removeFirst()
        
        if cur == M {
            print(time[cur]-1)
            return
        }
        
        // 1 2를 입력 받았을 때 1*2가 1+1보다 더 우선적으로 방문체크 되어야 하기 때문에 *2를 먼저 검사한다.
        if cur*2 <= 100000 && time[cur*2] == 0 {
            time[cur*2] = time[cur]
            que.insert(cur*2, at: 0)
        }
        if cur-1 >= 0 && time[cur-1] == 0 {
            time[cur-1] = time[cur]+1
            que.append(cur-1)
        }
        if cur+1 <= 100000 && time[cur+1] == 0 {
            time[cur+1] = time[cur]+1
            que.append(cur+1)
        }
    }
    
}

solution()

