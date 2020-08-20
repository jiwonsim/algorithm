
class MyHashSet {
    
    private var dict = Dictionary<Int, Bool>()
    
    init() {
        
    }
    
    func add(_ key: Int) {
        dict[key] = true
    }
    
    func remove(_ key: Int) {
        dict[key] = nil
    }
    
    func contains(_ key: Int) -> Bool {
        return dict[key] != nil
    }
}
