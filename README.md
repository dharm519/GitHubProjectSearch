# GitHubProjectSearch

This is a rest service which takes language as input and lists all the projects using that language in github repository.
Maximun fetch size is 100 so user can provide laguage/pageNumber as input as well to list more projects.
username = admin
password = admin
Post Request : http://localhost:8180/api/authenticate -> This will return jwt token than needs to be passed on with tag "Bearer <token>" and execute below get requests.
Eg : http://localhost:8180/api/allProjectInfo/java
   http://localhost:8180/api/allProjectInfo/java/1
   http://localhost:8180/api/allProjectInfo/java/2
   http://localhost:8180/api/allProjectInfo/scala
   http://localhost:8180/api/allProjectInfo/scala/1
