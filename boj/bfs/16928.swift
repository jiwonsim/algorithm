import Foundation

class Boj16928 {
    private var map = [Int](0...100)
    
    struct Point {
        var position: Int, count: Int
        
        init(_ position: Int, _ count: Int) {
            self.position = position
            self.count = count
        }
    }
    
    func go() -> Int {
        var que = [Point]()
        var visited = [Bool](repeating: false, count: 100+1)
        
        que.append(Point(1, 0))
        visited[1] = true
        
        var head = 0
        
        while head < que.count {
            let current = que[head]
            head+=1
            
            if current.position == 100 {
                return current.count
            }
            
            for number in 1...6 {
                var next = current.position + number
                if next > 100 { continue }
                if map[next] != next {
                    next = map[next]
                }
                if visited[next] { continue }
                
                visited[next] = true
                que.append(Point(next, current.count+1))
            }
        }
        return 0
    }
    
    func main() {
        guard let NM = readLine()?.inlineInteger else { return }
        
        let N = NM[0], M = NM[1]
        
        for _ in 0..<N {
            guard let ladder = readLine()?.inlineInteger else { return }
            let x = ladder[0], y = ladder[1]
            map[x] = y
        }
        
        for _ in 0..<M {
            guard let snake = readLine()?.inlineInteger else { return }
            let u = snake[0], v = snake[1]
            map[u] = v
        }
        
        print(go())
    }
}

Boj16928().main()

extension String {
    var inlineInteger: [Int] {
        return split(separator: " ").compactMap({Int(String($0))})
    }
}
