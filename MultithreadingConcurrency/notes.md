process(context) - each process is completely isolated from any other process in the system.

process contains : metadata like - process Id, Files (that the application opens for reading and writing), code (that would be executed), the heap ( Contains all the data our application needs), and atleat one thread called main.

In multithreaded application - each thread comes with its own stack and instruction pointer and shares and other components are shared by all threads.

Stack: its a region in memory where local variables are stored and passed into functions for executions.

Instruction Pointer : its a pointer that points to the address of the next instruction that the thread is going to execute.

contextSwitch: The process of stopping a thread, scheduling it out, scheduling other thread in and starting the other thread is called context switching. 
* Context switching is not cheap and its the price of multithreading.
* eg. each thread occupies some resources like registers, caches and kernel resources in memory, while doing a context switch all of this information has to be stored, and the data of another thread has to be restored back to CPU and memory.

Having too many threads causes Thrashing - ie. spending more time in management (and context switching) than actual productive work.
* thread consumes less resources than processes.
* context switching between threads of same process is cheaper than that of different processes, since a lot of data is shared between threads of same process.

OS - Internals of thread management
OS divides the time for a process into epoch 
dynamic priority = static priority+bonus
    dynamic priority is maintained by os
    static priority is maintained by developer
    bonus is adjusted by OS for each thread

Starvation: is a thread taking to long to complete and in mead time other threads starve for resources.
scheduling only shorter threads result in longer threads never getting executed.

* stack is not shared among threads

Stopping a thread can be needed in many scenarios:
    1. The thread is taking longer than allowed.
    2. Thread is misbehaving
    3. To stop all threads to end the process gracefully. (Even if 1 thread is alive the process is not terminated)
ways to stop thread:-
Thread Interrupt
Daemon thread - Background task that should not block our application from terminating.

