import Foundation

class Boj1654 {
    
    func makeLan(_ lans: [Int], _ length: Int) -> Int {
        var result = 0
        for lan in lans {
            result += (lan/length)
        }
        return result
    }
    
    func main() {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        let K = Int(input[0])
        let N = Int(input[1])
        
        var lans = [Int]()
        for _ in 0..<K {
            guard let lengthInput = readLine() else { return }
            lans.append(Int(lengthInput) ?? 0)
        }
        
        lans.sort()
        
        var start = 1
        var end = lans.last ?? 0
        var result = 0
        
        while start <= end {
            let mid = (start+end)/2
            let cntOfMid = makeLan(lans, mid)
            
            if cntOfMid >= N {
                start = mid+1
                result = max(result, mid)
            }
            else { end = mid-1 }
        }
        print(result)
    }
}

Boj1654().main()
