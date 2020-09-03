import Foundation

class Boj1963 {
    
    var prime = [Bool](repeating: true, count: 10000)
    
    func eratosthenes() {
        for i in 2..<prime.count {
            if !prime[i] { continue }
            for j in sequence(first: i+i, next: {$0+i}).prefix(while: {$0 < prime.count}) {
                prime[j] = false
            }
        }
        
//        for (i, v) in prime.enumerated() {
//            print(i, v)
//        }
    }
    
    func find(_ A: Int, _ B: Int) -> Int {
        var que = [Int](), head = 0
        var visited = [Int](repeating: -1, count: 10000)
        
        que.append(A)
        visited[A] = 0
        
        while head < que.count {
            let cur = que[head]
            head+=1
            
            if cur == B {
                // 찾았다!
                return visited[B]
            }
            
//            print(cur)
            
            // 천의 자리 탐색
            for i in 1...9 {
                let next = i*1000 + (cur%1000)
                
//                print(next)
                
                if visited[next] != -1 { continue }
                if !prime[next] { continue }
                
                visited[next] = visited[cur]+1
                que.append(next)
            }
//            print()
            // 백의 자리 탐색
            for i in 0...9 {
                let next = i*100 + cur-((cur/100)%10)*100
                
//                print(next)
                
                if visited[next] != -1 { continue }
                if !prime[next] { continue }
                
                visited[next] = visited[cur]+1
                que.append(next)
            }
//            print()
            // 십의 자리 탐색
            for i in 0...9 {
                let next = i*10 + cur-((cur/10)%10)*10
                
//                print(next)
                
                if visited[next] != -1 { continue }
                if !prime[next] { continue }
                
                visited[next] = visited[cur]+1
                que.append(next)
            }
//            print()
            // 일의 자리 탐색
            for i in 0...9 {
                let next = i + cur-(cur%10)
                
//                print(next)
                
                if visited[next] != -1 { continue }
                if !prime[next] { continue }
                
                visited[next] = visited[cur]+1
                que.append(next)
            }
        }
        return -1
    }
    
    func main() {
        guard let inputT = readLine() else { return }
        
        var T = Int(inputT) ?? 0
        
        eratosthenes()
        while T > 0 {
            T-=1
            
            guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
            
            let A = input[0]
            let B = input[1]
            let result = find(A, B)
            print(result == -1 ? "Impossible" : result)
            
        }
    }
}

Boj1963().main()
