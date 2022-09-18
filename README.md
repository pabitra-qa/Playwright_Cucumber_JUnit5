# Playwright_Cucumber_JUnit5

## Tech Stack Used
- Java v1.8
- Playwright v1.25.0
- Cucumber v7.7.0
- JUnit5
- log4j v2.18.0
- allure
- gherkin v24.0.0
- surefire v3.0.0-M5

## Execution Options
This Project provides multiple ways to execute the tests.
1. Parallelly
    - Scenarios in parallel.
    - Features in parallel. i.e. the Scenarios of any feature will be executed sequentially by one thread.
2. Sequentially

These can be configured in pom.xml file by updating the properties as per your requirement.

>\<parallel>true\</parallel> -- change it to *__false__* to execute tests sequentially

>\<execution.type>same_thread\</execution.type> -- this means Features will be executed parallelly. change it to *__concurrent__* to execute scenarios in parallel.

>\<threads>2\</threads> -- user this to control the threads incase of parallel execution.

*Either you can directly change these values or you can pass them at run time. Here is an example below.*

>*mvn clean install -Dparallel=true -Dthreads=2 -DexcludedGroups=skipScenario*

## Credentials (Username, Password) at the run time

>\<username>test_user\</username>
>\<password>test_password\</password>

*Either you can directly change these values or you can pass them at run time. Here is an example below.*

>*mvn clean install -Dparallel=true -Dthreads=2 -DexcludedGroups=skipScenario -Dusername=pabitra -Dpassword=swain@123*
