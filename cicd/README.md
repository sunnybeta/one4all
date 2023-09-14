# Continuous Integration & Continuous Deployment

## CI/CD Pipeline

### Source Code

1. Write neat and clean code with some coding guidelines or standards.
2. It is good to keep some reviewers so that nobody blindly pushes something which
may break your application.


### Build

1. Compile Source and Dependencies
2. Run Unit Tests
3. Check and Enforce Code Coverage

### Test Environment

1. Run Integration Tests

### Production Environment

1. Make sure your dev changes reflect exactly in production
2. Have alarms on errors, latency & key business metrics automatically
3. Ability to quickly rollback 
4. Bake Period - 24 Hours
5. Canary: Soemthing which tests production with expected input and output like a bot or cronjob

### Bonus

- Have a on/off switch to skip specific steps
- Have separate databases for test and production
- Make sure the correct environment, variables and database is loaded for a
specific environment


