from typing import Any, List, Optional

class Stack:
    def __init__(self, data: Optional[Any] = None) -> None:
        self.__stack: List = [data] if data != None else []

    def top(self) -> Any:
        if not self.__stack:
            raise LookupError('Stack is Empty')
        return self.__stack[-1]

    def push(self, data: Any) -> None:
        self.__stack.append(data)

    def pop(self) -> Any:
        return self.__stack.pop()
    
    def __repr__(self):
        return repr(self.__stack)

    def __str__(self) -> str:
        return f"{' --- '.join([str(item) for item in self.__stack])}"


if __name__ == '__main__':
    s = Stack()
    s.push(1)
    s.push(2)
    s.push('Beta')
    s.push(4)
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    print(s.pop())
    print(s)
    print()
    try:
        s.pop()
    except LookupError:
        print('Stack is Empty lol')
