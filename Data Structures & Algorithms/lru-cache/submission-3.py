class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.prev = self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}

        self.left, self.right = Node(0,0), Node(0,0)
        self.left.next = self.right
        self.right.prev = self.left

    # L - 1 - 2 - R

    def remove(self, node):
        p = node.prev
        n = node.next
        n.prev = p
        p.next = n

    def insert(self, node):
        temp_node = self.right.prev
        temp_node.next = node
        self.right.prev = node
        node.prev, node.next = temp_node, self.right
    
    def get(self, key: int) -> int:
        if key in self.cache:
            n = self.cache[key]
            self.remove(n)
            self.insert(n)
            return n.val
        return -1


    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            n = self.cache[key]
            n.val = value
            self.remove(n)
            self.insert(n)
            return
        new_node = Node(key, value)
        if len(self.cache) == self.capacity:
            delete_node = self.left.next
            del self.cache[delete_node.key]
            self.remove(delete_node)
            self.insert(new_node)
        else:
            self.insert(new_node)
        self.cache[key] = new_node
