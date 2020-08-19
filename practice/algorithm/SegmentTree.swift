import Foundation

public class SegmentTree<T> {
    private var value: T
    private var function: (T, T) -> T
    private var leftBound: Int
    private var rightBound: Int
    private var leftChild: SegmentTree<T>?
    private var rightChild: SegmentTree<T>?
    
    public init(array: [T], leftBound: Int, rightBound: Int, function: @escaping (T, T) -> T) {
        self.leftBound = leftBound
        self.rightBound = rightBound
        self.function = function
        
        if leftBound == rightBound { value = array[leftBound] }
        else {
            let middle = (leftBound + rightBound) / 2
        
            leftChild = SegmentTree<T>(array: array, leftBound: leftBound, rightBound: middle, function: function)
            rightChild = SegmentTree<T>(array: array, leftBound: middle+1, rightBound: rightBound, function: function)
            
            value = function(leftChild!.value, rightChild!.value)
        }
    }
    
    public convenience init(array: [T], function: @escaping (T, T) -> T) {
        self.init(array: array, leftBound: 0, rightBound: array.count-1, function: function)
    }
    
    public func query(leftBound: Int, rightBound: Int) -> T {
        // 우리가 알고자 하는 범위가 현재 가지고 있는 범위와 같다면, 현재 value 값을 반환
        if self.leftBound == leftBound && self.rightBound == rightBound {
            return self.value
        }
        
        guard let leftChild = leftChild else { fatalError() }
        guard let rightChild = rightChild else { fatalError() }
        
        if leftChild.rightBound < leftBound { // leftChild의 가장 끝 부분보다 범위 시작부분이 크다면, rightChild로 간다.
            return rightChild.query(leftBound: leftBound, rightBound: rightBound)
        }
        else if rightChild.leftBound > rightBound { // rightChild의 가장 시작 부분보다 범위 끝부분이 작다면, leftChild로 간다.
            return leftChild.query(leftBound: leftBound, rightBound: rightBound)
        }
        else {
            // 위의 두 경우가 아니라면, 우리가 찾고자 하는 범위는
            // leftChild와 rightChild를 관통하는 부분이기 때문에
            // 두 child의 쿼리 결과 값을 혼합한다.
            let leftResult = leftChild.query(leftBound: leftBound, rightBound: leftChild.rightBound)
            let rightResult = rightChild.query(leftBound: rightChild.leftBound, rightBound: rightBound)
            return function(leftResult, rightResult)
        }
    }
    
    public func replace(at index: Int, withItem item: T) {
        if leftBound == rightBound {
            value = item
        }
        else if let leftChild = leftChild,
            let rightChild = rightChild {
            if leftChild.rightBound >= index {
                leftChild.replace(at: index, withItem: item)
            }
            else { rightChild.replace(at: index, withItem: item)}
            
            value = function(leftChild.value, rightChild.value)
        }
    }
}
