class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []
        i = 0
        stackCounter = 0

        while i < len(operations):
            if operations[i] == '+':
                stack.append(stack[stackCounter-1] + stack[stackCounter-2])
                stackCounter += 1
            elif operations[i] == 'C':
                stack.pop(stackCounter-1)
                stackCounter -= 1
            elif operations[i] == 'D':
                stack.append(stack[stackCounter-1]*2)
                stackCounter += 1
            else:
                stack.append(int(operations[i]))
                stackCounter += 1
            i += 1

        sum = 0
        for i in stack:
            sum += i

        return sum
