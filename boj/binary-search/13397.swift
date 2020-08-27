import Foundation

class Boj13397 {
    func find(_ limit: Int, _ array: [Int]) -> Int {
        var count = 1
        var maxVal = array[0]
        var minVal = array[0]
        
        for element in array {
            if maxVal < element {
                maxVal = element
            }
            if minVal > element {
                minVal = element
            }
            
            if maxVal-minVal > limit {
                count+=1
                maxVal = element
                minVal = element
            }
        }
        
        return count
    }
    
    func main() {
        guard let nm = readLine()?.inlineInteger else { return }
        let _ = nm[0]
        let m = nm[1]
        
        guard let array = readLine()?.inlineInteger else { return }
        
        var start = 0
        var end = array.max() ?? 0
        var result = 0
        
        while start <= end {
            let mid = (start+end)/2
            
            if find(mid, array) <= m {
                end = mid-1
                result = mid
            }
            else { start = mid+1 }
        }
        
        print(result)
    }
}

Boj13397().main()

extension String {
    var inlineInteger: [Int] {
        return self.split(separator: " ").compactMap({Int(String($0))})
    }
}
