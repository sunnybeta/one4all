# Asynchronous Programming

## Synchronous Program

A *synchronous program* is exeucted one step at a time and the program moves
on to the next line only after the previous step is complete.

## Asynchronous Program

An *asynchronous program* take one execution step at a time but behaves
differently in the sense that the system may not wait for an exeuction step to
be completed before moving on to the next one.

## Thread
A *thread* is a separate process and flow of exeuction. The program will have
two things happening at once.


## CPU Bound vs IO Bound Task

CPU bound tasks utilises the CPU for a lot of computations.

IO bound task are tasks which are waiting for input and output tasks to be
completed. Example: reading writing from files, network calls, database calls


## Parallelism vs Concurrency

Suppose we are doing to do two tasks at the same time.

*Parallelsim* occurs when for a given time interval both the tasks occur at the
same time. We say that the two tasks are running parallely or in parallel.

*Concurrency* is when one task is running and the second task is allowed to run
if the first task has a waiting period where it canno function due to reasons
out of our control. We say that the two tasks are running *concurrently* or
*concurrent*.


## Global Interpreter Lock

In python, whenever we execute code we use something called an *interpreter*
which is capable of understanding the code and processing the instructions.

In case of multiple threads, these threads need to access the code
interpreter. In python, this interpeter has a lock which only allows one thread
to run at a time. Since we have a lock on our python interpreter, only one
thread runs at a time. This is Python's **Global Interpreter Lock**. This
provides us with concurrency but not with true parallel programming.

The [multiprocessing](https://docs.python.org/3/library/multiprocessing.html)
library is a solid library for side-stepping the GIL.

