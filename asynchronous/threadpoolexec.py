import concurrent.futures
import time

start = time.perf_counter()

def foo(n):
    print(f'Sleeping for {n} seconds ... :z')
    time.sleep(n)
    return f"Waking up for {n} :O"

with concurrent.futures.ThreadPoolExecutor() as executor:
    seconds = [5,4,3,2,1]
    # Version 1
    # submit => schedules a function to be executed and returns a future object
    # future_1 = executor.submit(foo, 2)
    # future_2 = executor.submit(foo, 2)
    # print(future_1.result())
    # print(future_2.result())
    
    # Version 2
    # results = [executor.submit(foo,2) for _ in range(9)]
    # for f in concurrent.futures.as_completed(results):
    #     print(f.result())

    # results = [executor.submit(foo, second) for second in seconds]
    # for f in concurrent.futures.as_completed(results):
    #     print(f.result())
    
    # Version 3
    results = executor.map(foo, seconds)
    for result in results:
        print(result)

end = time.perf_counter()

print(f"Task completed in {round(end-start,2)} seconds")
