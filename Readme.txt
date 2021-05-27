Maven
-------------------------------------------------------------------------------------------------------------------
Build Tool (like ant), project management tool

problems and activities :
1.Multiple jars (make sure jars are available and bundle them while deploying in distributions)
2.Dependency and version (one jar is dependent on other,junit might be dependent on other jars, so we dont need to bother about that)
3.Project structure
4.Build, publish and deploy

mvn --version

mvn needs to connect to repository, so internet is required

mvn compile --> class files
mvn package --> generate jars files, also run our test cases (java -cp MyApp-1.0-SNAPSHOT.jar com.bosch.test.App)
mvn validate : pom.xml, structure
-------------------------------------------------------------------------------------------------------------------
REpresentational State Transfer

Data exchange format(JSON popularly)
Transport (HTTP only)
Service Definition (WADL/Swagger/..)
-------------------------------------------------------------------------------------------------------------------
L1
A web service/app is any piece of software that makes itself available over the internet

https://www.google.com/search?q=sachin

search is API exposed by google
Google by default runs on port 443

https://www.google.com:443/search?q=sachin

https://www.google.com:8080/search?q=sachin  ==> This will not work

https://api.github.com/search/users?q=mpsshubham

Most of the API's return data in JSON Format

Why getter/setter : to control to set the values
Why function overloading : so that user dont have to remember lot of api's

Encapsulation : Hiding data
Abstraction : Hiding implementation details/complexity

for persistance storage data has to be stored in hard disk : Database/Files
database : faster searching/insertion, security
files : images, videos
-------------------------------------------------------------------------------------------------------------------
L2

Dependency Management : Maven and Gradle

API : SOAP/REST
SOAP : Lot of rules (what should be the response...need to be written in WSDL File), more restrictive
REST : Stateless, easier to use

Get
Post Insert
Put Update
Delete

produces consumes
-------------------------------------------------------------------------------------------------------------------
L3
Maven and MultiThreading

Maven : Build Tool : (how to bundle and package your application) --> analogus to npm in js,gemfile in ruby on rails
dependency

mvn --version, ./m2 folder
Maven : Local Central and Remote Repository (Remote repository is like local to organisation -> Nexus)

clean
validate
compile
test
package
verify
install
site
deploy

mvn package will perform clean, validate, compile, test

Concurrency is when two or more tasks can start, run, and complete in overlapping time periods.
It doesn't necessarily mean they'll ever both be running at the same instant. For example, multitasking on a single-core machine.

Parallelism is when tasks literally run at the same time, e.g., on a multicore processor.

JStack can be used to take thread dump to debug your applications in production environment

daemon thread : Background thread, java garbage collector, you dont have to wait for daemon thread to complete, as application stops daemon thread also stops
daemon thread can be used to delete temp files at the end of code
-------------------------------------------------------------------------------------------------------------------
L4
MT and jdbc

synchronised : critical section only one process should be allowed to run
two types : 1. Object level : MyObj obj1, MyObj obj2, Thread T1,T2 operates on obj1 and Thread T3 operates on obj2, so now only one of T1, T2 can execute at a time, but T1, T3 or T2, T3 can execute simultaneously
			2. Class level : MyClass {
								public static void calculate() {
								}
							}
				only one Thread can call calculate function

volatile : that variable will not be local to the threads, all threads share that variable
useful for database connection, you can make connection variable volatile
thread t1 will have separate memory, t2 will have separate but volatile variable will be shared by two threads (main memory)

JDBC is protocol like HTTP
you can also use curl to hit api's from command prompt
curl -XPOST "127.0.0.1:8080/createTable?q=person"
-------------------------------------------------------------------------------------------------------------------
L5
Hibernate : implementation of JPA (various frameworks provide JPA, hibernate is one of them)
Hibernate is ORM Framework : Object Relation Mapping
IOC : Inversion of Control : entity managing lifecycle of object, we dont have to create object
we just have to tell ioc container to manage lifecycle of these classes/objects, then it will create an object, store the reference, destroy object, in other way manages lifecycle of the object, inverting the control from ourself to other entity(spring IOC)

Bean : Java Objects created and managed by spring framework

IOC creates all beans when application loads

