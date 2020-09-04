import Foundation

class Boj1285 {
    func main() {
        guard let inputN = readLine() else { return }
        
        let N = Int(inputN) ?? 0
        var map = [[Character]]()
        
        for _ in 0..<N {
            guard let input = readLine() else { return }
            map.append(Array(input))
        }
        
        var result = Int.max
        for z in 0..<(1<<N) { // 행을 바꿀지 말지
            var sum = 0
            for j in 0..<N { // 열
                var count = 0
                for i in 0..<N { // 행
                    var cur = map[i][j]
                    if z & (1<<i) == 0 { // 해당 행을 바꾼다
                        if cur == "T" { cur = "H" }
                        else { cur = "T" }
                    }
                    
                    if cur == "T" { count+=1 }
                }
                
                // 열을 바꾼 게 더 최소값인지, 안 바꾼 게 더 최소값인지 검사
                sum += min(count, N-count)
            }
            result = min(result, sum)
        }
        print(result)
    }
}

Boj1285().main()
