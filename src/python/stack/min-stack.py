
class MinStack:
    def __init__(self):
        self.stack = []
        self.min_stack = []
    
    # @param x, an integer
    # @return an integer
    def push(self, x):
         self.stack.append(x)
         if len(self.min_stack) == 0 or x <= self.min_stack[-1]:
             self.min_stack.append(x)
         
    # @return nothing
    def pop(self):
        top = self.stack[-1]
        self.stack.pop()
        if top == self.min_stack[-1]:
            self.min_stack.pop()

    # @return an integer
    def top(self):
        return self.stack[-1]

    # @return an integer
    def getMin(self):
        return self.min_stack[-1]