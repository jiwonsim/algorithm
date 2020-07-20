import Foundation

var visited = [Bool]()
var result = [Int]()

extension Array {
    var printInline: String {
        var str = String()
        for ele in self { str += "\(ele) " }
        return str
    }
}

func search(_ number: Int, _ depth: Int, _ N: Int) {
    
    if depth == N {
        print(result.printInline)
        return
    }
    
    for i in 0..<N {
        if visited[i] { continue }
        visited[i] = true
        result[depth] = i+1
        search(i+1, depth+1, N)
        visited[i] = false
    }
}

if let N = readLine()?.map({ Int(String($0))! })[0] {
    visited = [Bool](repeating: false, count: N)
    result = [Int](repeating: 0, count: N)

    search(0, 0, N)
    
}
