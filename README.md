# bucketlisters-backend-challenge

This challenge is a simplified replica of a ticket management platform, designed to consume and list events from both our internal database and external APIs. <br> 
With this approach, we aim to simulate a realistic data integration scenario, allowing for efficient and scalable manipulation and display of event information.

## API Domain

### Experience
An experience is a set of events belonging to the same partner, consisting of representing a festival, a restaurant season, parks, and more.

### Event
An Event takes place at a specific single. Other systems may refer to this as “time slot”. An Event is always associated with an Experience.

## Environment Setup
1. Install Java 17 or Higher.<br>
I recommend SDKMAN! which makes this as simple as:
   ```
   sdk install java 17.0.7-zulu
   ```
2. gradle-8.10.2 or Higher
3. Use your favorite code editor to open and work on the code
4. Executing the code with:
   ```
   ./gradlew bootRun
   ```   
5. [Local Swagger](http://localhost:8585/swagger-ui/index.html#)

![img.png](images/img.png)

### Challenge

The current API version provides 2 endpoints for event search. The challenge is to create a third endpoint that provides both external and internal events in the same structure.

This new feature must meet the following criteria:

- The new feature should only return an error when the experience does not exist.
- The new feature must follow the ordering by Event::startTime.
- The new feature must be resilient in case of external integration failure.
- The new feature should be as optimized as possible.
