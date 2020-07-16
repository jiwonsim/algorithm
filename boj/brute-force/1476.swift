import Foundation

func solution() {
    let input = readLine()!.split(separator: " ").map { String($0) }
    
    let E = Int(input[0])!
    let S = Int(input[1])!
    let M = Int(input[2])!
    
    var year = 1
    while true {
        let foundE = year % 15 == 0 ? 15 : year % 15
        let foundS = year % 28 == 0 ? 28 : year % 28
        let foundM = year % 19 == 0 ? 19 : year % 19
        
        if foundE == E && foundS == S && foundM == M {
            print(year)
            break
        }
        
        year += 1
    }
}

solution()
