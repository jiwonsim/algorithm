func find(_ node: Int) {
    
    for ele in tree[node] {
        if checked[ele] { continue }
        checked[ele] = true
        parents[ele] = node
        find(ele)
    }
}

// init & input
let N = Int(readLine()!)!
var tree = [[Int]](repeating: [Int](), count: N + 1)

var checked = [Bool](repeating: false, count: N + 1)
var parents = [Int](0...N)

for _ in 0..<N-1 {
    let input = readLine()!.split(separator: " ").compactMap{ Int(String($0)) }
    
    tree[input[0]].append(input[1])
    tree[input[1]].append(input[0])
}

find(1)

for index in 2...N {
    print(parents[index])
}