Dependency Injection : Injecting an object into some other object (service obj can be autowired in RestController Class)
					   When one class needs some other object then that class dont need to worry, as all objects are already created

Bean Scope : Singleton (Default)
			 Prototype (new instance everytime)

Beans can be defined in XML(old) or by annotations(mostly used)

While running your application spring does class path scanning
it checks for classes that has @Component annotation, other classes are ignored for beans

@RestController is also dependent on @Component, thats why those classes are loaded on startup

With spring data JPA dependency empty project will not run as providing Database URL is compulsary

@Entity : this represents Database table and there is ORM(Object Relation Mapping , from db table to java object and vice versa)
H2 Database : In memory db like Redis. When application stops, database serve no purpose and data is lost

@Component is of different type : @Controller, @Repository, @Service
its like inheritance, these three have more functions apart from @Component
@Repository : DBManager, interacting with db
ApplicationContext represents IOC : is interface for IOC
ApplicationContext has different implementation : ClassPathXmlApplicationContext, AnnotationApplicationContext...

@Bean : Whenever we annotate function with @Bean, then that class needs to be annotated by @Configuration annotation so that spring ioc can pick this class //custom bean
@Bean can be applied on method, not on class
@RestController can be applied to classes, interfaces and enums
Spring defines default ApplicationContext if we dont define

JPA : Java Persistance API
persistance storage (DB)
JPA is like interface, contract -> framework : Hibernate, EclipseLink, OpenJPA

JPA is only for SQL Databses

SQL   : ourRepository -> JpaRepository -> pagingandsorting -> CrudRepository -> .... -> Repository
NoSQL : ourRepository -> MongoRepository -> pagingandsorting -> CrudRepository -> .... -> Repository

Also try hibernate_sequence for primary key (generationtype -> auto) , select * from hibernate_sequence, if we insert from sql workbench hibernate_sequence will not increment, so again adding new entry from code will result in duplicate id(error)
if you use generationtype auto, never use sql workbench to insert data in tables


generationtype -> identity (Sql will handle)

Sql					NoSQL
Tables				Collection
Row/Object			Document
Column				key/value

SQL has definite schema...waste size (if we dont have author or other columns for book, still size will allocated)

Use mongo altas, install mongo shell and try to connect via terminal, also add your ip to ip whilelist if connection fails

NoSql :
Flexible Schema
less storage
operations latency are somewhat higher(disadvantage)


No primary key, joins
to make searching better indexing can be used

mongo creates object id automatically
object id is created by machine identifier + timestamp + random string

google mongo object id to timstamp and try converting

ngrok http:8080 will provide domain name for our service and thus make api public

resttemplate is in built class which can be used to call other api's

JPQL and native sql query
RestTemplate vs WebClient

Swagger for documentation

Spring Security
------------------------------------------------------------------------------------------------------
Authorization - if allowed to perform this operation

Authentication - valid user

first authentication is performed then authorization

400 - bad request
401 - unauthorize, it means you are not authenticated, failing authentication
403 - forbidden access, failing authorization
404 - not found

just including the dependency for spring security, in logs we can see generated security password and hitting simple api will also naviagte to /login page

default username is user and pwd is in console
when u login and hit some request, and then we want to hit some other request, then we dont have to login again,
so it means spring stores username and pwd in application context unless we log out or restart app

Now if we want to have our own username and password, we can add in application.properties
but again if we want multiple username and passwords we have to create Config class and extend WebSecurityConfigureAdapter and annotate @EnableWebSecurity

There is filter chain (50-100) (see o/p console) in that there is authentication also

Roles and Authority are similar, if we give admin, then authority will be admin only and role will be ROLE_admin

userdetails kind of authentication means user will enter username pwd and then we will fetch entries from db and match them, so there is db call, so for every request there is one db call

JWT : in jwt client sends username pwd, then from db it is matched and also jwt token is returned from server, so for next calls, client can simply use that token and server will authenticate using that token

JWT allows to convert java object to string and vice versa without any loss of information

Steps :
1) User (implements UserDetails) is converted to token
2) for further calls, client will send token to server, server will extract username from token, check in db if username exist (only once)
Then it will store user object(user details,username pwd, session cookies) in securityContext
3) now for further calls client sends jwt token and server extracts username from token but this time user details are present in security context

