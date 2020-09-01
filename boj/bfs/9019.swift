import Foundation

class Boj9019 {
    
    private let size = 10000
    private var opperations = [String](), track = [Int]()
    
    func find(_ B: Int, _ A: Int) {
        var index = B
        var result = String()
        
        // 재귀를 이용하면 시간 초과가 난다. 재귀는 최대한 사용하지 않는다. 
        while index != A {
            result.append(opperations[index])
            index = track[index]
        }
        
        print(String(result.reversed()))
        return
    }
    
    func go(_ A: Int, _ B: Int) {
        var que = [Int]()
        var head = 0
        var visited = [Bool](repeating: false, count: size+1)
        opperations = [String](repeating: String(), count: size+1)
        track = [Int](repeating: Int(), count: size+1)
        
        que.append(A)
        visited[A] = true
        
        while head < que.count {
            let current = que[head]
            head += 1
            
            if current == B {
                find(B, A)
                return
            }
            
            // D
            let nextD = current.double
            if !visited[nextD] {
                visited[nextD] = true
                que.append(nextD)
                opperations[nextD] = "D"
                track[nextD] = current
            }
            // S
            let nextS = current.subtration
            if !visited[nextS] {
                visited[nextS] = true
                que.append(nextS)
                opperations[nextS] = "S"
                track[nextS] = current
            }
            // L
            let nextL = current.left
            if !visited[nextL] {
                visited[nextL] = true
                que.append(nextL)
                opperations[nextL] = "L"
                track[nextL] = current
            }
            // R
            let nextR = current.right
            if !visited[nextR] {
                visited[nextR] = true
                que.append(nextR)
                opperations[nextR] = "R"
                track[nextR] = current
            }
        }
    }
    
    func main() {
        guard let inputT = readLine() else { return }
        
        var T = Int(inputT) ?? 0
        while T > 0 {
            T -= 1
            
            guard let AB = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
            
            let A = AB[0]
            let B = AB[1]
            
            go(A, B)
        }
    }
}

Boj9019().main()

extension Int {
    var left: Int {
        return (self%1000)*10 + (self/1000)
    }
    
    var right: Int {
        return (self%10)*1000 + (self/10)
    }
    
    var double: Int {
        return (self * 2) % 10000
    }
    
    var subtration: Int {
        return self == 0 ? 9999 : self-1
    }
}
