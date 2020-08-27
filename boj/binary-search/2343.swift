import Foundation

class Boj2343 {
    
    func countingLessons(_ lengths: [Int], _ limit: Int, _ M: Int) -> Int {
        
        var count = 1
        var sum = 0
        
        for length in lengths {
            
            if sum+length > limit {
                count+=1
                sum=length
            }
            else {
                sum += length
            }
        }
        
        return count
    }
    
    func main() {
        guard let nm = readLine()?.inlineInteger else { return }
        guard let lengths = readLine()?.inlineInteger else { return }
        
        let _ = nm[0]
        let M = nm[1]
        let sumOfLengths = lengths.reduce(0, { $0+$1 })
        
        var start = lengths.max() ?? 0
        var end = sumOfLengths
        var result = 0
        
        while start <= end {
            let mid = (start+end)/2
            let midVal = countingLessons(lengths, mid, M)
            
            if midVal <= M {
                end = mid - 1
                result = mid
            }
            else { start = mid + 1 }
        }
        
        print(result)
    }
}

extension String {
    var inlineInteger: [Int] {
        return self.split(separator: " ").compactMap({Int(String($0))})
    }
}

Boj2343().main()
