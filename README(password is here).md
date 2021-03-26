# Notes about WebApp and SpringWebApp
###### by M.Medvedev


- Connection properties are stored in local.properties  and are loaded from classpath
- By default database server is hosted at AWS RDS, but address and user credentials may be changed in local.properties
- WebApp (pure servlets) is designed to run on Tomcat 10 (Jakarta Ee)
- However, I was unable to make SpringWebApp (Spring) compatible with Tomcat 10, and so had to rollback to Tomcat 9. Thus SpringWebApp can only be deployed at Tomcat 9.
This is caused by the fact that Spring has inner javax dependencies, and Tomcat 10 does not support javax anymore (because of transition to Jakarta EE)


# How to run application
Both applications have pre-built war-files in respective directories


## Deleting products
To perform dome actions (deleting products), you need a password.
The password is: "WeakPassword"
