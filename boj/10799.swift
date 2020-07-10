import Foundation

func main(_ input: String) -> Int {

    let collectionOfLaser = input.unicodeScalars.map { Character($0) }
    
    var array = [Character]()
    var sum = 0

    array.append(collectionOfLaser[0])
    
    var top = array.last
    for char in collectionOfLaser[1...] {
        switch char {
        case "(":
            array.append(char)
        case ")":
            array.removeLast()
            if top == "(" {
                sum += array.count
            }
            else { sum += 1}
        default:
            break
        }
        
        top = char
    }
    
    return sum
}

print(main(readLine()!))
