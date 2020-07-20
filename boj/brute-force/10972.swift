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
        // 뒤의 값(i+1)이 앞의 값(i)보다 크면 건너뛰기
        if numbers[i] > numbers[i+1] {
            continue
        }
        
        // 뒤의 값이 앞의 값보다 작으면 기준이 된다
        pivot = i
        break
    }
    
    if pivot == -1 {
        print(-1)
        exit(0)
    }
    
    // pivot의 값보다 큰 값 중 가장 작은 값 찾기
    var larger = pivot+1
    while larger < numbers.count && numbers[pivot] < numbers[larger] {
        larger+=1
    }
    larger-=1
    
    numbers.swapAt(pivot, larger)
    numbers[(pivot+1)...].sort()
    
    print(numbers.printInline)
}
