# 🛡️ Insurance Microservice System

This repository demonstrates a **microservice-based insurance platform** built with **Spring Boot 3.3.x** and **Spring Cloud 2023.x**.  
The focus is on **service discovery, resilient communication, asynchronous messaging, and distributed tracing**.

---

## 📐 Architecture Overview

The system is composed of several independent services, each responsible for a specific domain:

- **Eureka Server** → Central service registry for discovery.
- **API Gateway** → Entry point for all external requests, routing traffic to backend services.
- **Insurance Service** → Handles insurance policy payments and persistence.
- **Validation Service** → Validates customer and vehicle information before processing.
- **Notification Service** → Sends notifications to users after successful transactions.
- **RabbitMQ Module** → Provides messaging infrastructure for asynchronous communication.
- **Clients Module** → Shared Feign client definitions for inter-service REST calls.

---

## 🔄 Workflow

1. **User Request**  
   - A client sends a `POST /insurances/payment` request through the **API Gateway**.

2. **Insurance Service**  
   - Receives the request and validates customer and vehicle data by calling the **Validation Service**.
   - If validation succeeds, payment is processed and stored in the database.

3. **Notification Service**  
   - After a successful payment, the **Insurance Service** triggers a notification event.  
   - This can be done via **RabbitMQ messaging** or a **Feign client call** to the Notification Service.

4. **Distributed Tracing**  
   - All interactions are traced using **Micrometer Tracing + Zipkin**, allowing developers to visualize request flows across services.

5. **Service Discovery**  
   - Each service registers itself with **Eureka Server**.  
   - The **API Gateway** and Feign clients resolve service locations dynamically via Eureka.

---

## 📊 Observability

- **Eureka Dashboard** → Shows all registered services and their health status.  
- **Zipkin UI** → Displays distributed traces for requests, enabling debugging and performance analysis.  
- **RabbitMQ Management Console** → Monitors queues, message flow, and consumer activity.

---

## ✨ Key Features

- Modular Maven structure with BOM inheritance.
- Service discovery and load balancing via Eureka.
- API Gateway routing with Spring Cloud Gateway.
- Resilient inter-service communication using OpenFeign.
- Asynchronous messaging with RabbitMQ.
- Distributed tracing with Micrometer + Zipkin.
- Clear separation of concerns across services.

---

## 📌 Purpose

This project is designed as a **reference implementation** for building resilient, observable, and maintainable microservice ecosystems.  
It highlights best practices in **service registration, communication patterns, and monitoring** within a Spring Cloud environment.
