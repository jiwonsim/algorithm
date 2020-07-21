import Foundation

var result = [Int](repeating: 0, count: 11)

func search(_ number: Int) -> Int {
    if result[number] > 0 { return result[number] }
    
    if number == 0 { return 1 }
    if number == 1 { return 1 }
    if number == 2 { return 2 }
    
    result[number] = search(number-1) + search(number-2) + search(number-3)
    return result[number]
}


let T = Int(readLine()!)!
for _ in 0..<T {
    let n = Int(readLine()!)!
    print(search(n))
}
