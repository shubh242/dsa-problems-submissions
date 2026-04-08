class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        i = 0

        while i < len(operations):
            if operations[i] == '+':
                stack.append(stack[-1] + stack[-2])
            elif operations[i] == 'C':
                stack.pop()
            elif operations[i] == 'D':
                stack.append(stack[-1]*2)
            else:
                stack.append(int(operations[i]))
            i += 1

        sum = 0
        for i in stack:
            sum += i

        return sum
