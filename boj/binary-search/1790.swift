import Foundation

class Boj1790 {
    
    func findLength(_ number: Int) -> Int64 {
        var answer = Int64()
        
        var length = 1
        for start in sequence(first: 1, next: { $0*10 })
            .prefix(while: { $0 <= number }){
                var end = start*10-1
                if end > number { end = number }
                answer += Int64((end-start+1)*length);
                length+=1
        }
        return answer
    }
    
    func main() -> String {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return "-1" }
        
        let N = Int(input[0])
        let M = Int(input[1])
        
        if findLength(N) < M { return "-1" }
        
        var start = 1
        var end = N
        
        var result = 0
        while start <= end {
            let mid = (start+end)/2
            let midLen = findLength(mid)
            
            if midLen >= M {
                end = mid-1
                result = mid
            }
            else {
                start = mid+1
            }
        }
        
        let resultString = String(result)
        let resultLength = findLength(result)
        let index = Int64(resultString.count)-(resultLength-Int64(M)+1)
        
        return resultString[Int(index)]
    }
}

extension String {
    subscript(x: Int) -> String {
        return String(self[self.index(self.startIndex, offsetBy: x)])
    }
}

print(Boj1790().main())

