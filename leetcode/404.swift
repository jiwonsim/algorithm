
class Solution {
    func sumOfLeftLeaves(_ root: TreeNode?) -> Int {
        if root == nil { return 0 }
        
        var result = 0
        var nodes: [TreeNode] = [root!]
        
        while nodes.count > 0 {
            let node = nodes[0]
            
            if node.left != nil &&
                node.left?.left == nil && node.left?.right == nil {
                result += node.left?.val ?? 0
            }
            
            nodes.remove(at: 0)
            
            if node.left != nil { nodes.append(node.left!) }
            if node.right != nil { nodes.append(node.right!) }
        }
        
        return result
    }
}
