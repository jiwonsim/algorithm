import Foundation

class Boj14395 {
    
    private let limit = 1000000000

    private var opperation = [Int64 : Character]()
    private var track = [Int64 : Int64]()
    private var result = [Character]()
    
    private func find(_ num: Int64, _ s: Int64) {
        if num == s {
            for i in (0..<result.count).reversed() {
                print(result[i], terminator:"")
            }
            print()
            exit(0)
        }
        
        if track[num] != nil && opperation[num] != nil {
            result.append(opperation[num]!)
            find(track[num]!, s)
        }
    }
    
    private func isInRange(_ num: Int64) -> Bool {
        return num >= 0 && num <= limit
    }
    
    private func go(_ s: Int, _ t: Int) {
        if s == t {
            print("0")
            exit(0)
        }
        
        var que = [Int64]()
        var visited = Set<Int64>()
        
        que.append(Int64(s))
        visited.insert(Int64(s))
        
        while !que.isEmpty {
            let cur = que.removeFirst()
            
            // *
            if isInRange(cur*cur) && !visited.contains(cur*cur) {
                visited.insert(cur*cur)
                que.append(cur*cur)
                opperation[cur*cur] = "*"
                track[cur*cur] = cur
            }
            // +
            if isInRange(cur+cur) && !visited.contains(cur+cur) {
                visited.insert(cur+cur)
                que.append(cur+cur)
                opperation[cur+cur] = "+"
                track[cur+cur] = cur
            }
            //-
            if isInRange(cur-cur) && !visited.contains(cur-cur) {
                visited.insert(cur-cur)
                que.append(cur-cur)
                opperation[cur-cur] = "-"
                track[cur-cur] = cur
            }
            // /
            if cur != 0 && isInRange(cur/cur) && !visited.contains(cur/cur) {
                visited.insert(cur/cur)
                que.append(cur/cur)
                opperation[cur/cur] = "/"
                track[cur/cur] = cur
            }
        }
        
        find(Int64(t), Int64(s))
    }
    
    func main() {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        
        go(input[0], input[1])
        print(-1)
    }
}

Boj14395().main()
