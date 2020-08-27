import Foundation

class Boj2805 {
    
    func cutTree(_ trees: [Int], _ height: Int) -> Int64 {
        var result = Int64()
        
        for tree in trees {
            if height > tree { continue }
            result += Int64(tree-height)
        }
        
        return result
    }
    
    func main() {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        let _ = Int(input[0])
        let M = Int(input[1])
        
        guard var trees = readLine()?.split(separator: " ").compactMap({Int(String($0))}) else { return }
        
        trees.sort()
        
        var start = 0
        var end = trees.last ?? 0
        
        var result = Int()
        
        while start <= end {
            let mid = (start+end)/2
            let midVal = cutTree(trees, mid)
            
            if midVal >= M {
                start = mid+1
                result = mid
            }
            else { end = mid-1 }
        }
        
        print(result)
    }
}

Boj2805().main()
