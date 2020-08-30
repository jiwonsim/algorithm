import Foundation

class Boj1182 {
    
    var N = Int()
    var target = Int()
    var numbers = [Int]()
    
    var result = 0
    
    func go(_ index: Int, _ sum: Int) {
        if index == N {
            if sum == target {
                // 찾았다.
                result+=1
                return
            }
            // 못 찾았다.
            return
        }
        
        go(index+1, sum+numbers[index])
        go(index+1, sum)
    }
    
    func main() {
        guard let input = readLine()?.split(separator: " ").compactMap({Int(String($0))}),
            let inputNumbers = readLine()?.split(separator: " ").compactMap({Int(String($0))})
            else { return }
        
        N = input[0] // 1 <= N <= 20
        target = input[1] // -1,000,000 <= S <= 1,000,000
        numbers = inputNumbers
        
        go(0, 0)
        if target == 0 { result-=1 }
        print(result)
    }
}

Boj1182().main()
