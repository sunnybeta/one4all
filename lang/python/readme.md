# Python

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