assume it is like cache, we now have to search in 127.0.0.1:8080(localhost, current application) and not in sql (127.0.0.1:3306)


Expiry time of token say 24 hrs, so if we login some site and try to access something after 5-10 mins, we dont have to login again(that functionality is through tokens)


Claims is what u want to put in token(username, pwd, authorities), subject is our main claim(mostly username)
refer jwt.io
jwt consist of 3 parts : header, payload, signature
header is same for all entries if algo used is same

client can store jwt in local storage, session storage, cookie(if jwt is sent by server in cookie)
------------------------------------------------------------------------------------------------------
OAuth 2.0

login using some other services(google, fb, gmail).
User does not have to provide username pwd

So OAuth is all about authorization (no authentication)
user is authorizing us to use fb profile

Terminology

User : person using spring boot app(abc.com)
OAuth Client : Spring boot app(Server). it is called client because our app is client for fb Authorization server asking access of fb profile
Authorization Server : when user allows to access, authorization server sends token to OAuth Client (this is just token sending service of fb, resoruce is somewhere else)
Resource Server : When OAuth client receives token it sends request to resource server for actual resource (fb profile) and then resource server gives that to OAuth Client

our Spring boot app need to register with fb, linkedin, twitter .... that i am valid OAuth Client as fb, twitter needs to know the app which is requesting service is not malicious app, they cannot service everyone
So when our spring boot app register with fb twitter they send client id, client secret key for our app, fb will send different twitter will send different

developers.facebook.com/apps login and then it will list your apps with OAuth Client, id, pwd
developers.google.com
------------------------------------------------------------------------------------------------------
Redis

Redis is an open source in-memory data structure store, used as a database, cache, and message broker
Redis provides persistance as it stroes data in RAM as well as HD
So Post call will be expensive as we have to store in cache as well as HD
But Get calls will be fast and if our app mostly has Get calls(80% case) it is very good

Redis/MemCache/AeroSpike

Web App(Spring Boot) ------ Cache(RAM) ------ DB(MySQL) HD

LRU - Lease Recently Used - by default redis uses LRU
LFU - Lease Frequently Used

Front end can directly interact with DB using firebase (no backend required)
we can interact with redis through terminal or code(java or spring)
https://redis.io/commands

there are many redis client for every language
https://redis.io/clients

RedisTemplate in Spring

Cache ideally should be used with static data (not changing everytime)
Before storing data in cache we should serialize the data (so that others cannot read it easily)
there are two types of keys : normal keys(Set,Get), hash keys(HSet,HGet)

To avoid single point of failure and for scalability, we need clustering(Master-Slave architecture)
While doing set in master-slave, we first set in master and then master propagates to slaves

So our bottleneck becomes the master, say master can process only 100req/s then it becomes app limit
So we ideally have multiple master slave system and use sharding technique(id 1-1000 on 1 master slaves, 2-2000 on 2nd master slave)

so we use clustering in redis, with some duplication factor say 2, so same data will be there on 2 more redis server

------------------------------------------------------------------------------------------------------
Kafka

Apache Kafka is an open-source distributed event streaming platform used for high-performance data pipelines, streaming analytics, data integration, and mission-critical applications

Mainly used as message queue (to create asynchronous api)

SendMoney and SendMail can be async api's, it means we can first call sendmoney api and sendmail can be push to message queue like kafka.
If both api are synchronous then it might take time to sendmail

To get transaction history in excel, we can use kafka, we will give response to this api - sending to your mail, push the query to message queue and then in send via mail

Message queue will have producer and consumer
There can be multiple producers and consumers, Producer p1,p2 can produce topic1 type of messages and p3 topic2 messages
Consumer c1 can subscribe to both topic1 and topic2

ZooKeeper is used in distributed systems for service synchronization and as a naming registry.  When working with Apache Kafka, ZooKeeper is primarily used to track the status of nodes in the Kafka cluster and maintain a list of Kafka topics and messages

https://kafka.apache.org/quickstart
Heroku(by salesforce, free) can be used to deploy app instead of aws

We can also use Profiles in Spring boot project so that dev prod test can point to different mysql,redis,kafka servers
https://dzone.com/articles/spring-boot-profiles-1