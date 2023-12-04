# Python

## Installation

Visit the official website [here](https://python.org).

## Hello World

```python
print('Hello, World!')
```

Save the above line of code in a file named `hello.py`. Execute the command:

```bash
python hello.py
```

Congratulations! You've written your first python program.


## Lists

A `list` is a complex data type in Python which stores a collection of elements (possibly different types) in a `0`-indexed sequence.

```python
lst = ['Hello', 216, {'key':'value'}]
print(lst[0], lst[2])
# 'Hello', {'key':'value'}
```

## Context Manager

Context Managers help us execute code within the `with` statement  handling setup and tear down code.

One can create a context manager by creating a class which implements the `__enter__` and `__exit__` dunder methods.

```python
class Network:

    def __init__(self, port: int = 5432):
        self.port = port

    def __enter__(self):
        print("Setup")
        return f"--- NETWORK[{self.port}] ---"

    def __exit__(self, exc_type, exc_val, exc_tb):
        print("Tear Down")
```

This now allows us to utilise an instance of the above class follows:
```python
with Network(1234) as net:
    print(net)
    print("NOICELY DONE :O :O")
```

The `ctxmngr.py` file when executed should display:

```text
Setup
--- NETWORK[1234] ---
NOICELY DONE :O :O
Tear Down
```

