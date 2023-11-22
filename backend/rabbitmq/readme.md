# Rabbit MQ

*RabbitMQ* is an open-sourced message broker which accepts and forwards messages.

## Components

**Producer**: A program that sends messages

**Consumer**: A program that awaits to receive messages

**Queue**: Messages sent to RabbitMQ are stored inside a large buffer which is a queue bound by the host's memory and disk limits

**Exchange**: Messages are never directly sent to a queue instead they are sent to an exchange which decides which queues should be receiving the messages.

**Bindings**: We need to tell the exchange about the queues to which the messages will be sent. This relationship between an exchange and its queues is called binding.

Producers and Consumers are mostly different programs but they can sit inside the same application as well.

### Exchange Types

**Fanout**: All queues will receive the message

**Direct**: Only the specified queue will receive the message

**Topic**: Queues which can be identified specified by topic names which can be wild card characters.

## Routing Keys

Topic exchange needs to have a good definition and standardization for routing keys. Routing keys helps the exchange identify the queues to which the messages must be sent.

While defining a routing key *#* substitutes for zero or more words while * * * substitues for exactly one word.

- `*.notifications` will forward messages from `email.notifications` and `payment.notiication`.
- `logger.#` will forward messages from `logger.service1.module1` and `logger.service2`.

While publishing a message, the program must specify the exact routing key.

While consuming messages, the program must specific a wild card roting key so that it can consume messages from multiple exchanges.


```python
# Producer
import pika

connection = pika.BlockingConnection(
    pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

channel.queue_declare(queue='hello')

channel.basic_publish(exchange='', routing_key='hello', body='Hello World!')
print(" [x] Sent 'Hello World!'")
connection.close()
```


```python
# Consumer
import pika, sys, os

def main():
    connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
    channel = connection.channel()

    channel.queue_declare(queue='hello')

    def callback(ch, method, properties, body):
        print(f" [x] Received {body}")

    channel.basic_consume(queue='hello', on_message_callback=callback, auto_ack=True)

    print(' [*] Waiting for messages. To exit press CTRL+C')
    channel.start_consuming()

if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)
```
