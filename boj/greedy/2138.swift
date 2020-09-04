import Foundation

class Boj2138 {
    
    var current = [Int](), target = [Int]()
    
    func switchOnOff(_ index: Int, _ array: inout [Int]) {
        for i in index-1...index+1 {
            if i >= 0 && i < array.count {
                array[i] = 1-array[i]
            }
        }
    }
    
    func go(_ arr: [Int]) -> (Bool, Int) {
        var array = arr
        
        var count = 0
        for i in 0..<array.count-1 {
            if array[i] != target[i] {
                // 둘이 다르면 불을 끈다
                switchOnOff(i+1, &array)
                count+=1
            }
        }
        if array == target { return (true, count) }
        else { return (false, count) }
    }
    
    func main() {
        guard let inputN = readLine(),
            let inputCurrent = readLine(),
            let inputTarget = readLine()
            else { return }
        
        let _ = Int(inputN) ?? 0
        current = Array(inputCurrent).compactMap { Int(String($0)) }
        target = Array(inputTarget).compactMap { Int(String($0)) }
        
        // 1번 전구를 안 눌렀을 때
        let notTurned = go(current)
        
        // 1번 전구를 눌렀을 때
        current[0] = 1-current[0]
        current[1] = 1-current[1]
        let turned = go(current)
        
        if turned.0 {
            if !notTurned.0 { print(turned.1+1) }
            else { print(min(turned.1+1, notTurned.1)) }
        }
        else {
            if !notTurned.0 { print(-1) }
            else { print(notTurned.1) }
        }
    }
}

Boj2138().main()
