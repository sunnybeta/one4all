import threading
import time

start = time.perf_counter()

def foo():
    n = 1
    print(f'Sleeping for {n} seconds ... :z')
    time.sleep(1)
    print('Waking up ... :O')


thread_1 = threading.Thread(target=foo)
thread_2 = threading.Thread(target=foo)

thread_1.start()
thread_2.start()

# Wait for thread to finish before calculating the end time
thread_1.join()
thread_2.join()

end = time.perf_counter()

print(f"Task completed in {round(end-start,2)} seconds")
