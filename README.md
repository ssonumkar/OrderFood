Kafka Setup:
1. Create a free account at [confluent kafka]([url](https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwiMvsWTt7OHAxX6poMHHU0XFIcYABAAGgJlZg&co=1&ase=2&gclid=CjwKCAjwnei0BhB-EiwAA2xuBkmPHm6wen2-zEd-92jKeztCISIEYnXF2VVGpF7LTSHUT2EcABvYFBoCxbEQAvD_BwE&ei=yYeaZsCzFfSG9u8P-_GdkAs&ohost=www.google.com&cid=CAESVuD2_r4DlZmP8j-cgH7FXWJl4LLrEjyi_tOpx6ymQSY7Abr184qsixLSV1SY_ioL64G_8Q9PpW-7a56RmpRyVFhmnhvmTJ3t9hSsYE_FXtcNUhgzROHi&sig=AOD64_1yIijxIr6qW6GfFRtpqQB4NSYsyQ&q&sqi=2&nis=4&adurl&ved=2ahUKEwiAvMCTt7OHAxV0g_0HHft4B7IQ0Qx6BAgXEAE))
2. Create a cluster and a topic
3. Add a json schema from the main/resources/schema-test-value-v1.json for the topic
4. Configure the client from the confluent [https://confluent.cloud/environments]([url](https://confluent.cloud/environments))
5. Generate the key and secret
6. Generate the configurations 
7. Get the spring.kafka.producer.sasl.jaas.config and spring.kafka.producer.bootstrap-servers from this configuration and update src/main/application.properties


Import project using **git clone https://github.com/ssonumkar/OrderFood.git**
Install java 17 and Inteliij
Import the dependencies
Build the project
Run the project
