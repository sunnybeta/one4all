# Lambda

- AWS Lambda is a compute service
- We can run code at scae without worrying about servers
- We write functions - the primary unit of lambda
- Useful in API Hosting, Event Processing an Timer Based Jobs

### Workflow

1. Create a function
2. Write and upload your code in a supported programming language
3. Run your function

### Why is it uesful?

- No servers to manage
- Autoscaling
- Pay for what you use
- Performance; tune lambda by adding extra memory
- Service integrations
- Easy to use, monitor and debug

### Disadvantages

- Gain flexibility at the expense of control. We lose low level details of your infrastructure

### Function Execution

1. Code download: Full Cold Start
2. Start Execution Environment: Full Cold Start
3. Execution init code: Partial Cold Start
4. Execute handler code: Warm Start

### Strategies to Minimize Cold Start

- Minimize number of library dependency
- Only import what you need
- Raise memory configuration
- Utilize provisioned concurrency: Keeps code in warm stage and ready to go
