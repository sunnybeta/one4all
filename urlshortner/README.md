<p align='center'>
    <h1 align='center'>URL Shortner</h1>
</p>

## Non Functional Requirements

* Very Low Latency
* Very High Availbility
* Fault Tolerant
* Scalable
* Consistency: Strong
* Durability
* Minimize Cost

## Functional Requirments

* Create a short URL
* Redirect to the original URL
* Analytics of incoming redirection requests
* Length of the URL 6 or 7
* Random Short URL
* User Account

## Questions

- How many URLs are we getting (traffic) per day to shorten?
- Till what time should those URLs be supported?
- Is this service for authenitcated users
- Is there a paywall ?

## APIs

```
POST /users/Login
PUT  /users/me/logout
POST /url {"url":"https://myWebsiteUrl/"} 201
GET  /redirect 302 Not Authenticated Rate Limiting Maybe :/
```

## Design

### Attempt 1

    User -> Internet -> Single Server
    
    - Not scalable
    - Not highly available
    - Does not ensure data durability

### Attempt 2

                                                Monitoring Service
                                      --> First Server ---+
    User -> Internet -> Load Balancer --> Second Server- -|-----> Data Store 
                                      --> Third Server ---+
    - Highly Scalable
    - Minimize Cost

### Attempt 3

TBA

## Notes

- Never create a single point of failure
