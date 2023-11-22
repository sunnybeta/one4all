# Twitter System Design

## Functionality

- User Authentication
- User can tweet
- Users can follow other users
- Users see a timeline of people they follow

## App Design

- page of tweets
- on top there is a *new tweet* button
- new tweet screen 200 characters
- profile page: user name, profile picture, follow, unfollow

## Endpoints

`POST /tweet`

**Request**

```json
{
    'content': 'XOXO',
    'timestamp': '2023-10-23T12:34:09'
}
```

**Response**

```json
{
    'tweet_id': 'twt_dm19034ncoa9'
}
```

`POST /follow`

**Request**

```json
{
    'user_id': 'user_mcm139c0',
    'timestamp': '2023-10-23T12:34:09'
}
```

**Response**

```json
{
    'status': 'OK'
}
```

`POST /unfollow`

**Request**

```json
{
    'user_id': 'user_mcm139c0',
    'timestamp': '2023-10-23T12:34:09'
}
```

**Response**

```json
{
    'status': 'OK'
}
```
## Timeline

`GET /timeline`

- Since we don;t want to load all the tweets of a user at a time, we will use pagination.
- We would like to get `n` tweets per page. This variable `n` will be kept on the server side.
- If there is a new tweet, then there is an overlapping for the next page of tweets. Thus, we use a combination of the last tweet ID along with the page size `n` 
- For real-time updates, we can poll for changes for example every 10 seconds. This may *NOT* be the best way.

## Basic Design

User -> Rest API -> SQL DB

## Database Schema

### User

```json
{
    "id": "BIGINT",
    "username": "VARCHAR(30)"
}
```
### Tweet

```json
{
    "id": "BIGINT",
    "user_id": "User(FK)",
    "content": "VARCHAR(200)",
    "time": "TIMESTAMP"
}
```

### Follows

```json
{
    "user_id": "User(FK)",
    "follow_id": "BIGINT"
}
```

## System Load

- As the number of users / clients increase, we would like to use a Load Balancer which then sends the request to a REST API on one of the servers.
- To deal with database failures, we will use a leader-follower model where all the writes will be directed to the master and this data will be propagated to the follower databases for handling all the reads.
- The master is now a single point of failure for all our writes.

