import time

start = time.perf_counter()

def foo():
    n = 1
    print(f'Sleeping for {n} seconds ... :z')
    time.sleep(1)
    print('Waking up ... :O')


foo()
foo()

end = time.perf_counter()

print(f"Task completed in {round(end-start,2)} seconds")
