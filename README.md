# Background Check System

An example of a Spring boot service for conducting background checks with Temporal.
The service demonstrates how to leverage Activities for splitting steps of the
background check processing workflow and managing them resiliently.

The service is inspired from the documentation of Temporal `Build a Background Check application`
https://learn.temporal.io/tutorials/java/background-check/

## Install Temporal locally

Before we can start running the demo, we would need to install Temporal.
To do this if you have homebrew installed in your computer you can run the
following command:

```
brew install temporal
```

## Running the demo

We first need to start our temporal server.
To do this run the following command in your
terminal.

```
temporal server start-dev
```

The temporal server will acquire a port that is not in use
and will start up providing the following result.

```
CLI 1.3.0 (Server 1.27.1, UI 2.36.0)

Server:  localhost:7233
UI:      http://localhost:8233
Metrics: http://localhost:55724/metrics
```