# MS_NSE_Workspace_6_6_2024
A micro-service based architecture has been configured in it. It includes followings<br>
<br>[1] **Config-Server:** A Centralized configuration files for all micro-services are accessed though a Config-server while booting up each service.
<br>[2] **Eureka-Discovery-Server:** This server has been configured to check the heart-beats of each micro-service available in your micro-service echo system. It assigns a unique id to each registered micro-service.
<br>[3] **Spring-Cloud-Gateway:** A gateway has also been configured in it so that all the calls from different clients come through the single gate. Different filters have been implemented to track each request and its response.
<br>[4] **Jaeger with micrometer:** It has been configured for monitoring all the logs of different micro-services at a centralized location.
<br>[5] **Temporal-Server:** For managing any workflow, a Temporal Server has been configured. Temporal-Server web-UI can be used to monitor and analyse different state of a workflow.
<br>[6] Centralized Logging and Exception & Error handling: AOP has been used for collecting logs and Exception and error handling.
