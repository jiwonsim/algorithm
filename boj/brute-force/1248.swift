import Foundation

var N = Int()
var S = [[String]]()
var result = [Int]()

func calc(_ index: Int) -> Bool {
    
    for i in (0...index).reversed() {
        var sum = 0
        for j in i...index {
            sum += result[j]
        }
        
        if S[i][index] == "-" && sum >= 0 { return false }
        if S[i][index] == "+" && sum <= 0 { return false }
        if S[i][index] == "0" && sum != 0 { return false }
    }
    
    return true
}

func search(_ index: Int) {
    if index == N {
        print(result.inline)
        exit(0)
    }

    if S[index][index] == "0" {
        result[index] = 0
        if calc(index) { search(index+1) }
    }

    else if S[index][index] == "-" {
        for num in -10..<0 {
            result[index] = num
            if calc(index) { search(index+1) }
        }
    }
    else { // "+"
        for num in 0...10 {
            result[index] = num
            if calc(index) { search(index+1) }
        }
    }
}


if let input = readLine() {
    if let n = Int(input) {
        N = n
        guard let inputOfS = readLine()?.compactMap({String($0)}) else { exit(0) }
        S = [[String]](repeating: [String](repeating: String(), count: N), count: N)
        result = [Int](repeating: 0, count: N)

        var head = 0
        for i in 0..<N {
            for j in i..<N {
                S[i][j] = inputOfS[head]
                head+=1
            }
        }

        search(0)
    }
}

extension Array {
    var inline: String {
        var str = String()
        for element in self {
            str += "\(element) "
        }
        return str
    }
}
