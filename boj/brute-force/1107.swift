import Foundation

let initialChannel = 100

var channel = [Bool](repeating: true, count: 10)
var targetChannel = Int()
var unavailableCnt = Int()
var unavailableChannel = [Int]()

func pressingButton( _ input: Int) -> Int {
    var number = input
    
    if number == 0 {
        if channel[number] {
            return 1
        }
        else { return -1 }
    }
    
    var count = 0
    while number > 0 {
        if !channel[number % 10] { return -1 }
        number /= 10
        count += 1
    }
    
    return count
}

func solution() {
    targetChannel = Int(readLine()!)!
    unavailableCnt = Int(readLine()!)!
    if unavailableCnt != 0 {
        unavailableChannel = readLine()!.split(separator: " ").map { Int(String($0))! }
    
        for ele in unavailableChannel {
            channel[ele] = false
        }
    }
    
    var result = abs(targetChannel - 100)
    for i in 0...1000000 {
        
        let count = pressingButton(i)
        
        if count == -1 { continue }
        result = min(result, count + abs(targetChannel - i))
    }
    
    print(result)
}

solution()
