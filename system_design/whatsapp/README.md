# Whatsapp System Design

**CONTENTS**

- Sent & Read Receipts
- Group Messaging
- Online / Last Seen

### Sent & Read Receipts
* Cannect to whatsapp on the cloud to one of many available gateways. 
* Maintain a `Session` microservice which stores information of the users and their connected gateways.
* This microservice now determines which user is connected to which gateway.
* Suppose Alice (gateway 1) sends a message to Bob (gateway 2)
    - When a messsage is recieved by the gateway service, we send some response confirming the message was received or `sent` status
    - Now the session service searches for Bob and tries to send the message.
    - Once we receive confirmation that Bob has received a message, we send a message back to the gateway that the message was sent successfully
    - Now, this gateway 2 sends a message back to the session service with the acknowledgement of successful message delivery.
    - Finally, session service sends a receipt back to Alice that the message was sent successfully. (Similar logic is applied for sent)
    - 

## Last Online

* We will require a *LastSeen* microservice
* Any activity of the user on the platform can be logged and the last online for a user can be stored on a table
* There are two types of messages: system activity (should not be logged) + user activity (should be logged)
* When we open our chat, we can retrieve the last seen of all the users.

## Group Messaging

* Group Service: Figures out who exists in a particular group
* A user sends a message to a group -> Session service receives the message -> Asks the group service who are the users of the group
* Save the message in queue once received by the session service just in case group service fails
* A similar logic foolows for sent message
