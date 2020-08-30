import Foundation

class Boj14225 {
    
    var N = Int()
    var numbers = [Int]()
    
    var result = [Bool](repeating: false, count: (100000*20)+1)
    
    func go(_ index: Int, _ sum: Int) {
        if index == N {
            result[sum] = true
            return
        }
        
        go(index+1, sum+numbers[index])
        go(index+1, sum)
    }
    
    func main() {
        guard let input = readLine(),
            let inputNumbers = readLine()?.split(separator: " ").compactMap({Int(String($0))})
            else { return }
        
        N = Int(input) ?? 0
        numbers = inputNumbers
        
        go(0, 0)
        
        for i in 1..<result.count {
            if !result[i] {
                print(i)
                return
            }
        }
    }
}

Boj14225().main()
