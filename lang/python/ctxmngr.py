class Network:

    def __init__(self, port: int = 5432):
        self.port = port

    def __enter__(self):
        print("Setup")
        return f"--- NETWORK[{self.port}] ---"

    def __exit__(self, exc_type, exc_val, exc_tb):
        print("Tear Down")

with Network() as net:
    print(net)
    print("NOICELY DONE :O :O")

