import Foundation

extension Array {
    var printInline: String {
        var str = String()
        for ele in self {
            str += "\(ele) "
        }
        return str
    }
}

if let N = readLine()?.compactMap({ Int(String($0)) }) {
    var numbers = readLine()!.split(separator: " ").compactMap { Int(String($0)) }
    
    var pivot = -1
    
    for i in (0..<numbers.count-1).reversed() {
        if numbers[i] < numbers[i+1] {
            continue
        }
        
        pivot = i
        break
    }
    
    if pivot == -1 {
        print(-1)
        exit(0)
    }
    
    var smaller = pivot+1
    while smaller < numbers.count && numbers[pivot] > numbers[smaller] {
        smaller+=1
    }
    smaller-=1
    
    numbers.swapAt(pivot, smaller)
    numbers[(pivot+1)...].sort{ $0 > $1 }
    
    
    print(numbers.printInline)
}
