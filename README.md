# Factory emulator

![](/images/factory_scheme.png)

1. All warehouses have a certain size. The sizes
   of warehouses, the number of collectors, suppliers and dealers are set in the configuration file. The application provides a graphical interface (Swing library) where you can view the main parameters of the factory and control the process.

2. Each collector, supplier and dealer works in a separate thread.

3. The threads that represent part suppliers deliver one part every N milliseconds. If some parts warehouse is full, then the supplier expects
   to free up space for parts. Speed
   the work of suppliers is determined by 3 sliders (for each type of parts).

4. The streams that represent dealers request 1 car from the finished product warehouse in M milliseconds. The speed of requesting machines can be adjusted by a slider in the window interface.

5. The flow of the finished product warehouse controller wakes up whenever
   the machine is sent from the product warehouse. He analyzes the condition of the warehouse and sends a request for the manufacture of new machines (if necessary) to the factory.

6. There are several threads (assemblers) running in the factory within the ThreadPool.
   The tasks for ThreadPool are requests for the creation of new machines (from the controller of the finished goods warehouse). When performing such a task, the assembler
   takes one part each, necessary for assembling the machine, from the corresponding warehouses. If the necessary part is not in stock, then the flow is waiting for delivery. When assembling a new machine, the worker creates a new object and with the help
   of all the necessary objects representing the parts. After that, the object is sent to the finished product warehouse. If the warehouse is full, then the worker is waiting
   for the release of space for a new car.
   
   ![](/images/mainframe.png)
