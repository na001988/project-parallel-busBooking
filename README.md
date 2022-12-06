# project-parallel-busBooking
Maven project to demonstrate parallel test execution, using selenium grid, standalone server and testNG for a web booking application


Commads to run on Windows OS:

java -jar selenium-server-standalone-3.141.59.jar -role hub -timeout 30 -browserTimeout 60

java -jar -Dwebdriver.chrome.driver="chromedriver.exe" selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -browser "browserName=firefox,version=latest,maxInstances=7,seleniumProtocol=WebDriver" -browser "browserName=chrome,version=latest,maxInstances=7,seleniumProtocol=WebDriver"

java -jar -Dwebdriver.firefox.driver="firefox.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register/ -browser "browserName=firefox,version=latest,maxInstances=7,seleniumProtocol=WebDriver" -browser "browserName=chrome,version=latest,maxInstances=7,seleniumProtocol=WebDriver"