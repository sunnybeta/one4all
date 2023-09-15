import threading
import time

start = time.perf_counter()

def foo(n):
    print(f'Sleeping for {n} seconds ... :z')
    time.sleep(n)
    print('Waking up ... :O')


threads = []

for _ in range(10):
    t = threading.Thread(target=foo, args=[2.5])
    t.start()
    threads.append(t)

for thread in threads:
    thread.join()

end = time.perf_counter()

print(f"Task completed in {round(end-start,2)} seconds")
