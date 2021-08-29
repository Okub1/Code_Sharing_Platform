# Code_Sharing_Platform
Jetbrains Academy project

Also contains multiple tasks from previous topics.

<h2><b>Final project (stage 5/5) can be found at Code_Sharing_Platform/task</b></h2>

Technologies used:
Spring Boot framework,
JPA - Java Persistence API,
H2 database,
Freemaker - template engine,
Gradle

Concepts used:
MVC,
REST, 
CRUD,
UUID,
layered architecture (Presentation, Business, Persistence, Database)

<h3>Installation & usage</h3>

<ol>
<li>Import project from Code_Sharing_Platform/task to IntelliJ as project from resources,
<li>run app
</ol>

<ul>
  <li> app can be accessed via localhost:8889 (can be changed in file application.properties)
  <li> API endpoints:
    <ul>
      <li> ../api/code/{uuid} (returns code snippet, date and restriction modifiers as JSON)
      <li> ../api/code/new (returns uuid)
      <li> ../api/code/latest (returns newest 10 unrestricted code snippets as JSON)
    </ul>
    
  <li>HTML? endpoints:
    <ul>
      <li> ../code/{uuid} (shows snippet with provided uuid)
      <li> ../code/new (provides form for addition of new code snippets)
      <li> ../code/latest (shows newest 10 unrestricted modifiers)
      <li> ../h2-console (for access to H2 database, can be changed in application.properties, where can be also found file, login and password to gain access into DB)
    </ul>
</ul>

<h3>Known bugs</h3>
  <i>none, app is perfect</i>
  
<h3>Screenshots</h3>
<img src="https://user-images.githubusercontent.com/37751054/131235310-59798769-0df0-471e-86d8-82119b60ac59.png">
