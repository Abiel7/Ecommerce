# Ecommerce_Fullstack


This is a fullstack ecommerce application. API(backend) for this apllication is created using Swagger Codegen, after a yaml file was created with  path  and schemas specification, SwaggerCodegen will  build both  the  model objects and api interface.   
![image](https://user-images.githubusercontent.com/56592834/156747919-e2bde18a-8f8f-473c-a2b2-8a968ef08877.png)

**Build the necessary elements to run the backend**

`cd backend`

`./gradlew build` or `./gradlew clean build`.

`java -jar .\build\libs\backend-0.0.1-SNAPSHOT.jar`       

**Testing**

`curl --request GET 'http://localhost:8181/api/v1/carts/1' --header 'Accept: application/json'` or you can replace the json part with xml
