#! /bin/bash
osascript -e 'tell app "Terminal"
    do script "cd Documents/seleniumgrid/ &&
    java -jar selenium-server-standalone.jar -role hub -hubConfig hub.json"
end tell'
osascript -e 'tell app "Terminal"
    do script "cd Documents/seleniumgrid/ &&
    java -jar -Dwebdriver.chrome.driver=/usr/local/bin/chromedriver selenium-server-standalone.jar -role node -nodeConfig node.json"
end tell'