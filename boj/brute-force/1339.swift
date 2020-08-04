import Foundation

var result: Int64 = 0
var inputStrs = [String]()

func main() -> Int64 {
    guard let N = readLine() else { return -1 }
    for _ in 0..<(Int(N) ?? 0) {
        guard let input = readLine() else { return -1 }
        inputStrs.append(input)
    }
    
    // 가중치와 실제 값을 저장할 해쉬맵
    var valueOfChar = [Character: Int]()
    
    // 가중치를 담는다
    for row in 0..<inputStrs.count {
        var ten = 10^^(inputStrs[row].count-1) // 문자 전체의 길이만큼 10을 제곱함
        for col in 0..<inputStrs[row].count {
            if let value = valueOfChar[inputStrs[row][col]] {
                valueOfChar[inputStrs[row][col]] = value + ten
            }
            else {
                valueOfChar[inputStrs[row][col]] = ten
            }
            ten /= 10
        }
    }
    
    // 정렬을 하기 위해 딕셔너리 배열 생성
    var dictOfValues = [(char: Character, cost: Int)]()
    for (key, value) in valueOfChar {
        dictOfValues.append((key, value))
    }
    
    // 가중치를 오름차순으로 정렬
    dictOfValues.sort {$0.cost > $1.cost}
    
    // 9~1 순으로 값을 할당
    var value = 9
    for (char, cost) in dictOfValues {
        valueOfChar[char] = value
        value -= 1
    }
    
    // 할당한 값을 토대로 결과값 계산
    for row in 0..<inputStrs.count {
        var number = Int64()
        var ten = 10^^(inputStrs[row].count-1)
        
        for col in 0..<inputStrs[row].count {
            if let foundValue = valueOfChar[inputStrs[row][col]] {
                number += Int64(foundValue * ten)
            }
            ten /= 10
        }
        
        result += number
    }
    
    return result
}

print(main())

extension String {
    subscript(x: Int) -> Character {
        return self[self.index(self.startIndex, offsetBy: x)]
    }
}

precedencegroup PowerPrecedence { higherThan: MultiplicationPrecedence }
infix operator ^^ : PowerPrecedence
func ^^ (radix: Int, power: Int) -> Int {
    return Int(pow(Double(radix), Double(power)))
}
